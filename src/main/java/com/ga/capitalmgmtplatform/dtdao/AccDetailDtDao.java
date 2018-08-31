package com.ga.capitalmgmtplatform.dtdao;

import java.math.BigDecimal;

public class AccDetailDtDao {
    private String accNum;
    private String balanceDepart;
    private String transDate;
    private String debitAmount;
    private String creditAmount;
    private String balance;
    private String reciprocalAccount;
    private String reciprocalName;
    private String outOrIn;
    private String isCash;
    private String tradeSummary;
    private String summary;

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    private String createUser;

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

    public String getDebitAmount() {
        return debitAmount == "" ? "0.0" : debitAmount.trim();
    }

    public void setDebitAmount(String debitAmount) {
        this.debitAmount = debitAmount;
    }

    public String getCreditAmount() {
        return creditAmount == "" ? "0.0" : creditAmount.trim();
    }

    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getBalance() {
        return balance == "" ? "0.0" : balance.trim();
    }

    public void setBalance(String balance) {
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
}
