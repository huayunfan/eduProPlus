package com.neu.po;

import com.neu.beans.Address;
import com.neu.beans.Lesson;
import com.neu.beans.SOrder;

public class OrderVO {
	private Lesson lesson;
	private Address address;
	private SOrder sorder;
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public SOrder getSorder() {
		return sorder;
	}
	public void setSorder(SOrder sorder) {
		this.sorder = sorder;
	}
	
}
