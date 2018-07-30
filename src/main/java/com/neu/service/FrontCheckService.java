package com.neu.service;

import com.neu.beans.Userlist;

public interface FrontCheckService {

	Userlist check(String phone);

	int insert(String phone);

}
