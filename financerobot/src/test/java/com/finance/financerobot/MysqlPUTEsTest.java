package com.finance.financerobot;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finance.domain.entity.stockSearch;
import com.finance.mapper.stockSearchMapper;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.transport.rest_client.RestClientTransport;

@SpringBootTest
public class MysqlPUTEsTest {
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
    @Autowired
    private stockSearchMapper stockSearchMapper;

    @Test
    public void test() {
    QueryWrapper<stockSearch> queryWrapper = new QueryWrapper<>();
    List<stockSearch> stockSearchList = stockSearchMapper.selectList(queryWrapper);
    stockSearchList.forEach(System.out::println);
    System.out.println("stockSearchList.size() = " + stockSearchList.size());

    ElasticsearchClient esClient = EsClientGETTest.esClient; // 使用你的客户端实例
    try {
            // 构建并执行Index请求
            for(int j=0;j<stockSearchList.size();j++){
            stockSearch mystockSearch = stockSearchList.get(j); // 获取第0个元素
            String documentId = String.valueOf(mystockSearch.getId()); // 假设getId()返回String类型的ID
            String documenstnm = mystockSearch.getStknm();
            String documenstcd = mystockSearch.getStkcd();
            IndexResponse response = esClient.index(i -> i
                .index("stock") // 索引名称
                .id(documentId) // 文档ID
                .document(JsonData.of(Map.of(
                    "stknm", documenstnm,
                    "stkcd", documenstcd
                )))
            );
            // 输出响应结果
            System.out.println("Index response: " + response.result().jsonValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
