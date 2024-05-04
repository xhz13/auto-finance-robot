package com.finance.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.finance.domain.ResponseResult;
import com.finance.domain.entity.stockSearch;

public interface searchStockService extends IService<stockSearch>{
    Map<String,String> search(String stk);
}
