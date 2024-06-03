package com.finance.financerobot;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.Test;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.transport.rest_client.RestClientTransport;

public class EsClientGETStockTest {
    public static ElasticsearchClient esClient;
    static {
        BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
            new UsernamePasswordCredentials("elastic", "ilTvMR8ZRTZBtFNg_w3z")); // 使用您的用户名和密码

        RestClient restClient = RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
            .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider))
            .build();

        RestClientTransport transport = new RestClientTransport(restClient, new co.elastic.clients.json.jackson.JacksonJsonpMapper());
        esClient = new ElasticsearchClient(transport);
    }
    @Test
    public void getStockSuggestion()  {
        SearchResponse<JsonData> response=null;
        SearchRequest searchRequest = new SearchRequest.Builder()
                .index("stock")
                .suggest(suggestBuilder -> suggestBuilder
                        .suggesters("title_suggest", suggesterBuilder -> suggesterBuilder
                            .text("万")
                            .completion(completionSuggesterBuilder -> completionSuggesterBuilder
                                    .field("stknm")
                                    .skipDuplicates(true)
                                    .size(10)
                                    )
                            )
                    )
                    .build();
        try{
        response = esClient.search(searchRequest, JsonData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(response);
    }
}
