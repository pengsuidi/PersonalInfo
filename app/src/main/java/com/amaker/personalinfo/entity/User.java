package com.amaker.personalinfo.entity;

import java.sql.Date;

public class User {
    private Integer user_id;private String pay_password; private String uname;

    private String unickname;

    private String usex;

    private String upassword;

    private String ubirthday;
    private String user_img_addr;
    private byte[] user_img;

    private String uphone;

    private String uemail;

    private String ucity;

    private String uqqnum;

    private Integer ustate;

    private Date createtime;

    private String headimg;

    private Integer urole;

    public User() {
    }

    public User(Integer user_id, String pay_password, String uname, String unickname, String usex, String upassword, String ubirthday, String user_img_addr, byte[] user_img, String uphone, String uemail, String ucity, String uqqnum, Integer ustate, Date createtime, String headimg, Integer urole) {
        this.user_id = user_id;
        this.pay_password = pay_password;
        this.uname = uname;
        this.unickname = unickname;
        this.usex = usex;
        this.upassword = upassword;
        this.ubirthday = ubirthday;
        this.user_img_addr = user_img_addr;
        this.user_img = user_img;
        this.uphone = uphone;
        this.uemail = uemail;
        this.ucity = ucity;
        this.uqqnum = uqqnum;
        this.ustate = ustate;
        this.createtime = createtime;
        this.headimg = headimg;
        this.urole = urole;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getPay_password() {
        return pay_password;
    }

    public void setPay_password(String pay_password) {
        this.pay_password = pay_password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUnickname() {
        return unickname;
    }

    public void setUnickname(String unickname) {
        this.unickname = unickname;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUbirthday() {
        return ubirthday;
    }

    public void setUbirthday(String ubirthday) {
        this.ubirthday = ubirthday;
    }

    public String getUser_img_addr() {
        return user_img_addr;
    }

    public void setUser_img_addr(String user_img_addr) {
        this.user_img_addr = user_img_addr;
    }

    public byte[] getUser_img() {
        return user_img;
    }

    public void setUser_img(byte[] user_img) {
        this.user_img = user_img;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUcity() {
        return ucity;
    }

    public void setUcity(String ucity) {
        this.ucity = ucity;
    }

    public String getUqqnum() {
        return uqqnum;
    }

    public void setUqqnum(String uqqnum) {
        this.uqqnum = uqqnum;
    }

    public Integer getUstate() {
        return ustate;
    }

    public void setUstate(Integer ustate) {
        this.ustate = ustate;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public Integer getUrole() {
        return urole;
    }

    public void setUrole(Integer urole) {
        this.urole = urole;
    }
}
