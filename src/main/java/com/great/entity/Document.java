package com.great.entity;

import org.springframework.stereotype.Component;

@Component
public class Document {
    private Integer did;
    private String title;
    private String intro;//简介
    private String typename;//文档类型
    private Integer downscore;//下载文档需要的积分
    private String uptime;//上传时间
    private String dstate;//审核状态
    private Integer downcount;//下载次数
    private Integer userid;//上传用户id
    private String name;//上传用户名字
    private String url;


    public Document() {
    }


    public Document(Integer did, String title, String intro, String typename, Integer downscore, String uptime, String dstate, Integer downcount, Integer userid) {
        this.did = did;
        this.title = title;
        this.intro = intro;
        this.typename = typename;
        this.downscore = downscore;
        this.uptime = uptime;
        this.dstate = dstate;
        this.downcount = downcount;
        this.userid = userid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getDownscore() {
        return downscore;
    }

    public void setDownscore(Integer downscore) {
        this.downscore = downscore;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public String getDstate() {
        return dstate;
    }

    public void setDstate(String dstate) {
        this.dstate = dstate;
    }

    public Integer getDowncount() {
        return downcount;
    }

    public void setDowncount(Integer downcount) {
        this.downcount = downcount;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Document{" +
                "did=" + did +
                ", title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", typename='" + typename + '\'' +
                ", downscore=" + downscore +
                ", uptime='" + uptime + '\'' +
                ", dstate='" + dstate + '\'' +
                ", downcount=" + downcount +
                ", userid=" + userid +
                ", name=" + name +
                '}';
    }
}
