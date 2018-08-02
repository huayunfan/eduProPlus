package com.neu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.beans.Address;
import com.neu.beans.Lesson;
import com.neu.beans.SOrder;
import com.neu.mapper.FrontOrderMapper;
import com.neu.po.OrderVO;
import com.neu.service.FrontOrderService;

@Service
public class FrontOrderServiceImpl implements FrontOrderService {

	@Autowired
    FrontOrderMapper mapper;
	
	@Override
	public List<OrderVO> findAllorder() {
		System.out.println("...Service...findAllorder().....");
		List<OrderVO> list=new ArrayList<OrderVO>();
		List<SOrder> orderList = null;			
		try {
			orderList=mapper.getOrderByOpenid("oC9yV5KjYiv_zu6qJ0pm_WlN4LEk");//???? ???? ?? openid  ???? ?????????
			
			for (SOrder sOrder : orderList) {
				OrderVO ordervo = new OrderVO();
				Lesson lesson = mapper.getLesssonById(sOrder.getLid());
				Address address = mapper.getLessonAdderss(sOrder.getBranchid());
				ordervo.setAddress(address);
				ordervo.setLesson(lesson);
				ordervo.setSorder(sOrder);
				list.add(ordervo);
			}
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderVO> findorderpaying() {
		System.out.println("...Service...findorderpaying().....");
		List<OrderVO> list=new ArrayList<OrderVO>();
		List<SOrder> orderList = null;			
		try {
			orderList=mapper.getOrderByOpenid("oC9yV5KjYiv_zu6qJ0pm_WlN4LEk");//???? ???? ?? openid  ???? ?????????
			
			for (SOrder Sorder : orderList) {
				OrderVO ordervo = new OrderVO();
				if(Sorder.getStatus().equals("???"))
				{
					Lesson lesson = mapper.getLesssonById(Sorder.getLid());
					Address address = mapper.getLessonAdderss(Sorder.getBranchid());
					ordervo.setAddress(address);
					ordervo.setLesson(lesson);
					ordervo.setSorder(Sorder);
					list.add(ordervo);
				}		
			}
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderVO> findorderpaied() {
		System.out.println("...Service...findorderpaied().....");
		List<OrderVO> list=new ArrayList<OrderVO>();
		List<SOrder> orderList = null;			
		try {
			orderList=mapper.getOrderByOpenid("oC9yV5KjYiv_zu6qJ0pm_WlN4LEk");//???? ???? ?? openid  ???? ?????????
			
			for (SOrder Sorder : orderList) {
				OrderVO ordervo = new OrderVO();
				if(Sorder.getStatus().equals("???"))
				{
					Lesson lesson = mapper.getLesssonById(Sorder.getLid());
					Address address = mapper.getLessonAdderss(Sorder.getBranchid());
					ordervo.setAddress(address);
					ordervo.setLesson(lesson);
					ordervo.setSorder(Sorder);
					list.add(ordervo);
				}		
			}
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderVO> findorderused() {
		System.out.println("...Service...findorderused().....");
		List<OrderVO> list=new ArrayList<OrderVO>();
		List<SOrder> orderList = null;			
		try {
			orderList=mapper.getOrderByOpenid("oC9yV5KjYiv_zu6qJ0pm_WlN4LEk");//???? ???? ?? openid  ???? ?????????
			
			for (SOrder Sorder : orderList) {
				OrderVO ordervo = new OrderVO();
				if(Sorder.getStatus().equals("???"))
				{
					Lesson lesson = mapper.getLesssonById(Sorder.getLid());
					Address address = mapper.getLessonAdderss(Sorder.getBranchid());
					ordervo.setAddress(address);
					ordervo.setLesson(lesson);
					ordervo.setSorder(Sorder);
					list.add(ordervo);
				}		
			}
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderVO> findordercancel() {
		System.out.println("...Service...findordercalcel().....");
		List<OrderVO> list=new ArrayList<OrderVO>();
		List<SOrder> orderList = null;			
		try {
			orderList=mapper.getOrderByOpenid("oC9yV5KjYiv_zu6qJ0pm_WlN4LEk");//???? ???? ?? openid  ???? ?????????
			
			for (SOrder Sorder : orderList) {
				OrderVO ordervo = new OrderVO();
				if((Sorder.getStatus().equals("???"))||(Sorder.getStatus().equals("???")))
				{
					Lesson lesson = mapper.getLesssonById(Sorder.getLid());
					Address address = mapper.getLessonAdderss(Sorder.getBranchid());
					ordervo.setAddress(address);
					ordervo.setLesson(lesson);
					ordervo.setSorder(Sorder);
					list.add(ordervo);
				}		
			}
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteorder( int oid) {
		System.out.println("...Service...deleteorder().....");
		int a;	
		try {
			a=mapper.deleteorderbyoid(oid);			
		} catch (Exception e) {
			a=0;
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int pay(int oid) {
		System.out.println("...Service...pay().....");
		int a;			
		try {
			a=mapper.paybyoid(oid);
						
		} catch (Exception e) {
			a=0;
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int cancel(int oid) {
		System.out.println("...Service...cancel().....");
		int a;			
		try {
			a=mapper.cancelbyoid(oid);
			
		
		} catch (Exception e) {
			a=0;
			e.printStackTrace();
		}
		return a;
	}
	


	

}

