package com.neu.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neu.beans.FreeListen;

public interface BackGetFreeListenBookMapper {
	public List<FreeListen> getfreeListenBook(@Param("pageStart") int pageStart, @Param("pageNumber") int pageNumber) throws Exception;
	public int getPageNumber() throws Exception;
	public List<FreeListen> getfreeListenBookByeInput(@Param("qid") int qid,
													  @Param("pageStart") int pageStart, 
													  @Param("pageNumber") int pageNumber, 
													  @Param("titleKey") String titleKey,
													  @Param("listenState") String listenState,
													  @Param("listenStratTime") String listenStartTime,
													  @Param("listenEndTime") String listenEndTime) throws Exception;
	public void setState(@Param("book_id") int book_id) throws Exception;
}
