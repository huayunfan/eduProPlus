package com.neu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.beans.FreeListen;
import com.neu.beans.Lesson;
import com.neu.beans.Swiper;
import com.neu.mapper.FrontHomeMapper;
import com.neu.service.FrontHomeService;
import com.neu.util.RedisConnectionPoor;

import redis.clients.jedis.Jedis;

@Service
public class FrontHomeServiceBean implements FrontHomeService {

	@Autowired
	FrontHomeMapper frontHomeMapper;
	
	@Override
	public List<String> getHomeImg(int qid) throws Exception {
		System.out.println(".......>FrontHomeService.....>getHomeImg");
		
		Jedis jedis = RedisConnectionPoor.getJedis();
		System.out.println("-1");
		List<String> lists = jedis.lrange("imgurl", 0, -1);
		System.out.println(lists+"0");
		if(lists == null || lists.size()==0){
			
			List<Swiper> list = frontHomeMapper.getHomeImg(qid);
			for (Swiper swiper : list) {
				jedis.lpush("imgurl", swiper.getImgurl());
			}
			lists = jedis.lrange("imgurl", 0, -1);
			System.out.println(lists+"1");
		}
		System.out.println(lists+"2");
		return lists;
	}

	@Override
	public List<Lesson> getTwoLesson(int qid) throws Exception {
		System.out.println(".......>FrontHomeService.....>getTwoLesson");
		return frontHomeMapper.getnewTwoLesson(qid);
	}

	@Override
	public List<FreeListen> getTwoFreeListen(int qid) throws Exception {
		System.out.println(".......>FrontHomeService.....>getTwoFreeListen");
		return frontHomeMapper.getNewTwoFreeListen(qid);
	}

}
