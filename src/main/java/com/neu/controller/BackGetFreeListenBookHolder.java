package com.neu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.beans.FreeListen;
import com.neu.beans.User;
import com.neu.service.BackGetFreeListenBookService;

@Controller
public class BackGetFreeListenBookHolder {
	@Autowired
	private BackGetFreeListenBookService backGetFreeListenBookService;
	@RequestMapping(value = "/back/back_bespeak_getfreeListenBook")
	@ResponseBody
	public List<FreeListen> getfreeListenBook(HttpServletRequest request,
											  @RequestParam int currectPage,
											  @RequestParam String titleKey,
											  @RequestParam String listenState,
											  @RequestParam String listenStartTime,
											  @RequestParam String listenEndTime) throws Exception{
		HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
		int pageStart = (currectPage - 1) * 20;
		int pageNumber = 20;
		return backGetFreeListenBookService.getfreeListenBookByeInput(user.getQid(), pageStart, pageNumber, titleKey, listenState, listenStartTime, listenEndTime);
		
	}
	
	@RequestMapping(value = "/back/back_bespeak_getPageNumber")
	@ResponseBody
	public int getPageNumber() throws Exception {
		int allPageNumber = backGetFreeListenBookService.getPageNumber();
		if(allPageNumber % 20 == 0) {
			return allPageNumber / 20;
		}else {
			return (allPageNumber / 20) + 1;
		}
	}
	
	@RequestMapping(value = "/back/back_setState")
	@ResponseBody
	public void setState(@RequestParam int book_id) throws Exception {
		backGetFreeListenBookService.setState(book_id);
	}
}
