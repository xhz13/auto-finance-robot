package com.finance.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finance.service.searchStockService;


@RestController
public class searchStockController {

    @Autowired
    private searchStockService searchStockService;
    @PostMapping("/searchStock")
    public Map<String,String> searchStock(@RequestBody String stk){
        return searchStockService.search(stk);
    }

    @PostMapping("/searchStockclick")
    public Map<String,String> searchStockclick(@RequestBody String stk){
        return searchStockService.searchStockclick(stk);
    }
}
