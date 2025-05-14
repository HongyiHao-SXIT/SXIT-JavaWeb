package com.example.entity;

public class User {
    private int id;
    private String userName;
    private String blogUrl;
    private int sex;
    private String provinceName;
    private String hobby;
    private String remark;

    public User() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getBlogUrl() { return blogUrl; }
    public void setBlogUrl(String blogUrl) { this.blogUrl = blogUrl; }

    public int getSex() { return sex; }
    public void setSex(int sex) { this.sex = sex; }

    public String getProvinceName() { return provinceName; }
    public void setProvinceName(String provinceName) { this.provinceName = provinceName; }

    public String getHobby() { return hobby; }
    public void setHobby(String hobby) { this.hobby = hobby; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}
