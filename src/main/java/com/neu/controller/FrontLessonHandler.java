package com.neu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.beans.Lesson;
import com.neu.po.AddressandLesson;
import com.neu.po.FreeListenByAddress;
import com.neu.po.FreeListenByType;
import com.neu.po.LessonAndAddress;
import com.neu.service.FrontLessonService;

@Controller
public class FrontLessonHandler {
	

	private static final Integer Integer = null;
	@Autowired
	FrontLessonService lessonService;
	
//	通过课程类型来显示
	@RequestMapping(value="/front/findLessons")
	@ResponseBody
	public Map<String, List<Lesson>> findLessons() throws Exception{
		return lessonService.findLessonListByCategory();
	}
	
//	查找某个课程详情
	@RequestMapping(value = "/front/findLessonById")
	@ResponseBody
	public LessonAndAddress findLessonById(Integer lid, Integer branchid) throws Exception{
		System.out.println("..........FrontLessonHandler.....findLessonById");
		LessonAndAddress lessonAndAddress;
		if(lid!=null && branchid!=null){
//			Map<String, Object> map = new HashMap<>();
//			map.put("lid", lid);
//			map.put("branchid", branchid);
			lessonAndAddress = lessonService.findLessonAndAddressById( lid, branchid);
		}else{
			System.out.println("...................没有传入数据");
			lessonAndAddress = null;
		}
		return lessonAndAddress;
	}
	
//	通过地址来显示课程
	@RequestMapping(value="/front/findLessonsByAddress")
	@ResponseBody
	public List<AddressandLesson> findLessonsByAddress(int qid) throws Exception{
		return lessonService.findLessonsByAddress(qid);
	}
	
//	通过地址显示试听课
	@RequestMapping(value="/front/findFreelisten")
	@ResponseBody
	public List<FreeListenByAddress> findFreelisten(int qid) throws Exception{
		return lessonService.findFreeListens(qid);
	}
	
	@RequestMapping(value="/front/findFreelistenByType")
	@ResponseBody
	public List<FreeListenByType> findFreelistenByType(int qid) throws Exception{
		return lessonService.findFreelistenByType(qid);
	}
}

