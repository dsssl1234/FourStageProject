package com.great.entity;

public class Role {
    private Integer roleid;
    private String  type;

    public Role() {
    }

    public Role(Integer roleid, String type) {
        this.roleid = roleid;
        this.type = type;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", type='" + type + '\'' +
                '}';
    }
}
