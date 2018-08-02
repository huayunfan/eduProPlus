package com.neu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.beans.Address;
import com.neu.beans.FreeListen;
import com.neu.beans.Lesson;
import com.neu.mapper.FrontLessonMapper;
import com.neu.po.AddressandLesson;
import com.neu.po.FreeListenByAddress;
import com.neu.po.FreeListenByType;
import com.neu.po.LessonAndAddress;
import com.neu.service.FrontLessonService;

@Service
public class FrontLessonServiceBean implements FrontLessonService {
	@Autowired
	 FrontLessonMapper lessonMapper;
	
	@Override
	public LessonAndAddress findLessonAndAddressById(Integer lid, Integer branchid) throws Exception {
		System.out.println(".....FrontLessonServiceBean.....findLessonAndAddressById.");
		LessonAndAddress lessonAndAddress = new LessonAndAddress();
		Lesson lesson = lessonMapper.getLesssonById(lid);
//		List<Address> addresslist = lessonMapper.getLessonAdderss(lid);
		Address address = lessonMapper.getAddress(branchid);
		lessonAndAddress.setLesson(lesson);
//		lessonAndAddress.setAddresslist(addresslist);
		lessonAndAddress.setAddress(address);
		return lessonAndAddress;
	}

	@Override
	public Map<String, List<Lesson>> findLessonListByCategory() throws Exception {
		Map<String, List<Lesson>> map = new HashMap<>();
		System.out.println(".........FrontLessonServiceBean..findLessonListByCategory");
		
		List<String> list =  lessonMapper.findTypeList();
		for(String s:list){
			List<Lesson> lessonList= lessonMapper.findLessehByCategory(s);
			map.put(s, lessonList);
		}
		return map;
	}

//	public Lesson findLessonById(Map<String, Object> map) throws Exception{
//		System.out.println("...............LessonService..findLessonById");
//		Lesson lesson = lessonMapper.getLesssonById(map);
//		return lesson;
//	}

//	通过地址显示
	@Override
	public List<AddressandLesson> findLessonsByAddress(int qid) throws Exception {
		List<AddressandLesson> lists = new ArrayList<>();
		List<Address> addresslist = lessonMapper.findAddresList(qid);
		for (Address address : addresslist) {
			AddressandLesson al = new AddressandLesson();
			al.setAddress(address);
			List<Lesson> lessons = lessonMapper.findLessonsByAddress(address.getId());
			al.setLessons(lessons);
			lists.add(al);
		}
		return lists;
	}

//	试听课
	@Override
	public List<FreeListenByAddress> findFreeListens(int qid) throws Exception {
		List<FreeListenByAddress> freelistenByAddresslist = new ArrayList<>();
		List<Address> addresslist = lessonMapper.findAddresList(qid);
		for (Address address : addresslist) {
			FreeListenByAddress fla = new FreeListenByAddress();
			fla.setAddress(address);
			List<FreeListen> freelistenlist = lessonMapper.getFreeListenListByAddress(address.getId());
			fla.setFreelistenlist(freelistenlist);
			freelistenByAddresslist.add(fla);
		}
		return freelistenByAddresslist;
	}

	@Override
	public List<FreeListenByType> findFreelistenByType(int qid) throws Exception {
		
		return null;
	}
	
	
	
}
