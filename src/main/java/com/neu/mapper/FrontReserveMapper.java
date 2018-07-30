
package com.neu.mapper;

import java.util.List;

import com.neu.po.FreeListenVO;

public interface FrontReserveMapper 
{

	public List<FreeListenVO> findAllreserve() throws Exception;

	public List<FreeListenVO> findreserved() throws Exception;

	public List<FreeListenVO> findreserveing()throws Exception;
		
}


