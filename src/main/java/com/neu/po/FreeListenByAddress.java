package com.neu.po;

import java.util.List;

import com.neu.beans.Address;
import com.neu.beans.FreeListen;

public class FreeListenByAddress {
	private Address address;
	private List<FreeListen> freelistenlist;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<FreeListen> getFreelistenlist() {
		return freelistenlist;
	}
	public void setFreelistenlist(List<FreeListen> freelistenlist) {
		this.freelistenlist = freelistenlist;
	}
	
}
