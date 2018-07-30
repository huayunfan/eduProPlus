package com.neu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.po.OrderVO;
import com.neu.service.FrontOrderService;

@Controller
public class FrontOrderHandler
{
	  @Autowired
	  FrontOrderService frontorderService;
	  
	  @RequestMapping(value = "/front/ajaxallorder")
	  @ResponseBody
	  public List<OrderVO> findAllorder()
	  {
		  System.out.println("....servlet....findAllorder()......");
		  return frontorderService.findAllorder();
      }
	  
	  @RequestMapping(value = "/front/ajaxorderpaying")
	  @ResponseBody
	  public List<OrderVO> findorderpaying()
	  {
		  System.out.println("....servlet....findorderpaying()......");
		  return frontorderService.findorderpaying();
      }

	  @RequestMapping(value = "/front/ajaxorderpaied")
	  @ResponseBody
	  public List<OrderVO> findorderpaied()
	  {
		  System.out.println("....servlet....findorderpaied()......");
		  return frontorderService.findorderpaied();
      }
	  
	  @RequestMapping(value = "/front/ajaxorderused")
	  @ResponseBody
	  public List<OrderVO> findorderused()
	  {
		  System.out.println("....servlet....findorderused()......");
		  return frontorderService.findorderused();
      }
	  
	  @RequestMapping(value = "/front/ajaxordercancel")
	  @ResponseBody
	  public List<OrderVO> findordercancel()
	  {
		  System.out.println("....servlet....findordercancel()......");
		  return frontorderService.findordercancel();
      }
	  
	  @RequestMapping(value = "/front/ajaxdeleteorder")
	  @ResponseBody
	  public int deleteorder(HttpServletRequest request,HttpServletResponse response)
	  {
		  int oid=Integer.parseInt(request.getParameter("myoid"));
		  System.out.println("....servlet....deleteorder()......");
		  return frontorderService.deleteorder(oid);
      }
	  
	  @RequestMapping(value = "/front/ajaxpay")
	  @ResponseBody
	  public int pay(HttpServletRequest request,HttpServletResponse response)
	  {
		  int oid=Integer.parseInt(request.getParameter("myoid"));
		  System.out.println("....servlet....pay()......");
		  return frontorderService.pay(oid);
      }
	  
	  @RequestMapping(value = "/front/ajaxcancel")
	  @ResponseBody
	  public int cancel(HttpServletRequest request,HttpServletResponse response)
	  {
		  int oid=Integer.parseInt(request.getParameter("myoid"));
		  System.out.println("....servlet....cancel()......");
		  return frontorderService.cancel(oid);
      }
}
