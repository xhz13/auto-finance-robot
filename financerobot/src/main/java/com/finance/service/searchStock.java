package com.finance.service;

import org.springframework.web.bind.annotation.PostMapping;

public class searchStock {
    @PostMapping("/searchStock")
    public String searchStock(String stockName) {
        return "Stock Name: " + stockName;
    }
}
