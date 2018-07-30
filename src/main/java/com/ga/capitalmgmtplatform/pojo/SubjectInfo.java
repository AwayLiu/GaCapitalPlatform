package com.ga.capitalmgmtplatform.pojo;

public class SubjectInfo {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getTotalCode() {
        return totalCode;
    }

    public void setTotalCode(String totalCode) {
        this.totalCode = totalCode;
    }

    private int id;
    private String name;
    private String code;
    private String parentCode;
    private String branchCode;
    private String shares;
    private String depart;
    private String totalCode;
}
