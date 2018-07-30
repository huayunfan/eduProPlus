package com.neu.service;

import java.util.List;

import com.neu.po.FreeListenVO;



public interface FrontReserveService 
{
   public List<FreeListenVO> findAllReserve();

   public List<FreeListenVO> findReserved();

   public List<FreeListenVO> findReserveing();
}
