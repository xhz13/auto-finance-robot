package com.finance.financerobot;

import java.io.IOException;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;


public class EsClientGETTest {
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
    public static void main(String[] args) {
        ElasticsearchClient esClient = EsClientTest.esClient; // 假设这是你已经初始化的客户端

        try {
            SearchRequest searchRequest = new SearchRequest.Builder()
                    .index("index_urls")
                    .suggest(suggestBuilder -> suggestBuilder
                            .suggesters("title_suggest", suggesterBuilder -> suggesterBuilder
                                    .text("万科")
                                    .completion(completionSuggesterBuilder -> completionSuggesterBuilder
                                            .field("name")
                                            .skipDuplicates(true)
                                            .size(10)
                                    )
                            )
                    )
                    .build();

            SearchResponse<JsonData> response = esClient.search(searchRequest, JsonData.class);

            // 处理响应
            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
