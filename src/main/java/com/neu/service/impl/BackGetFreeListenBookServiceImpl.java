package com.neu.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.beans.FreeListen;
import com.neu.mapper.BackGetFreeListenBookMapper;
import com.neu.service.BackGetFreeListenBookService;
@Service
public class BackGetFreeListenBookServiceImpl implements BackGetFreeListenBookService {
	@Autowired
	private BackGetFreeListenBookMapper backGetFreeListenBookMapper;

	@Override
	public int getPageNumber() throws Exception {
		// TODO Auto-generated method stub
		
		return backGetFreeListenBookMapper.getPageNumber();
	}

	@Override
	public List<FreeListen> getfreeListenBookByeInput(int qid, int pageStart, int pageNumber, String titleKey, String listenState, String listenStartTime, String listenEndTime) throws Exception {
		// TODO Auto-generated method stub
		return backGetFreeListenBookMapper.getfreeListenBookByeInput(qid, pageStart, pageNumber, titleKey, listenState, listenStartTime, listenEndTime);
	}

	@Override
	public void setState(int book_id) throws Exception {
		backGetFreeListenBookMapper.setState(book_id);
		
	}
	
	
}
