package com.neu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.po.FreeListenVO;
import com.neu.service.FrontReserveService;

@Controller
public class FrontReserveHandler 
{

	  @Autowired
	  FrontReserveService frontreserverService;
	  
	  @RequestMapping(value = "/front/ajaxallreserve")
	  @ResponseBody
	  public List<FreeListenVO> findAllreserve()
	  {
		  System.out.println("....servlet....findAllreserve()......");
		  return frontreserverService.findAllReserve();
      }
	  
	  @RequestMapping(value = "/front/ajaxreserved")
	  @ResponseBody
	  public List<FreeListenVO> findreserved()
	  {
		  System.out.println("....servlet....findreserved()......");
		  return frontreserverService.findReserved();
      }
	  
	  @RequestMapping(value = "/front/ajaxreserveing")
	  @ResponseBody
	  public List<FreeListenVO> findreserveing()
	  {
		  System.out.println("....servlet....findreserveing()......");
		  return frontreserverService.findReserveing();
      }
	  
}
