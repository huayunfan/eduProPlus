package com.neu.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neu.beans.Lesson;

public interface BackGetLessonOrderService {
	public List<Lesson> getLessonOrder(int qid, int pageStart, int pageNumber, String orderKey, String orderStatus, String orderStartTime, String orderEndTime) throws Exception;
	public int getLessonNumber() throws Exception;
	public void set(int id, String s_status) throws Exception;
}
