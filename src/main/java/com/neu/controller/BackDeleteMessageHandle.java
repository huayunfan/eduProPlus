package com.neu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.service.BackDeleteMessageService;

@Controller
public class BackDeleteMessageHandle {
	@Autowired
	private BackDeleteMessageService backDeleteMessageService;
	
	@RequestMapping(value = "/back/deleteMessage")
    @ResponseBody
	public void deleteMessage(@RequestParam int mid,
							 @RequestParam int imgNumber,
							 @RequestParam  int likeNumber,
							 @RequestParam  int replyNumber) throws Exception {
		backDeleteMessageService.deleteMessage(mid, imgNumber, likeNumber, replyNumber);
	}
	
}
