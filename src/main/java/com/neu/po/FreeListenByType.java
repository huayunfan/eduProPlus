package com.neu.po;

import java.util.List;

import com.neu.beans.Address;
import com.neu.beans.FreeListen;

public class FreeListenByType {

	private String type;
	private List<FreeListen> freelistens;
	private List<Address> faddress;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<FreeListen> getFreelistens() {
		return freelistens;
	}
	public void setFreelistens(List<FreeListen> freelistens) {
		this.freelistens = freelistens;
	}
	public List<Address> getFaddress() {
		return faddress;
	}
	public void setFaddress(List<Address> faddress) {
		this.faddress = faddress;
	}
}
