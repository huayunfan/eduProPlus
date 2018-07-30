package com.neu.service;

import java.util.List;
import java.util.Map;


import com.neu.beans.Lesson;
import com.neu.po.AddressandLesson;
import com.neu.po.FreeListenByAddress;
import com.neu.po.FreeListenByType;
import com.neu.po.LessonAndAddress;



public interface FrontLessonService {
	public Map<String, List<Lesson>> findLessonListByCategory() throws Exception;
	public LessonAndAddress findLessonAndAddressById(Integer lid, Integer branchid) throws Exception;
	

	public List<AddressandLesson> findLessonsByAddress(int qid) throws Exception;


	public List<FreeListenByAddress> findFreeListens(int qid) throws Exception;
	

	public List<FreeListenByType> findFreelistenByType(int qid) throws Exception;
}
