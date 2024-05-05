package com.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class InquireStockController {
    @Autowired
    InquireStockService inquireStockService;

    @PostMapping("/InquireStock")
    public void InquireStock(@RequestBody String stkcd){
        
    }
}
