package com.neu.po;

import java.util.List;

import com.neu.beans.Address;
import com.neu.beans.Lesson;

public class AddressandLesson {

	private Address address;
	private List<Lesson> lessons;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Lesson> getLessons() {
		return lessons;
	}
	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	
}
