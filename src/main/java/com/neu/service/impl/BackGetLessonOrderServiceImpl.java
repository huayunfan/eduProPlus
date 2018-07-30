package com.neu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.beans.Lesson;
import com.neu.mapper.BackGetLessonOrderMapper;
import com.neu.service.BackGetLessonOrderService;

@Service
public class BackGetLessonOrderServiceImpl implements BackGetLessonOrderService {
	@Autowired
	private BackGetLessonOrderMapper backGetLessonOrderMapper;
	
	@Override
	public List<Lesson> getLessonOrder(int qid, int pageStart, int pageNumber, String orderKey, String orderStatus,
			String orderStartTime, String orderEndTime) throws Exception {
		// TODO Auto-generated method stub
		return backGetLessonOrderMapper.getLessonOrder(qid, pageStart, pageNumber, orderKey, orderStatus, orderStartTime, orderEndTime);
	}

	@Override
	public int getLessonNumber() throws Exception {
		// TODO Auto-generated method stub
		return backGetLessonOrderMapper.getLessonNumber();
	}

	@Override
	public void set(int id, String s_status) throws Exception {
		// TODO Auto-generated method stub
		backGetLessonOrderMapper.set(id, s_status);
	}

}
