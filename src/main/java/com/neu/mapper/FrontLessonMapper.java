package com.neu.mapper;

import com.neu.beans.Lesson;

import java.util.List;

import com.neu.beans.Address;
import com.neu.beans.FreeListen;
import com.neu.beans.Lesson;



public interface FrontLessonMapper {
//	?????????
	public List<String> findTypeList() throws Exception;
	public List<Lesson> findLessehByCategory(String category)throws Exception;
	public Lesson getLesssonById(int lid) throws Exception;
	public List<Address> getLessonAdderss(int lid) throws Exception;

//	????????
	public List<Address> findAddresList(int qid) throws Exception;
	public List<Lesson> findLessonsByAddress(int branchid) throws Exception;

//	??????
	public Address getAddress(int branchid) throws Exception;

//	????????????
	public List<FreeListen> getFreeListenListByAddress(int branchid) throws Exception;


}
