package com.amaker.personalinfo.entity;

public class UserComment {
    private Integer shop_id;
    private Integer comment_id;
    private byte[] comment_img;
    private String comment_img_addr;

    private String comment;
    private  Integer user_id;
    private  Float comment_grade;
    private  String user_pic_addr;
    private  byte[] user_pic;

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public byte[] getComment_img() {
        return comment_img;
    }

    public void setComment_img(byte[] comment_img) {
        this.comment_img = comment_img;
    }

    public String getComment_img_addr() {
        return comment_img_addr;
    }

    public void setComment_img_addr(String comment_img_addr) {
        this.comment_img_addr = comment_img_addr;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Float getComment_grade() {
        return comment_grade;
    }

    public void setComment_grade(Float comment_grade) {
        this.comment_grade = comment_grade;
    }

    public String getUser_pic_addr() {
        return user_pic_addr;
    }

    public void setUser_pic_addr(String user_pic_addr) {
        this.user_pic_addr = user_pic_addr;
    }

    public byte[] getUser_pic() {
        return user_pic;
    }

    public void setUser_pic(byte[] user_pic) {
        this.user_pic = user_pic;
    }

    public UserComment(Integer shop_id, Integer comment_id, byte[] comment_img, String comment_img_addr, String comment, Integer user_id, Float comment_grade, String user_pic_addr, byte[] user_pic) {
        this.shop_id = shop_id;
        this.comment_id = comment_id;
        this.comment_img = comment_img;
        this.comment_img_addr = comment_img_addr;
        this.comment = comment;
        this.user_id = user_id;
        this.comment_grade = comment_grade;
        this.user_pic_addr = user_pic_addr;
        this.user_pic = user_pic;
    }

    public UserComment() {

    }
}
