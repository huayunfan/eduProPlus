package com.neu.mapper;

public interface BackDeleteMessageMapper {
	public int deleteMessage(int mid) throws Exception;
	public int deleteMessageImg(int mid) throws Exception;
	public int deleteMessageLike(int mid) throws Exception;
	public int deleteMessageReply(int mid) throws Exception;
}
