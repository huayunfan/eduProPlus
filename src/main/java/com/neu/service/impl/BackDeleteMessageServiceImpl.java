package com.neu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.mapper.BackDeleteMessageMapper;
import com.neu.service.BackDeleteMessageService;
@Service
public class BackDeleteMessageServiceImpl implements BackDeleteMessageService {
	@Autowired
	private BackDeleteMessageMapper backDeleteMessageMapper;

	@Override
	public int deleteMessage(int mid,int imgNumber, int likeNumber, int replyNumber) throws Exception {
		backDeleteMessageMapper.deleteMessage(mid);
		if(imgNumber != 0) {
			backDeleteMessageMapper.deleteMessageImg(mid);
		}
		if(likeNumber != 0) {
			backDeleteMessageMapper.deleteMessageLike(mid);
		}
		if(replyNumber != 0) {
			backDeleteMessageMapper.deleteMessageReply(mid);
		}
		return 0;
	}

}
