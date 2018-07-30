package com.neu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neu.beans.Address;
import com.neu.beans.Message;

public interface BackGetAllMessageMapper {
	public List<Message> getAllMessage(int qid) throws Exception;
	public List<Address> getPart(@Param("qid") int qid) throws Exception;
	public void setMessage(@Param("mid") int mid,
						  @Param("areaJs") String areaJs,
						  @Param("qid") int qid,
						  @Param("branchid") int branchid) throws Exception;
	public int getNewMid() throws Exception;
	public int getBranchId(@Param("partChoose") String partChoose) throws Exception;
	public void setMessageImg(@Param("id") int id,
							  @Param("mid") int mid,
							  @Param("pathOfPicture") String pathOfPicture) throws Exception;
	public int getNewId() throws Exception;
}
