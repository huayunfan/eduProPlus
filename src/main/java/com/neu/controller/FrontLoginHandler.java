package com.neu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.neu.beans.Userlist;
import com.neu.service.FrontCheckService;



@Controller
public class FrontLoginHandler {
	@Autowired
	private  FrontCheckService service;
	
	  @RequestMapping(value = "/front/login") 	
 	  public  String frontlogin(HttpServletRequest request)
 	  {
 		  System.out.println("....servlet....frontlogin()......");

 		 //从数据库查找是否存在这样一个手机号的用户
 		  //如果存在那么就取出来 返回
 		  //如果不存在那么就 写入一个
 		 HttpSession session;
 		 
 		  String phone=request.getParameter("phone");
 		  if(service.check(phone)==null)
 		  {
 			  Userlist user=new Userlist();
 			  user.setTel(phone); 		
 			  user.setUname(phone);
 			 user.setOpenid(phone);
 			  user.setUserimg("default.jpg");
 			  adduser(user);
 			 System.out.println(user.getTel());
 		     session=request.getSession();
// 		    session.removeAttribute("user");
 		     session.setAttribute("user", user);
 		     System.out.println("存入session成功！");
 			 return "forward:index.html";
 			  //如果为空 捏造一个用户 返回 并 写入数据库
 		  }
 		  else
 		  {
 			 Userlist user= service.check(phone);
 			 System.out.println(user.getTel());
 			session=request.getSession();	
// 			session.removeAttribute("user");
		     session.setAttribute("user", user);
		     System.out.println("存入session成功！");
 			return "forward:index.html";
 			  //如果不为空 那就将返回的对象返回
 		  }
      }
	  
	  public  void adduser(Userlist user)
	  {
		  String phone= user.getTel();
		  service.insert(phone);		  
	  }
	  
}
