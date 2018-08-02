package com.neu.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.mapper.FrontMypageMapper;
import com.neu.service.FrontMypageService;

@Service
public class FrontMypageServiceImpl implements FrontMypageService {
@Autowired
    FrontMypageMapper mapper;
	@Override
	public int signin(int uid) {
	Date data=initDateByDay();
	SimpleDateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd");
	String times=timeFormat.format(data);	
    int count =mapper.signin(uid,times);     
    return count;    
	}

	
	
	
	
	public Date initDateByDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}





	@Override
	public void addscore(int uid) {
		mapper.addscore(uid);
		
		
	}





	@Override
	public void addrecord(int uid) {
		Date data=initDateByDay();
		SimpleDateFormat timeFormat=new SimpleDateFormat("yyyy-MM-dd");
		String time=timeFormat.format(data);
		mapper.addrecord(uid,time);
		
	}
}
