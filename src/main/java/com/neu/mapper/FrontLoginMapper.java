package com.neu.mapper;

import com.neu.beans.Userlist;

public interface FrontLoginMapper {

	int adduser(String phone);

	Userlist check(String phone);

}
