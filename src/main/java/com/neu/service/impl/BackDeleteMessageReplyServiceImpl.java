package com.neu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.mapper.BackDeleteMessageReplyMapper;
import com.neu.service.BackDeleteMessageReplyService;
@Service
public class BackDeleteMessageReplyServiceImpl implements BackDeleteMessageReplyService {
	@Autowired
	private BackDeleteMessageReplyMapper backDeleteMessageReplyMapper;
	@Override
	public int deleteMessageReply(int id) throws Exception {
		return backDeleteMessageReplyMapper.deleteMessageReply(id);
	}

}
