package com.finance.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.finance.domain.entity.StockData;
import com.finance.domain.entity.VO.InquireStockfoundation;

public interface InquireStockService extends IService<StockData>{
    List<InquireStockfoundation> inquire(String stkcd);
}
