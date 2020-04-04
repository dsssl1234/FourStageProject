package com.great.entity;

import java.util.List;

public class Menu {
    private Integer mid;
    private String menuname;
    private Integer parentid;
    private String murl;

    private List fatherNodeId;
    private List sonNodeId;

    public Menu() {
    }

    public Menu(Integer mid, String menuname, Integer parentid, String murl) {
        this.mid = mid;
        this.menuname = menuname;
        this.parentid = parentid;
        this.murl = murl;
    }


    public List getFatherNodeId() {
        return fatherNodeId;
    }

    public void setFatherNodeId(List fatherNodeId) {
        this.fatherNodeId = fatherNodeId;
    }

    public List getSonNodeId() {
        return sonNodeId;
    }

    public void setSonNodeId(List sonNodeId) {
        this.sonNodeId = sonNodeId;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getMurl() {
        return murl;
    }

    public void setMurl(String murl) {
        this.murl = murl;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "mid=" + mid +
                ", menuname='" + menuname + '\'' +
                ", parentid=" + parentid +
                ", murl='" + murl + '\'' +
                '}';
    }
}
