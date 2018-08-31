package com.ga.capitalmgmtplatform.pojo;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class AccountBalanceInfo {
    private String bankName;
    private String accNum;
    private String lastNum;
    private BigDecimal balance;
    private String updateDate;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getLastNum() {
        return lastNum;
    }

    public void setLastNum(String lastNum) {
        this.lastNum = lastNum;
    }

    public BigDecimal getDecimalBalance() {
        return balance;
    }

    public String getBalance() {
        DecimalFormat df = new DecimalFormat("###,##0.000");
        String result = balance == null ? null : df.format(balance);
        return result;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
