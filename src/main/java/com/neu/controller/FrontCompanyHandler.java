package com.neu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.beans.Enterprise;
import com.neu.po.OrderVO;
import com.neu.service.FrontCompanyService;

@Controller
public class FrontCompanyHandler {
       @Autowired
       FrontCompanyService frontcompanyService;
	
      @RequestMapping(value = "/front/ajaxcompany")
 	  @ResponseBody
 	  public Enterprise findEnterpraise(int qid) throws Exception
 	  {
 		  System.out.println("....servlet....findEnterprise()......");
 		  return frontcompanyService.findEnterprise(qid);
      }
}
