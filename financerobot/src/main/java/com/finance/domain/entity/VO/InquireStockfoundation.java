package com.finance.domain.entity.VO;


import lombok.Data;

@Data
public class InquireStockfoundation {
    private Integer id;
    private String stkcd;
    private Double year;
    private String stknm;
    // 营业收入
    private Double OpRev;
    // 毛利润
    private Double grossprofit;
    // 营业利润
    private Double OpProf;
    // EBIT
    private Double ebit;
    // 税前利润=利润总额
    private Double TotProf;
    // 税后利润=净利润
    private Double NetProf;
    // 总资产
    private Double TotAss;
    // 流动资产
    private Double TotNCurrAss;
    // 货币资金(现金资产)
    private Double cash;
    // 总负债
    private Double TotNCurLia;
    // 流动负债
    private Double TotCurLia;
    // 有息负债(有息债务)
    private Double IntLiab;
    // 所有者权益(权益资本)
    private Double TotShareEquit;
    // 投入资本
    private Double InvCap;
    // 经营活动产生的现金流量净额(实际经营净现金)
    private Double NOCFNote;
    // 应得现金净流量(应得经营净现金)
    private Double eva;
    // 流动比率
    private Double curRt;
    //速冻比率
    private Double qckRt;

}

