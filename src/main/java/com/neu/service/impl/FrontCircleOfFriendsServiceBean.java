package com.neu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.CircularRedirectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neu.beans.Address;
import com.neu.beans.Message;
import com.neu.beans.MessageImg;
import com.neu.beans.MessageLike;
import com.neu.beans.MessageReply;
import com.neu.mapper.FrontCircleOfFriendsMapper;
import com.neu.po.MessageAbout;
import com.neu.service.FrontCircleOfFriendsService;

@Service
public class FrontCircleOfFriendsServiceBean implements FrontCircleOfFriendsService {

	@Autowired
	FrontCircleOfFriendsMapper circleOfFriendsMapper;
	
	@Override
	public List<MessageAbout> getMessageAbout(int qid) throws Exception {
		List<MessageAbout> messageAboutList = new ArrayList<>();
		List<Message> messageList;
		messageList = circleOfFriendsMapper.getMessageById(qid);
		for(Message message:messageList){
			MessageAbout messageAbout = new MessageAbout();
			List<MessageImg> imglist = circleOfFriendsMapper.getMessageImg(message.getMid());
			List<MessageLike> likelist = circleOfFriendsMapper.getMessageLike(message.getMid());
			List<MessageReply> replylist = circleOfFriendsMapper.getMessageReply(message.getMid());
			Address address = circleOfFriendsMapper.getBranchAddress(message.getBranchid());
			messageAbout.setAddress(address);
			messageAbout.setMessage(message);
			messageAbout.setMessageImg(imglist);
			messageAbout.setMessageLike(likelist);
			messageAbout.setMessageReply(replylist);
			messageAboutList.add(messageAbout);
		}
		return messageAboutList;
	}

	@Override
	@Transactional
	public int dolike(Map<String, Object> map) throws Exception {
		System.out.println(".........FrontCircleOfFriendsServiceBean........................dolike");
		int isok = 0;
		MessageLike mlike = circleOfFriendsMapper.findlike(map);
		if(mlike==null){
			int number = circleOfFriendsMapper.addlike(map);
			int id = circleOfFriendsMapper.getLikeId(map);
			if(number>0){
				isok=id;
			}
		}else{
			int id = circleOfFriendsMapper.getLikeId(map);
			int denum = circleOfFriendsMapper.deletelike(map);
			if(denum>0){
				isok=-id;
				
			}
		}
		return isok;
	}

	@Override
	@Transactional
	public boolean addreply(Map<String, Object> map) throws Exception {
		System.out.println(".........>>FrontCircleOfFriendsServiceBean........................reply");
		boolean isok = false;
		int count = circleOfFriendsMapper.addreply(map);
		if(count>0){
			isok = true;
		}
		return isok;
	}
}
