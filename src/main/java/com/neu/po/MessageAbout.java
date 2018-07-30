package com.neu.po;

import java.util.List;

import com.neu.beans.Address;
import com.neu.beans.Message;
import com.neu.beans.MessageImg;
import com.neu.beans.MessageLike;
import com.neu.beans.MessageReply;

public class MessageAbout {
	private Message message;
	private List<MessageImg>  messageImg;
	private List<MessageLike> messageLike;
	private List<MessageReply> messageReply;
	private Address address;
	public List<MessageImg> getMessageImg() {
		return messageImg;
	}
	public void setMessageImg(List<MessageImg> messageImg) {
		this.messageImg = messageImg;
	}
	public List<MessageLike> getMessageLike() {
		return messageLike;
	}
	public void setMessageLike(List<MessageLike> messageLike) {
		this.messageLike = messageLike;
	}
	public List<MessageReply> getMessageReply() {
		return messageReply;
	}
	public void setMessageReply(List<MessageReply> messageReply) {
		this.messageReply = messageReply;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

}
