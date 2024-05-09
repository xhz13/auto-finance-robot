package com.finance.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Xiong
 * @since 2024-05-07
 */
@Data
@TableName("stock_data_2020")
public class StockData2020 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String stkcd;

    private String stknm;

    private Double cash;

    private Double tradAss;

    private Double stinve;

    private Double billRec;

    private Double accRec;

    private Double othRec;

    private Double inventories;

    private Double othCurrAss;

    private Double totCurrAss;

    private Double totalFixAss;

    private Double totNCurrAss;

    private Double totAss;

    private Double shortLoan;

    private Double tradLiab;

    private Double taxPay;

    private Double nCurrLiabOne;

    private Double othCurrLiab;

    private Double totCurLia;

    private Double longLoan;

    private Double bondPay;

    private Double totNCurLia;

    private Double totLiab;

    private Double paidCap;

    private Double prefShr;

    private Double capResFund;

    private Double totShareEquitParent;

    private Double totShareEquit;

    private Double opRev;

    private Double intInc;

    private Double intExp;

    private Double othOpCost;

    private Double opExp;

    private Double totAdmExp;

    private Double rDExp;

    private Double finanExp;

    private Double opProf;

    private Double totProf;

    private Double netProf;

    private Double nOCFNote;

    private Double netInvCashFl;

    private Double adjNetFinan;

    private Double year;

    private Double intLiab;

    private Double invCap;

    private Double ebit;

    private Double eva;

    private Double curRt;

    private Double qckRt;

    private Double cashRt;

    private Double wrtLoanRt;

    private Double dbAstRt;

    private Double aRTRat;

    private Double invtrTrRat;

    private Double accrPayRat;

    private Double wrkCapTRt;

    private Double cashRat;

    private Double curRat;

    private Double fixAssRat;

    private Double nonCurATRt;

    private Double totAssRat;

    private Double equRat;

    private Double roa;

    private Double netPrfCurRt;

    private Double nPrFixAssRt;

    private Double roe;

    private Double opePrfRt;

    private Double totPrfCostRt;

    private Double finlev;

    private Double oCFlev;

    private Double totlev;

    private Double netPrfGrRt;

    private Double opeIncmGrRt;

    private Double opeCPSGrRt;

    private Double netOCFGrRt;

    private Double netInvCFGrRt;

    private Double netFinCFGrRt;

    private Double susGrRt;

    private Double totShareEquitGrRt;

    private Double nAPSGrRt;

    private Double eps;

    private Double opeCPS;

    private String hydm;

    private Double hy;

    private Integer listexg;

    private Double nocfeva;

    private Double nocftse;

    private Double nocfnp;

    private Double opeCPSEPS;

    private Double evatse;

    private Double eVAInvCap;

    private Double rioc;

    private Double grossprofit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStkcd() {
        return stkcd;
    }

    public void setStkcd(String stkcd) {
        this.stkcd = stkcd;
    }

    public String getStknm() {
        return stknm;
    }

    public void setStknm(String stknm) {
        this.stknm = stknm;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Double getTradAss() {
        return tradAss;
    }

    public void setTradAss(Double tradAss) {
        this.tradAss = tradAss;
    }

    public Double getStinve() {
        return stinve;
    }

    public void setStinve(Double stinve) {
        this.stinve = stinve;
    }

    public Double getBillRec() {
        return billRec;
    }

    public void setBillRec(Double billRec) {
        this.billRec = billRec;
    }

    public Double getAccRec() {
        return accRec;
    }

    public void setAccRec(Double accRec) {
        this.accRec = accRec;
    }

    public Double getOthRec() {
        return othRec;
    }

    public void setOthRec(Double othRec) {
        this.othRec = othRec;
    }

    public Double getInventories() {
        return inventories;
    }

    public void setInventories(Double inventories) {
        this.inventories = inventories;
    }

    public Double getOthCurrAss() {
        return othCurrAss;
    }

    public void setOthCurrAss(Double othCurrAss) {
        this.othCurrAss = othCurrAss;
    }

    public Double getTotCurrAss() {
        return totCurrAss;
    }

    public void setTotCurrAss(Double totCurrAss) {
        this.totCurrAss = totCurrAss;
    }

    public Double getTotalFixAss() {
        return totalFixAss;
    }

    public void setTotalFixAss(Double totalFixAss) {
        this.totalFixAss = totalFixAss;
    }

    public Double getTotNCurrAss() {
        return totNCurrAss;
    }

    public void setTotNCurrAss(Double totNCurrAss) {
        this.totNCurrAss = totNCurrAss;
    }

    public Double getTotAss() {
        return totAss;
    }

    public void setTotAss(Double totAss) {
        this.totAss = totAss;
    }

    public Double getShortLoan() {
        return shortLoan;
    }

    public void setShortLoan(Double shortLoan) {
        this.shortLoan = shortLoan;
    }

    public Double getTradLiab() {
        return tradLiab;
    }

    public void setTradLiab(Double tradLiab) {
        this.tradLiab = tradLiab;
    }

    public Double getTaxPay() {
        return taxPay;
    }

    public void setTaxPay(Double taxPay) {
        this.taxPay = taxPay;
    }

    public Double getnCurrLiabOne() {
        return nCurrLiabOne;
    }

    public void setnCurrLiabOne(Double nCurrLiabOne) {
        this.nCurrLiabOne = nCurrLiabOne;
    }

    public Double getOthCurrLiab() {
        return othCurrLiab;
    }

    public void setOthCurrLiab(Double othCurrLiab) {
        this.othCurrLiab = othCurrLiab;
    }

    public Double getTotCurLia() {
        return totCurLia;
    }

    public void setTotCurLia(Double totCurLia) {
        this.totCurLia = totCurLia;
    }

    public Double getLongLoan() {
        return longLoan;
    }

    public void setLongLoan(Double longLoan) {
        this.longLoan = longLoan;
    }

    public Double getBondPay() {
        return bondPay;
    }

    public void setBondPay(Double bondPay) {
        this.bondPay = bondPay;
    }

    public Double getTotNCurLia() {
        return totNCurLia;
    }

    public void setTotNCurLia(Double totNCurLia) {
        this.totNCurLia = totNCurLia;
    }

    public Double getTotLiab() {
        return totLiab;
    }

    public void setTotLiab(Double totLiab) {
        this.totLiab = totLiab;
    }

    public Double getPaidCap() {
        return paidCap;
    }

    public void setPaidCap(Double paidCap) {
        this.paidCap = paidCap;
    }

    public Double getPrefShr() {
        return prefShr;
    }

    public void setPrefShr(Double prefShr) {
        this.prefShr = prefShr;
    }

    public Double getCapResFund() {
        return capResFund;
    }

    public void setCapResFund(Double capResFund) {
        this.capResFund = capResFund;
    }

    public Double getTotShareEquitParent() {
        return totShareEquitParent;
    }

    public void setTotShareEquitParent(Double totShareEquitParent) {
        this.totShareEquitParent = totShareEquitParent;
    }

    public Double getTotShareEquit() {
        return totShareEquit;
    }

    public void setTotShareEquit(Double totShareEquit) {
        this.totShareEquit = totShareEquit;
    }

    public Double getOpRev() {
        return opRev;
    }

    public void setOpRev(Double opRev) {
        this.opRev = opRev;
    }

    public Double getIntInc() {
        return intInc;
    }

    public void setIntInc(Double intInc) {
        this.intInc = intInc;
    }

    public Double getIntExp() {
        return intExp;
    }

    public void setIntExp(Double intExp) {
        this.intExp = intExp;
    }

    public Double getOthOpCost() {
        return othOpCost;
    }

    public void setOthOpCost(Double othOpCost) {
        this.othOpCost = othOpCost;
    }

    public Double getOpExp() {
        return opExp;
    }

    public void setOpExp(Double opExp) {
        this.opExp = opExp;
    }

    public Double getTotAdmExp() {
        return totAdmExp;
    }

    public void setTotAdmExp(Double totAdmExp) {
        this.totAdmExp = totAdmExp;
    }

    public Double getrDExp() {
        return rDExp;
    }

    public void setrDExp(Double rDExp) {
        this.rDExp = rDExp;
    }

    public Double getFinanExp() {
        return finanExp;
    }

    public void setFinanExp(Double finanExp) {
        this.finanExp = finanExp;
    }

    public Double getOpProf() {
        return opProf;
    }

    public void setOpProf(Double opProf) {
        this.opProf = opProf;
    }

    public Double getTotProf() {
        return totProf;
    }

    public void setTotProf(Double totProf) {
        this.totProf = totProf;
    }

    public Double getNetProf() {
        return netProf;
    }

    public void setNetProf(Double netProf) {
        this.netProf = netProf;
    }

    public Double getnOCFNote() {
        return nOCFNote;
    }

    public void setnOCFNote(Double nOCFNote) {
        this.nOCFNote = nOCFNote;
    }

    public Double getNetInvCashFl() {
        return netInvCashFl;
    }

    public void setNetInvCashFl(Double netInvCashFl) {
        this.netInvCashFl = netInvCashFl;
    }

    public Double getAdjNetFinan() {
        return adjNetFinan;
    }

    public void setAdjNetFinan(Double adjNetFinan) {
        this.adjNetFinan = adjNetFinan;
    }

    public Double getYear() {
        return year;
    }

    public void setYear(Double year) {
        this.year = year;
    }

    public Double getIntLiab() {
        return intLiab;
    }

    public void setIntLiab(Double intLiab) {
        this.intLiab = intLiab;
    }

    public Double getInvCap() {
        return invCap;
    }

    public void setInvCap(Double invCap) {
        this.invCap = invCap;
    }

    public Double getEbit() {
        return ebit;
    }

    public void setEbit(Double ebit) {
        this.ebit = ebit;
    }

    public Double getEva() {
        return eva;
    }

    public void setEva(Double eva) {
        this.eva = eva;
    }

    public Double getCurRt() {
        return curRt;
    }

    public void setCurRt(Double curRt) {
        this.curRt = curRt;
    }

    public Double getQckRt() {
        return qckRt;
    }

    public void setQckRt(Double qckRt) {
        this.qckRt = qckRt;
    }

    public Double getCashRt() {
        return cashRt;
    }

    public void setCashRt(Double cashRt) {
        this.cashRt = cashRt;
    }

    public Double getWrtLoanRt() {
        return wrtLoanRt;
    }

    public void setWrtLoanRt(Double wrtLoanRt) {
        this.wrtLoanRt = wrtLoanRt;
    }

    public Double getDbAstRt() {
        return dbAstRt;
    }

    public void setDbAstRt(Double dbAstRt) {
        this.dbAstRt = dbAstRt;
    }

    public Double getaRTRat() {
        return aRTRat;
    }

    public void setaRTRat(Double aRTRat) {
        this.aRTRat = aRTRat;
    }

    public Double getInvtrTrRat() {
        return invtrTrRat;
    }

    public void setInvtrTrRat(Double invtrTrRat) {
        this.invtrTrRat = invtrTrRat;
    }

    public Double getAccrPayRat() {
        return accrPayRat;
    }

    public void setAccrPayRat(Double accrPayRat) {
        this.accrPayRat = accrPayRat;
    }

    public Double getWrkCapTRt() {
        return wrkCapTRt;
    }

    public void setWrkCapTRt(Double wrkCapTRt) {
        this.wrkCapTRt = wrkCapTRt;
    }

    public Double getCashRat() {
        return cashRat;
    }

    public void setCashRat(Double cashRat) {
        this.cashRat = cashRat;
    }

    public Double getCurRat() {
        return curRat;
    }

    public void setCurRat(Double curRat) {
        this.curRat = curRat;
    }

    public Double getFixAssRat() {
        return fixAssRat;
    }

    public void setFixAssRat(Double fixAssRat) {
        this.fixAssRat = fixAssRat;
    }

    public Double getNonCurATRt() {
        return nonCurATRt;
    }

    public void setNonCurATRt(Double nonCurATRt) {
        this.nonCurATRt = nonCurATRt;
    }

    public Double getTotAssRat() {
        return totAssRat;
    }

    public void setTotAssRat(Double totAssRat) {
        this.totAssRat = totAssRat;
    }

    public Double getEquRat() {
        return equRat;
    }

    public void setEquRat(Double equRat) {
        this.equRat = equRat;
    }

    public Double getRoa() {
        return roa;
    }

    public void setRoa(Double roa) {
        this.roa = roa;
    }

    public Double getNetPrfCurRt() {
        return netPrfCurRt;
    }

    public void setNetPrfCurRt(Double netPrfCurRt) {
        this.netPrfCurRt = netPrfCurRt;
    }

    public Double getnPrFixAssRt() {
        return nPrFixAssRt;
    }

    public void setnPrFixAssRt(Double nPrFixAssRt) {
        this.nPrFixAssRt = nPrFixAssRt;
    }

    public Double getRoe() {
        return roe;
    }

    public void setRoe(Double roe) {
        this.roe = roe;
    }

    public Double getOpePrfRt() {
        return opePrfRt;
    }

    public void setOpePrfRt(Double opePrfRt) {
        this.opePrfRt = opePrfRt;
    }

    public Double getTotPrfCostRt() {
        return totPrfCostRt;
    }

    public void setTotPrfCostRt(Double totPrfCostRt) {
        this.totPrfCostRt = totPrfCostRt;
    }

    public Double getFinlev() {
        return finlev;
    }

    public void setFinlev(Double finlev) {
        this.finlev = finlev;
    }

    public Double getoCFlev() {
        return oCFlev;
    }

    public void setoCFlev(Double oCFlev) {
        this.oCFlev = oCFlev;
    }

    public Double getTotlev() {
        return totlev;
    }

    public void setTotlev(Double totlev) {
        this.totlev = totlev;
    }

    public Double getNetPrfGrRt() {
        return netPrfGrRt;
    }

    public void setNetPrfGrRt(Double netPrfGrRt) {
        this.netPrfGrRt = netPrfGrRt;
    }

    public Double getOpeIncmGrRt() {
        return opeIncmGrRt;
    }

    public void setOpeIncmGrRt(Double opeIncmGrRt) {
        this.opeIncmGrRt = opeIncmGrRt;
    }

    public Double getOpeCPSGrRt() {
        return opeCPSGrRt;
    }

    public void setOpeCPSGrRt(Double opeCPSGrRt) {
        this.opeCPSGrRt = opeCPSGrRt;
    }

    public Double getNetOCFGrRt() {
        return netOCFGrRt;
    }

    public void setNetOCFGrRt(Double netOCFGrRt) {
        this.netOCFGrRt = netOCFGrRt;
    }

    public Double getNetInvCFGrRt() {
        return netInvCFGrRt;
    }

    public void setNetInvCFGrRt(Double netInvCFGrRt) {
        this.netInvCFGrRt = netInvCFGrRt;
    }

    public Double getNetFinCFGrRt() {
        return netFinCFGrRt;
    }

    public void setNetFinCFGrRt(Double netFinCFGrRt) {
        this.netFinCFGrRt = netFinCFGrRt;
    }

    public Double getSusGrRt() {
        return susGrRt;
    }

    public void setSusGrRt(Double susGrRt) {
        this.susGrRt = susGrRt;
    }

    public Double getTotShareEquitGrRt() {
        return totShareEquitGrRt;
    }

    public void setTotShareEquitGrRt(Double totShareEquitGrRt) {
        this.totShareEquitGrRt = totShareEquitGrRt;
    }

    public Double getnAPSGrRt() {
        return nAPSGrRt;
    }

    public void setnAPSGrRt(Double nAPSGrRt) {
        this.nAPSGrRt = nAPSGrRt;
    }

    public Double getEps() {
        return eps;
    }

    public void setEps(Double eps) {
        this.eps = eps;
    }

    public Double getOpeCPS() {
        return opeCPS;
    }

    public void setOpeCPS(Double opeCPS) {
        this.opeCPS = opeCPS;
    }

    public String getHydm() {
        return hydm;
    }

    public void setHydm(String hydm) {
        this.hydm = hydm;
    }

    public Double getHy() {
        return hy;
    }

    public void setHy(Double hy) {
        this.hy = hy;
    }

    public Integer getListexg() {
        return listexg;
    }

    public void setListexg(Integer listexg) {
        this.listexg = listexg;
    }

    public Double getNocfeva() {
        return nocfeva;
    }

    public void setNocfeva(Double nocfeva) {
        this.nocfeva = nocfeva;
    }

    public Double getNocftse() {
        return nocftse;
    }

    public void setNocftse(Double nocftse) {
        this.nocftse = nocftse;
    }

    public Double getNocfnp() {
        return nocfnp;
    }

    public void setNocfnp(Double nocfnp) {
        this.nocfnp = nocfnp;
    }

    public Double getOpeCPSEPS() {
        return opeCPSEPS;
    }

    public void setOpeCPSEPS(Double opeCPSEPS) {
        this.opeCPSEPS = opeCPSEPS;
    }

    public Double getEvatse() {
        return evatse;
    }

    public void setEvatse(Double evatse) {
        this.evatse = evatse;
    }

    public Double geteVAInvCap() {
        return eVAInvCap;
    }

    public void seteVAInvCap(Double eVAInvCap) {
        this.eVAInvCap = eVAInvCap;
    }

    public Double getRioc() {
        return rioc;
    }

    public void setRioc(Double rioc) {
        this.rioc = rioc;
    }

    public Double getGrossprofit() {
        return grossprofit;
    }

    public void setGrossprofit(Double grossprofit) {
        this.grossprofit = grossprofit;
    }

    @Override
    public String toString() {
        return "StockData2020{" +
            "id = " + id +
            ", stkcd = " + stkcd +
            ", stknm = " + stknm +
            ", cash = " + cash +
            ", tradAss = " + tradAss +
            ", stinve = " + stinve +
            ", billRec = " + billRec +
            ", accRec = " + accRec +
            ", othRec = " + othRec +
            ", inventories = " + inventories +
            ", othCurrAss = " + othCurrAss +
            ", totCurrAss = " + totCurrAss +
            ", totalFixAss = " + totalFixAss +
            ", totNCurrAss = " + totNCurrAss +
            ", totAss = " + totAss +
            ", shortLoan = " + shortLoan +
            ", tradLiab = " + tradLiab +
            ", taxPay = " + taxPay +
            ", nCurrLiabOne = " + nCurrLiabOne +
            ", othCurrLiab = " + othCurrLiab +
            ", totCurLia = " + totCurLia +
            ", longLoan = " + longLoan +
            ", bondPay = " + bondPay +
            ", totNCurLia = " + totNCurLia +
            ", totLiab = " + totLiab +
            ", paidCap = " + paidCap +
            ", prefShr = " + prefShr +
            ", capResFund = " + capResFund +
            ", totShareEquitParent = " + totShareEquitParent +
            ", totShareEquit = " + totShareEquit +
            ", opRev = " + opRev +
            ", intInc = " + intInc +
            ", intExp = " + intExp +
            ", othOpCost = " + othOpCost +
            ", opExp = " + opExp +
            ", totAdmExp = " + totAdmExp +
            ", rDExp = " + rDExp +
            ", finanExp = " + finanExp +
            ", opProf = " + opProf +
            ", totProf = " + totProf +
            ", netProf = " + netProf +
            ", nOCFNote = " + nOCFNote +
            ", netInvCashFl = " + netInvCashFl +
            ", adjNetFinan = " + adjNetFinan +
            ", year = " + year +
            ", intLiab = " + intLiab +
            ", invCap = " + invCap +
            ", ebit = " + ebit +
            ", eva = " + eva +
            ", curRt = " + curRt +
            ", qckRt = " + qckRt +
            ", cashRt = " + cashRt +
            ", wrtLoanRt = " + wrtLoanRt +
            ", dbAstRt = " + dbAstRt +
            ", aRTRat = " + aRTRat +
            ", invtrTrRat = " + invtrTrRat +
            ", accrPayRat = " + accrPayRat +
            ", wrkCapTRt = " + wrkCapTRt +
            ", cashRat = " + cashRat +
            ", curRat = " + curRat +
            ", fixAssRat = " + fixAssRat +
            ", nonCurATRt = " + nonCurATRt +
            ", totAssRat = " + totAssRat +
            ", equRat = " + equRat +
            ", roa = " + roa +
            ", netPrfCurRt = " + netPrfCurRt +
            ", nPrFixAssRt = " + nPrFixAssRt +
            ", roe = " + roe +
            ", opePrfRt = " + opePrfRt +
            ", totPrfCostRt = " + totPrfCostRt +
            ", finlev = " + finlev +
            ", oCFlev = " + oCFlev +
            ", totlev = " + totlev +
            ", netPrfGrRt = " + netPrfGrRt +
            ", opeIncmGrRt = " + opeIncmGrRt +
            ", opeCPSGrRt = " + opeCPSGrRt +
            ", netOCFGrRt = " + netOCFGrRt +
            ", netInvCFGrRt = " + netInvCFGrRt +
            ", netFinCFGrRt = " + netFinCFGrRt +
            ", susGrRt = " + susGrRt +
            ", totShareEquitGrRt = " + totShareEquitGrRt +
            ", nAPSGrRt = " + nAPSGrRt +
            ", eps = " + eps +
            ", opeCPS = " + opeCPS +
            ", hydm = " + hydm +
            ", hy = " + hy +
            ", listexg = " + listexg +
            ", nocfeva = " + nocfeva +
            ", nocftse = " + nocftse +
            ", nocfnp = " + nocfnp +
            ", opeCPSEPS = " + opeCPSEPS +
            ", evatse = " + evatse +
            ", eVAInvCap = " + eVAInvCap +
            ", rioc = " + rioc +
            ", grossprofit = " + grossprofit +
        "}";
    }
}
