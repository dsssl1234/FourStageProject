package com.great.entity;

public class Relation {
    private Integer relationid;
    private Integer roleid;
    private Integer mid;

    public Relation() {
    }

    public Relation(Integer relationid, Integer roleid, Integer mid) {
        this.relationid = relationid;
        this.roleid = roleid;
        this.mid = mid;
    }

    public Integer getRelationid() {
        return relationid;
    }

    public void setRelationid(Integer relationid) {
        this.relationid = relationid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "relationid=" + relationid +
                ", roleid=" + roleid +
                ", mid=" + mid +
                '}';
    }
}
