package com.lc;

import com.alibaba.fastjson.JSON;
import com.lc.pojo.User;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * es 7.6.2 高级客户端测试 API
 */
@SpringBootTest
class LcEsApiApplicationTests {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

//    @Test
//    void contextLoads() {
//    }

    // 测试 索引的创建 Request
    @Test
    void testCreateIndex() throws IOException {
        // 1. 创建索引的请求
        CreateIndexRequest request = new CreateIndexRequest("es_db_index_by_sb");
        // 2. 客户端执行请求 IndicesClient 请求后获得的响应createIndexResponse
        CreateIndexResponse createIndexResponse = null;
        try {
            createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
            System.out.println("索引的创建成功");
            System.out.println(createIndexResponse);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 测试获取索引 此索引是否已存在
    @Test
    void testExistsIndex() throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest("es_db_index_by_sb2");
        boolean exists = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    // 测试删除索引
    @Test
    void testDeleteIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("es_db_index_by_sb");
        AcknowledgedResponse acknowledgedResponse = null;
        try {
            acknowledgedResponse = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
            System.out.println("索引的删除成功");
            System.out.println(acknowledgedResponse.isAcknowledged());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 测试添加文档
    @Test
    void testAddDocument() throws IOException {
        //创建对象
        User lcUser = new User("LC", 18);
        IndexRequest request = new IndexRequest("es_db_index_by_sb");

        //新增规则 put /es_db_index_by_sb/_doc/1
        request.id("1");
        request.timeout(TimeValue.timeValueSeconds(1));
        request.timeout("1s");

        //将我们的数据放入请求 json
        //下面返回 IndexRequest source =
        request.source(JSON.toJSONString(lcUser), XContentType.JSON);

        //客户端发送请求
        try {
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
            System.out.println(indexResponse.toString());
            System.out.println(indexResponse.status());//CREATED
            System.out.println("添加文档成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 获取文档 判断是否存在 GET /index/doc/1
    @Test
    void testExistsDocument() throws IOException {
        GetRequest getRequest = new GetRequest("es_db_index_by_sb", "1");
        //不获取返回的 _source上下文
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");
        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    // 获取文档信息 GET /index/doc/1
    @Test
    void testGetDocument() throws IOException {
        GetRequest getRequest = new GetRequest("es_db_index_by_sb", "1");
        try {
            GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
            System.out.println(getResponse.getSourceAsString());//打印文档的内容
            System.out.println(getRequest);
            System.out.println(getResponse);
            // {"age":18,"name":"LC"}
            // get [es_db_index_by_sb][_doc][1]: routing [null]
            // {"_index":"es_db_index_by_sb","_type":"_doc","_id":"1","_version":1,"_seq_no":0,"_primary_term":1,"found":true,"_source":{"age":18,"name":"LC"}}
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 更新文档信息
    @Test
    void testUpdateDocument() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("es_db_index_by_sb", "1");
        updateRequest.timeout("1s");
        User user = new User("LC2", 18);
        updateRequest.doc(JSON.toJSONString(user), XContentType.JSON);
        try {
            UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
            System.out.println(updateResponse.status());//OK
            System.out.println(updateRequest);
            System.out.println(updateResponse);
            System.out.println("更新文档信息成功");
            // OK
            // update {[es_db_index_by_sb][_doc][1], doc_as_upsert[false], doc[index {[null][_doc][null], source[{"age":18,"name":"LC2"}]}], scripted_upsert[false], detect_noop[true]}
            // UpdateResponse[index=es_db_index_by_sb,type=_doc,id=1,version=2,seqNo=1,primaryTerm=1,result=updated,shards=ShardInfo{total=2, successful=1, failures=[]}]
            // 更新文档信息成功
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 删除文档记录
    @Test
    void testDeleteDocument() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("es_db_index_by_sb", "1");
        deleteRequest.timeout("1s");
        try {
            DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
            System.out.println(deleteResponse.status());
            System.out.println(deleteRequest);
            System.out.println(deleteResponse);
            System.out.println("删除文档记录成功");
            // OK
            // delete {[es_db_index_by_sb][_doc][1]}
            // DeleteResponse[index=es_db_index_by_sb,type=_doc,id=1,version=3,result=deleted,shards=ShardInfo{total=2, successful=1, failures=[]}]
            // 删除文档记录成功
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 特殊的 项目都会 批量插入数据
    @Test
    void tesBulkDocument() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("lc1", 1));
        userList.add(new User("lc2", 2));
        userList.add(new User("lc3", 3));
        userList.add(new User("lc4", 4));
        userList.add(new User("lc5", 5));
        userList.add(new User("lc6", 6));
        userList.add(new User("lc7", 7));
        userList.add(new User("lc8", 8));
        userList.add(new User("lc9", 9));
        userList.add(new User("lc10", 10));

        //批处理请求
        for (User userFromList : userList) {
            //批量更新和批量删除,就在这里修改对应的请求就可以了
            //System.out.println(userFromList);
            bulkRequest.add(
                    new IndexRequest("es_db_index_by_sb")
                            .id("" + UUID.randomUUID().toString().substring(0, 4)) //要是不配置 会使用官方自己的生成规则
                            .source(JSON.toJSONString(userFromList), XContentType.JSON));
        }
        try {
            BulkResponse bulkItemResponses = client.bulk(bulkRequest, RequestOptions.DEFAULT);
            System.out.println(bulkItemResponses.hasFailures());//是否失败 返回false代表成功
            System.out.println("批量新增成功");
            // false
            // 批量新增成功
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // 查询
    // SearchRequest 搜索请求
    // searchSourceBuilder 条件构造
    // HighLighterBuilder 构建高亮
    // TermQueryBuilder 精确查询构造
    // MatchAllQueryBuilder
    // xxx QueryBuilder 对应我们刚才看到的命令
    @Test
    void testSearch() throws IOException {
        SearchRequest searchRequest = new SearchRequest("es_db_index_by_sb");
        //构建搜索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //searchSourceBuilder.highlighter();

        // 查询条件 可以使用QueryBuilders工具来实现
        // QueryBuilders.termQuery() 精确
        // QueryBuilders.matchAllQuery() 匹配所有
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "lc6");
        // MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        searchSourceBuilder.query(termQueryBuilder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(searchResponse.getHits()));
        System.out.println("=========================================");
        for (SearchHit documentFields : searchResponse.getHits().getHits()) {
            System.out.println(documentFields.getSourceAsMap());
        }

        //    {"fragment":true,"hits":[{"fields":{},"fragment":false,"highlightFields":{},"id":"c4e3","matchedQueries":[],"primaryTerm":0,"rawSortValues":[],"score":2.1282315,"seqNo":-2,"sortValues":[],"sourceAsMap":{"name":"lc6","age":6},"sourceAsString":"{\"age\":6,\"name\":\"lc6\"}","sourceRef":{"fragment":true},"type":"_doc","version":-1},{"fields":{},"fragment":false,"highlightFields":{},"id":"522b","matchedQueries":[],"primaryTerm":0,"rawSortValues":[],"score":2.1282315,"seqNo":-2,"sortValues":[],"sourceAsMap":{"name":"lc6","age":6},"sourceAsString":"{\"age\":6,\"name\":\"lc6\"}","sourceRef":{"fragment":true},"type":"_doc","version":-1}],"maxScore":2.1282315,"totalHits":{"relation":"EQUAL_TO","value":2}}
        //    =========================================
        //    {name=lc6, age=6}
        //    {name=lc6, age=6}
    }
}
