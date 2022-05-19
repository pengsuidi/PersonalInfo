package com.amaker.personalinfo.entity;

import java.util.Date;

public class payment {
    private Float total_price;
    private int oid;
    private int user_id;
    private int food_id;//局部使用
    private String shop_name;
    private String food_img_addr;
    private String food_name;
    private String food_txt;
    private Float food_price;
    private String food_type;
    private Integer shop_id;
    private byte[] food_image;
    private byte[] shop_img;
    private String  uri;
    private String image_64;

    public byte[] getShop_img() {
        return shop_img;
    }

    public void setShop_img(byte[] shop_img) {
        this.shop_img = shop_img;
    }

    public payment(Float total_price, int oid, int user_id, int food_id, String shop_name, String food_img_addr, String food_name, String food_txt, Float food_price, String food_type, Integer shop_id, byte[] food_image, byte[] shop_img, String uri, String image_64) {
        this.total_price = total_price;
        this.oid = oid;
        this.user_id = user_id;
        this.food_id = food_id;
        this.shop_name = shop_name;
        this.food_img_addr = food_img_addr;
        this.food_name = food_name;
        this.food_txt = food_txt;
        this.food_price = food_price;
        this.food_type = food_type;
        this.shop_id = shop_id;
        this.food_image = food_image;
        this.shop_img = shop_img;
        this.uri = uri;
        this.image_64 = image_64;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public payment(Float total_price, int oid, int user_id, int food_id, String shop_name, String food_img_addr, String food_name, String food_txt, Float food_price, String food_type, Integer shop_id, byte[] food_image, String uri, String image_64) {
        this.total_price = total_price;
        this.oid = oid;
        this.user_id = user_id;
        this.food_id = food_id;
        this.shop_name = shop_name;
        this.food_img_addr = food_img_addr;
        this.food_name = food_name;
        this.food_txt = food_txt;
        this.food_price = food_price;
        this.food_type = food_type;
        this.shop_id = shop_id;
        this.food_image = food_image;
        this.uri = uri;
        this.image_64 = image_64;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public payment(Float total_price, int oid, int user_id, int food_id, String food_img_addr, String food_name, String food_txt, Float food_price, String food_type, Integer shop_id, byte[] food_image, String uri, String image_64) {
        this.total_price = total_price;
        this.oid = oid;
        this.user_id = user_id;
        this.food_id = food_id;
        this.food_img_addr = food_img_addr;
        this.food_name = food_name;
        this.food_txt = food_txt;
        this.food_price = food_price;
        this.food_type = food_type;
        this.shop_id = shop_id;
        this.food_image = food_image;
        this.uri = uri;
        this.image_64 = image_64;
    }

    public Float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Float total_price) {
        this.total_price = total_price;
    }

    public payment(Float total_price, int oid, int food_id, String food_img_addr, String food_name, String food_txt, Float food_price, String food_type, Integer shop_id, byte[] food_image, String uri, String image_64) {
        this.total_price = total_price;
        this.oid = oid;
        this.food_id = food_id;
        this.food_img_addr = food_img_addr;
        this.food_name = food_name;
        this.food_txt = food_txt;
        this.food_price = food_price;
        this.food_type = food_type;
        this.shop_id = shop_id;
        this.food_image = food_image;
        this.uri = uri;
        this.image_64 = image_64;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getFood_img_addr() {
        return food_img_addr;
    }

    public void setFood_img_addr(String food_img_addr) {
        this.food_img_addr = food_img_addr;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_txt() {
        return food_txt;
    }

    public void setFood_txt(String food_txt) {
        this.food_txt = food_txt;
    }

    public Float getFood_price() {
        return food_price;
    }

    public void setFood_price(Float food_price) {
        this.food_price = food_price;
    }

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public byte[] getFood_image() {
        return food_image;
    }

    public void setFood_image(byte[] food_image) {
        this.food_image = food_image;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getImage_64() {
        return image_64;
    }

    public void setImage_64(String image_64) {
        this.image_64 = image_64;
    }

    public payment() {
    }

    public payment(int oid, int food_id, String food_img_addr, String food_name, String food_txt, Float food_price, String food_type, Integer shop_id, byte[] food_image, String uri, String image_64) {
        this.oid = oid;
        this.food_id = food_id;
        this.food_img_addr = food_img_addr;
        this.food_name = food_name;
        this.food_txt = food_txt;
        this.food_price = food_price;
        this.food_type = food_type;
        this.shop_id = shop_id;
        this.food_image = food_image;
        this.uri = uri;
        this.image_64 = image_64;
    }
}
