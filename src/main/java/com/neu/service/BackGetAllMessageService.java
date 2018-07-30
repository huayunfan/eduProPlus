package com.neu.service;

import java.util.List;

import com.neu.beans.Address;
import com.neu.beans.Message;

public interface BackGetAllMessageService {
	public List<Message> getAllMessage(int qid) throws Exception;
	public List<Address> getPart(int qid) throws Exception;
	public void setMessage(int qid, String partChoose, String areaJs, List<String> pathOfPicture) throws Exception;
}
