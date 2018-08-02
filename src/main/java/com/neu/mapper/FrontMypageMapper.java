package com.neu.mapper;
public interface FrontMypageMapper {
	
	int signin(int uid, String times);

	void addscore(int uid);

	void addrecord(int uid,String time);

}
