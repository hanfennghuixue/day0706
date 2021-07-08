package com.ujiuye.bean;

public class Students {

    private Integer sid;
    private String sname;
    private Integer  gender;
    private String hobby;
    private  String degree;
    private String mark;

    public Students() {
    }

    public Students(Integer sid, String sname, Integer gender, String hobby, String degree, String mark) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.hobby = hobby;
        this.degree = degree;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gender=" + gender +
                ", hobby='" + hobby + '\'' +
                ", degree='" + degree + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
