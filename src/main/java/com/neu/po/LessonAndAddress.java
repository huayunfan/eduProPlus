package com.neu.po;

import java.util.List;

import com.neu.beans.Address;
import com.neu.beans.Lesson;

public class LessonAndAddress{
	private Lesson lesson;
	private Address address;
	private List<Address> addresslist;
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
	public List<Address> getAddresslist() {
		return addresslist;
	}
	public void setAddresslist(List<Address> addresslist) {
		this.addresslist = addresslist;
	}
}
