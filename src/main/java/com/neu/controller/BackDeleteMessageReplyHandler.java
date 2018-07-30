package com.neu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.service.impl.BackDeleteMessageReplyServiceImpl;

@Controller
public class BackDeleteMessageReplyHandler {
	@Autowired
	private BackDeleteMessageReplyServiceImpl backDeleteMessageReplyServiceImpl;
	@RequestMapping(value = "/back/back_deleteMessageReply")
	@ResponseBody
	public int deleteMessageReply(@RequestParam int id) throws Exception {
		return backDeleteMessageReplyServiceImpl.deleteMessageReply(id);
	}
}
