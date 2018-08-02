package com.neu.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.neu.service.FrontMypageService;

@Controller
public class FrontMypageHandler {
	  @Autowired
	  private FrontMypageService frontMypageService;
	
	  @RequestMapping(value = "/front/signin")
	  @ResponseBody
	  public int signin(int uid)
	  {
		  System.out.println("....servlet....signin()......");
		  int count= frontMypageService.signin(uid);
		  
		  if(count==1)
		  {
			 
		  }
		  else
		  {
			  frontMypageService.addscore(uid);
			  frontMypageService.addrecord(uid);
		  }
		  return count;
		  
		  
      }
	
	
}
