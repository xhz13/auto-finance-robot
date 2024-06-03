package com.finance.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.finance.domain.entity.StockData;
import com.finance.domain.entity.stockRequest;
import com.finance.domain.entity.VO.InquireStockfoundation;
import com.finance.mapper.StockDataMapper;
import com.finance.service.InquireStockService;
import com.finance.utils.BeanCopyUtils;

@Service
public class InquireStockServiceImpl extends ServiceImpl<StockDataMapper,StockData> implements InquireStockService{
    @Override
    public List<InquireStockfoundation> inquire(String stkcd) {
        stockRequest stockRequest = JSON.parseObject(stkcd, stockRequest.class);
        if(stockRequest==null||stockRequest.getStk()==" ") return null;
        QueryWrapper<StockData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("stkcd", stockRequest.getStk());
        List<StockData> results = baseMapper.selectList(queryWrapper);

        if(results==null) return null;
        System.out.println(results);

        List<InquireStockfoundation> inquireStockfoundationList = new ArrayList<>();
        for (StockData stockData : results) {
            InquireStockfoundation inquireStockfoundation = BeanCopyUtils.copyBean(stockData, InquireStockfoundation.class);
            inquireStockfoundationList.add(inquireStockfoundation);
        }

        InquireStockfoundation inquireStockfoundation = BeanCopyUtils.copyBean(results, InquireStockfoundation.class);
        System.out.println(inquireStockfoundation);
        return inquireStockfoundationList;
    }
}
