package com.neu.mapper;

import java.util.List;
import java.util.Map;

import com.neu.beans.Address;
import com.neu.beans.Message;
import com.neu.beans.MessageImg;
import com.neu.beans.MessageLike;
import com.neu.beans.MessageReply;

public interface FrontCircleOfFriendsMapper {
	public List<Message> getMessageById(int qid) throws Exception;
	public List<MessageLike> getMessageLike(int mid) throws Exception;
	public List<MessageImg> getMessageImg(int mid) throws Exception;
	public List<MessageReply> getMessageReply(int mid) throws Exception;
	public Address getBranchAddress(int branchid) throws Exception;

	public int getLikeId(Map<String, Object> map) throws Exception;
	public int addlike(Map<String, Object> map) throws Exception;
	public int deletelike(Map<String, Object> map) throws Exception;
	public MessageLike findlike(Map<String, Object> map) throws Exception;

	public int addreply(Map<String, Object> map) throws Exception;
}
