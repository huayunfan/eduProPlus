package com.neu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neu.beans.Lesson;

public interface BackGetLessonOrderMapper {
	public List<Lesson> getLessonOrder(@Param("qid") int qid,
									   @Param("pageStart") int pageStart,
									   @Param("pageNumber") int pageNumber,
									   @Param("orderKey") String orderKey,
									   @Param("orderStatus")  String orderStatus,
									   @Param("orderStartTime") String orderStartTime,
									   @Param("orderEndTime") String orderEndTime) throws Exception;
	public int getLessonNumber() throws Exception;
	public void set(@Param("id") int id,
					@Param("s_status") String s_status) throws Exception;
}
