package com.neu.beans;

public class Swiper {//swiper image of company intro
    private int id;//primary key
    private int qid;//cmpany id
    private String imgurl;//image url
    private String category;//image category

    public Swiper(int id, int qid, String imgurl, String category) {
        this.id = id;
        this.qid = qid;
        this.imgurl = imgurl;
        this.category = category;
    }

    public Swiper(int id, String imgurl) {
        this.id = id;
        this.imgurl = imgurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
