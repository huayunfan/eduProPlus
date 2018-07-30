package com.neu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.beans.Enterprise;
import com.neu.beans.Teacher;
import com.neu.service.FrontTeacherService;

@Controller
public class FrontTeacherHandler {
	
	@Autowired
	FrontTeacherService frontteacherService;
	
	@RequestMapping(value = "/front/ajaxteacher")
	@ResponseBody
	  public List<Teacher> findEnterpraise(int qid) throws Exception
	  {
		  System.out.println("....servlet....findTeacher()......");
		  return frontteacherService.findTeacher(qid);
    }
	
}
