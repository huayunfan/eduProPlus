package com.neu.beans;

import java.util.Date;
import java.util.List;

public class Message {//friend circle message
    private int mid;//message id (primary id)
    private String mtitle;//message title (content)
    private Date mtime;//message send time
    private int qid;//company id(foreign)
    private int branchid;
    private List<MessageImg> messageImg;
    private List<MessageLike> messageLike;
    private List<MessageReply> messageReply;
    private Address address;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public List<MessageImg> getMessageImg() {
        return messageImg;
    }

    public void setMessageImg(List<MessageImg> messageImg) {
        this.messageImg = messageImg;
    }

    public List<MessageLike> getMessageLike() {
        return messageLike;
    }

    public void setMessageLike(List<MessageLike> messageLike) {
        this.messageLike = messageLike;
    }

    public List<MessageReply> getMessageReply() {
        return messageReply;
    }

    public void setMessageReply(List<MessageReply> messageReply) {
        this.messageReply = messageReply;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public int getBranchid() {
        return branchid;
    }

    public void setBranchid(int branchid) {
        this.branchid = branchid;
    }

}
