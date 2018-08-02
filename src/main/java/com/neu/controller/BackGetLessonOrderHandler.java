package com.neu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.beans.Lesson;
import com.neu.beans.User;
import com.neu.service.BackGetLessonOrderService;

@Controller
public class BackGetLessonOrderHandler {
	@Autowired
	private BackGetLessonOrderService backGetLessonOrderService;
	
	@RequestMapping(value = "/back/getLessonOrder")
	@ResponseBody
	public List<Lesson> getLessonOrder(HttpServletRequest request,
									   @RequestParam int currectPage, 
									   @RequestParam String orderKey,
									   @RequestParam String orderStatus,
									   @RequestParam String orderStartTime,
									   @RequestParam String orderEndTime) throws Exception{
		HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
		System.out.println("ceshi");
		int pageStart = (currectPage - 1) * 20;
		int pageNumber = 20;
		return backGetLessonOrderService.getLessonOrder(user.getQid(), pageStart, pageNumber, orderKey, orderStatus, orderStartTime, orderEndTime);
	}
	
	@RequestMapping(value = "/back/getLessonNumber")
	@ResponseBody
	public int getLessonNumber() throws Exception{
		int allPageNumber = backGetLessonOrderService.getLessonNumber();
		if(allPageNumber % 20 == 0) {
			return allPageNumber / 20;
		}else {
			return (allPageNumber / 20) + 1;
		}
	}
	
	@RequestMapping(value = "/back/set")
	@ResponseBody
	public void set(@RequestParam int order_id, @RequestParam int s_status) throws Exception{
		System.out.println(order_id);
		String set_status = "";
		if(s_status == 1) {
			set_status = "???";
		}else if(s_status == 2) {
			set_status = "???";
		}else {
			System.out.println(s_status);
		}
		backGetLessonOrderService.set(order_id, set_status);
	}
	
}
