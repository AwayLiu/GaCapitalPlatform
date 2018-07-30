package com.ga.capitalmgmtplatform.pojo;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class AccountDetail {
    private int id;
    private String accNum;
    private String balanceDepart;
    private String transDate;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private BigDecimal balance;
    private String reciprocalAccount;
    private String reciprocalName;
    private String outOrIn;
    private String isCash;
    private String tradeSummary;
    private String summary;
    private String createDate;
    private String createUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getBalanceDepart() {
        return balanceDepart;
    }

    public void setBalanceDepart(String balanceDepart) {
        this.balanceDepart = balanceDepart;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

//    public String getBalance() {
//        DecimalFormat df = new DecimalFormat("###,###.000");
//        return df.format(balance);
//    }
    public BigDecimal getBalance() {
        DecimalFormat df = new DecimalFormat("###,###.000");
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getReciprocalAccount() {
        return reciprocalAccount;
    }

    public void setReciprocalAccount(String reciprocalAccount) {
        this.reciprocalAccount = reciprocalAccount;
    }

    public String getReciprocalName() {
        return reciprocalName;
    }

    public void setReciprocalName(String reciprocalName) {
        this.reciprocalName = reciprocalName;
    }

    public String getOutOrIn() {
        return outOrIn;
    }

    public void setOutOrIn(String outOrIn) {
        this.outOrIn = outOrIn;
    }

    public String getIsCash() {
        return isCash;
    }

    public void setIsCash(String isCash) {
        this.isCash = isCash;
    }

    public String getTradeSummary() {
        return tradeSummary;
    }

    public void setTradeSummary(String tradeSummary) {
        this.tradeSummary = tradeSummary;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}
