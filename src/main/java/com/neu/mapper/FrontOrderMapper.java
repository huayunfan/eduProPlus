package com.neu.mapper;

import com.neu.beans.Address;
import com.neu.beans.Lesson;



import com.neu.beans.SOrder;
import java.util.List;


public interface FrontOrderMapper {

	public List<SOrder> getOrderByOpenid(String s) throws Exception;
	public Lesson getLesssonById(int lid) throws Exception;
	public Address getLessonAdderss(int branchid) throws Exception;
	public int deleteorderbyoid(int oid);
	public int paybyoid(int oid);
	public int cancelbyoid(int oid);
}








