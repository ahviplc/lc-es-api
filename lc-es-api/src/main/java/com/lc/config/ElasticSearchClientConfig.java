package com.lc.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * spring两个步骤 1：找对象 2.放到代理中待用 3.如果是SpringBoot 就先分析源码
 *
 *  ###AutoConfiguration xxxProperties
 * <p>
 *  new HttpHost("localhost", 9201, "http")));
 */
@Configuration
public class ElasticSearchClientConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));
        return client;
    }
}
