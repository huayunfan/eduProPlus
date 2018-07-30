package com.neu.beans;

public class MessageImg {//images of friend circle message
    private int id;//primary key
    private int mid;//message id which image at(foreign key)
    private String imgurl;//image url
    private int flag;//0-图片较宽；1-图片较长

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
