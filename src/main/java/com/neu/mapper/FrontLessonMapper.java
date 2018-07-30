package com.neu.mapper;

import com.neu.beans.Lesson;

import java.util.List;

import com.neu.beans.Address;
import com.neu.beans.FreeListen;
import com.neu.beans.Lesson;



public interface FrontLessonMapper {
//	课程，按照种类划分
	public List<String> findTypeList() throws Exception;
	public List<Lesson> findLessehByCategory(String category)throws Exception;
	public Lesson getLesssonById(int lid) throws Exception;
	public List<Address> getLessonAdderss(int lid) throws Exception;

//	课程，按照地址分
	public List<Address> findAddresList(int qid) throws Exception;
	public List<Lesson> findLessonsByAddress(int branchid) throws Exception;

//	获取课程地址
	public Address getAddress(int branchid) throws Exception;

//	通过地址获取那里的试听课
	public List<FreeListen> getFreeListenListByAddress(int branchid) throws Exception;


}
