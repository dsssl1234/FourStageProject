package com.great.entity;

public class MyScore {
    private Integer sid;
    private String time;
    private String event;
    private Integer score;
    private Integer userid;
    private String name;

    public MyScore() {
    }

    public MyScore(Integer sid, String time, String event, Integer score, Integer userid) {
        this.sid = sid;
        this.time = time;
        this.event = event;
        this.score = score;
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "MyScore{" +
                "sid=" + sid +
                ", time='" + time + '\'' +
                ", event='" + event + '\'' +
                ", score=" + score +
                ", userid=" + userid +
                '}';
    }
}
