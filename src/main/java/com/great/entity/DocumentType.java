package com.great.entity;

public class DocumentType {
    private Integer typeid;//文档id
    private String typename;//文档类型
    private Integer bounty;//奖励分

    public DocumentType() {
    }

    public DocumentType(Integer typeid, String typename, Integer bounty) {
        this.typeid = typeid;
        this.typename = typename;
        this.bounty = bounty;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getBounty() {
        return bounty;
    }

    public void setBounty(Integer bounty) {
        this.bounty = bounty;
    }

    @Override
    public String toString() {
        return "DocumentType{" +
                "typeid=" + typeid +
                ", typename='" + typename + '\'' +
                ", bounty=" + bounty +
                '}';
    }
}
