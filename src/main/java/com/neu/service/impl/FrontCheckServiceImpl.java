package com.neu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.beans.Userlist;
import com.neu.mapper.FrontLoginMapper;
import com.neu.service.FrontCheckService;
@Service
public class FrontCheckServiceImpl implements FrontCheckService {
	@Autowired
    FrontLoginMapper mapper;
	
	@Override
	public Userlist check(String phone) {
		Userlist user=mapper.check(phone);
		return user;
	}

	@Override
	public int insert(String phone) {
	int a=	mapper.adduser(phone);
		return a;		
	}

}    
