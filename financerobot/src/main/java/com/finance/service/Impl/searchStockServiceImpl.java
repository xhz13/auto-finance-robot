package com.finance.service.Impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finance.domain.entity.stockRequest;
import com.finance.domain.entity.stockSearch;
import com.finance.mapper.stockSearchMapper;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.transport.rest_client.RestClientTransport;

import com.finance.service.searchStockService;

@Service
public class searchStockServiceImpl extends ServiceImpl<stockSearchMapper,stockSearch> implements searchStockService{
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

    @Override
    public Map<String,String> search(String stk) {
        stockRequest stockRequest = JSON.parseObject(stk, stockRequest.class);
        if(stockRequest==null||stockRequest.getStk()==" ") return null;
        SearchResponse<JsonData> response=null;
        System.out.println(stockRequest.getStk());
        if (stockRequest.getStk().matches("\\d+")) {
            SearchRequest searchRequest = new SearchRequest.Builder()
            .index("stock")
            .suggest(suggestBuilder -> suggestBuilder
                    .suggesters("title_suggest", suggesterBuilder -> suggesterBuilder
                        .text(stockRequest.getStk())
                        .completion(completionSuggesterBuilder -> completionSuggesterBuilder
                                .field("stkcd")
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
        } else {
            SearchRequest searchRequest = new SearchRequest.Builder()
            .index("stock")
            .suggest(suggestBuilder -> suggestBuilder
                    .suggesters("title_suggest", suggesterBuilder -> suggesterBuilder
                        .text(stockRequest.getStk())
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
        }


        if(response==null) return null;
        String ansresponse = response.toString().replaceFirst("^SearchResponse: ", "");
        
        JSONObject jsonresponse  = JSON.parseObject(ansresponse);

        JSONArray optionsArray = jsonresponse.getJSONObject("suggest").getJSONArray("completion#title_suggest").getJSONObject(0).getJSONArray("options");


        Map<String,String> ansmap = new HashMap<String,String>();

        // 遍历options数组，提取stknm和stkcd字段
        for (int i = 0; i < optionsArray.size(); i++) {
            JSONObject option = optionsArray.getJSONObject(i);
            JSONObject source = option.getJSONObject("_source");
            String stknm = source.getString("stknm");
            String stkcd = source.getString("stkcd");
            ansmap.put(stknm, stkcd);
        }

        return ansmap;
    }

    @Override
    public Map<String,String> searchStockclick(String stk) {
        stockRequest stockRequest = JSON.parseObject(stk, stockRequest.class);
        if(stockRequest==null||stockRequest.getStk()==" ") return null;
        SearchResponse<JsonData> response=null;
        System.out.println(stockRequest.getStk());
        if (stockRequest.getStk().matches("\\d+")) {
            SearchRequest searchRequest = new SearchRequest.Builder()
            .index("stock")
            .suggest(suggestBuilder -> suggestBuilder
                    .suggesters("title_suggest", suggesterBuilder -> suggesterBuilder
                        .text(stockRequest.getStk())
                        .completion(completionSuggesterBuilder -> completionSuggesterBuilder
                                .field("stkcd")
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
        } else {
            SearchRequest searchRequest = new SearchRequest.Builder()
            .index("stock")
            .suggest(suggestBuilder -> suggestBuilder
                    .suggesters("title_suggest", suggesterBuilder -> suggesterBuilder
                        .text(stockRequest.getStk())
                        .completion(completionSuggesterBuilder -> completionSuggesterBuilder
                                .field("stknm")
                                .skipDuplicates(true)
                                .size(1000)
                                    )
                            )
                    )
                    .build();
            try{
            response = esClient.search(searchRequest, JsonData.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if(response==null) return null;
        String ansresponse = response.toString().replaceFirst("^SearchResponse: ", "");
        
        JSONObject jsonresponse  = JSON.parseObject(ansresponse);

        JSONArray optionsArray = jsonresponse.getJSONObject("suggest").getJSONArray("completion#title_suggest").getJSONObject(0).getJSONArray("options");


        Map<String,String> ansmap = new HashMap<String,String>();

        // 遍历options数组，提取stknm和stkcd字段
        for (int i = 0; i < optionsArray.size(); i++) {
            JSONObject option = optionsArray.getJSONObject(i);
            JSONObject source = option.getJSONObject("_source");
            String stknm = source.getString("stknm");
            String stkcd = source.getString("stkcd");
            ansmap.put(stknm, stkcd);
        }
        return ansmap;
    }

}



