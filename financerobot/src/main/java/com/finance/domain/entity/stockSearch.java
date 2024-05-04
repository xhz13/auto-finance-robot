package com.finance.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("stock_search")
public class stockSearch {
    /*
     * id 号
     */ 
    private int id;
    /*
     * 股票代码
     */ 
    private String stkcd;
    /*
     * 股票名称
     */
    private String stknm;
}
