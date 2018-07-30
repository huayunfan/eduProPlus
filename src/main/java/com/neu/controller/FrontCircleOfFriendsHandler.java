package com.neu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.po.MessageAbout;
import com.neu.service.FrontCircleOfFriendsService;

@Controller
public class FrontCircleOfFriendsHandler {

	@Autowired
	FrontCircleOfFriendsService circleOfFriendsService;
	
	@RequestMapping(value="/front/findCircleOfFriends")
	@ResponseBody
	public List<MessageAbout> findCircleOfFriends(int qid) throws Exception{
		List<MessageAbout> messageAboutList = circleOfFriendsService.getMessageAbout(qid);
		return messageAboutList;
	}
	@RequestMapping(value="/front/like")
	@ResponseBody
	public String like(int mid,String nickname) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mid", mid);
		map.put("nickname", nickname);
		int isok = circleOfFriendsService.dolike(map);
		if(isok>0){
			return "{\"result\":\"add\",\"id\":\""+isok+"\"}";
		}else if(isok<0){
			
			return "{\"result\":\"del\",\"id\":\""+-isok+"\"}";
		}else{
			return "{\"result\":\"false\"}";
		}
	}
	
	@RequestMapping(value="/front/reply")
	@ResponseBody
	public String reply(int mid,String nickname,String content) throws Exception{
		System.out.println("..........>>FrontCircleOfFriendsHandler.....reply");
		Map<String , Object> map = new HashMap<>();
		map.put("mid", mid);
		map.put("nickname", nickname);
		map.put("content", content);
		boolean isok = circleOfFriendsService.addreply(map);
		if(isok){			
			System.out.println("..........>handler reply");
			return "{\"result\":\"success\"}";
		}else{
			System.out.println("..........>handler failed");
			return "{\"result\":\"failed\"}";
		}
	}
}
