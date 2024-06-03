package com.finance.financerobot;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import co.elastic.clients.transport.rest_client.RestClientTransport;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;

import com.fasterxml.jackson.databind.ObjectMapper;



public class EsClientTest {

    
    public static ObjectMapper objectMapper = new ObjectMapper();
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
        try {
            BooleanResponse response = esClient.ping();
            if (response.value()) {
                System.out.println("success");
            } else {
                System.out.println("Elasticsearch cluster did not respond to ping");
            }
        } catch (ElasticsearchException e) {
            e.printStackTrace();
        } catch (IOException e) { // 捕获 IOException
            e.printStackTrace();
        } finally {
            if (esClient != null) {
                try {
                    esClient._transport().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

