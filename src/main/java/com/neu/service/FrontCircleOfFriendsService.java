package com.neu.service;

import java.util.List;
import java.util.Map;

import com.neu.po.MessageAbout;

public interface FrontCircleOfFriendsService {
	public List<MessageAbout> getMessageAbout(int qid) throws Exception;
	public int dolike(Map<String, Object> map) throws Exception;
	public boolean addreply(Map<String, Object> map) throws Exception;
}
