package com.neu.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.beans.Userlist;


@Controller
public class FrontGetSessionHandler {
	
	  @RequestMapping(value = "/front/getsession")
	  @ResponseBody
	  public Userlist getsession(HttpServletRequest request)
	  {
		  System.out.println("....servlet....getsession()......");
		  HttpSession session= request.getSession();
		  Userlist user= (Userlist)session.getAttribute("user");
		  System.out.println(user.getTel());
		  System.out.println(user.getUname());
		  System.out.println(user.getUserimg());
		  return user;
      }
	  
}
