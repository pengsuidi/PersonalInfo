package com.amaker.personalinfo.entity;

public class Shop_Info {
    private Integer user_id;
    private String shop_img_addr;
    private Integer shop_id;
    private String shop_name;
    private String shop_type;
    private Float shop_grade;
    private byte[] shop_image;

    public Shop_Info() {
    }

    public Shop_Info(Integer user_id, String shop_img_addr, Integer shop_id, String shop_name, String shop_type, Float shop_grade, byte[] shop_image) {
        this.user_id = user_id;
        this.shop_img_addr = shop_img_addr;
        this.shop_id = shop_id;
        this.shop_name = shop_name;
        this.shop_type = shop_type;
        this.shop_grade = shop_grade;
        this.shop_image = shop_image;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getShop_img_addr() {
        return shop_img_addr;
    }

    public void setShop_img_addr(String shop_img_addr) {
        this.shop_img_addr = shop_img_addr;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_type() {
        return shop_type;
    }

    public void setShop_type(String shop_type) {
        this.shop_type = shop_type;
    }

    public Float getShop_grade() {
        return shop_grade;
    }

    public void setShop_grade(Float shop_grade) {
        this.shop_grade = shop_grade;
    }

    public byte[] getShop_image() {
        return shop_image;
    }

    public void setShop_image(byte[] shop_image) {
        this.shop_image = shop_image;
    }
}
