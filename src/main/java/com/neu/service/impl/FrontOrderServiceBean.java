//package com.neu.service.impl;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.neu.beans.Address;
//import com.neu.beans.Lesson;
//import com.neu.beans.SOrder;
//import com.neu.mapper.FrontOrderMapper;
//import com.neu.po.OrderAbout;
//import com.neu.po.OrderVO;
//import com.neu.service.FrontOrderService;
//
//@Service
//public class FrontOrderServiceBean implements FrontOrderService {
//
//	@Autowired
//	FrontOrderMapper orderMapper;
//	
//	@Override
//	public List<OrderAbout> getOrderAbouts(String status,String openid) throws Exception {
//
//		Map<String, Object> map = new HashMap<>();
//		map.put("status", status);
//		map.put("openid", openid);
//		List<OrderAbout> lists = new ArrayList<OrderAbout>();
//		List<SOrder> orderList = orderMapper.getOrderByStatus(map);
//		for (SOrder sOrder : orderList) {
//			OrderAbout orderAbout = new OrderAbout();
//			Lesson lesson = orderMapper.getLesssonById(sOrder.getLid());
//			Address address = orderMapper.getLessonAdderss(sOrder.getLid());
//			orderAbout.setAddress(address);
//			orderAbout.setLesson(lesson);
//			orderAbout.setOrder(sOrder);
//			lists.add(orderAbout);
//		}
// 		
//		return lists;
//	}
//
//	@Override
//	public List<OrderVO> findAllorder() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<OrderAbout> getOrderAbouts(String openid) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//}
