package com.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finance.domain.entity.VO.InquireStockfoundation;
import com.finance.service.InquireStockService;

@RestController
public class InquireStockController {
    @Autowired
    InquireStockService inquireStockService;
    @PostMapping("/InquireStock")
    public List<InquireStockfoundation> InquireStock(@RequestBody String stkcd){
        return inquireStockService.inquire(stkcd);
    }
}
