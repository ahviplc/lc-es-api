package com.lc.utils;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;

import java.io.IOException;

public class ESUtils {

    /**
     * IsExistsIndex
     * 判断索引是否存在
     *
     * @param indexName
     * @return
     * @throws IOException
     */
    public Boolean IsExistsIndex(String indexName, RestHighLevelClient restHighLevelClient) throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest(indexName);
        boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        //System.out.println(exists);
        return exists;
    }

    /**
     * CreateIndex
     * 创建索引
     *
     * @param indexName
     * @throws IOException
     */
    public void CreateIndex(String indexName, RestHighLevelClient restHighLevelClient) throws IOException {
        // 1. 创建索引的请求
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        // 2. 客户端执行请求 IndicesClient 请求后获得的响应createIndexResponse
        CreateIndexResponse createIndexResponse = null;
        try {
            createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
            System.out.println(indexName + " 索引的创建成功......");
            //System.out.println(createIndexResponse);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
