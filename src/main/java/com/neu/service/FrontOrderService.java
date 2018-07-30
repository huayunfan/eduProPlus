
package com.neu.service;

import java.util.List;

import com.neu.po.OrderVO;

public interface FrontOrderService {

	public List<OrderVO> findAllorder();

	public List<OrderVO> findorderpaying();

	public List<OrderVO> findorderpaied();

	public List<OrderVO> findorderused();

	public List<OrderVO> findordercancel();

	public int deleteorder(int oid);

	public int pay(int oid);

	public int cancel( int oid);
}



