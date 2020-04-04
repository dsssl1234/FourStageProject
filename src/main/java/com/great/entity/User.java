package com.great.entity;

public class User  {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer userid;
    private String account;
    private String pwd;
    private String name;
    private String sex;
    private String education;//学历
    private String profession;//职业
    private String phone;
    private String email;
    private String rtime;
    private String state;
    private String rePass;
    private Integer roleid;
    private Integer score;//分数
    private Integer upcount;//上传次数
    private Integer downcount;//下次次数
    private Role role;//角色表
//    private List<Menu>menuList;//存放一级菜单
//    private List<Menu>menuList2;//存放二级菜单

    public User() {
    }

    public User(Integer userid, String account, String pwd, String name, String sex, String education, String profession, String phone, String email, String rtime, String state, Integer roleid, Integer score, Integer upcount, Integer downcount) {
        this.userid = userid;
        this.account = account;
        this.pwd = pwd;
        this.name = name;
        this.sex = sex;
        this.education = education;
        this.profession = profession;
        this.phone = phone;
        this.email = email;
        this.rtime = rtime;
        this.state = state;
        this.roleid = roleid;
        this.score = score;
        this.upcount = upcount;
        this.downcount = downcount;
    }


    public String getRePass() {
        return rePass;
    }

    public void setRePass(String rePass) {
        this.rePass = rePass;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getUpcount() {
        return upcount;
    }

    public void setUpcount(Integer upcount) {
        this.upcount = upcount;
    }

    public Integer getDowncount() {
        return downcount;
    }

    public void setDowncount(Integer downcount) {
        this.downcount = downcount;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", education='" + education + '\'' +
                ", profession='" + profession + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", rtime='" + rtime + '\'' +
                ", state='" + state + '\'' +
                ", roleid=" + roleid +
                ", score=" + score +
                ", upcount=" + upcount +
                ", downcount=" + downcount +
                ", role=" + role +
                '}';
    }
}