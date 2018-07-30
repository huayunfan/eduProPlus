package com.neu.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.neu.beans.Enterprise;
import com.neu.mapper.FrontCompanyMapper;
import com.neu.service.FrontCompanyService;
import com.neu.util.RedisConnectionPoor;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
@Service
public class FrontCompanyServiceImpl implements FrontCompanyService {

	@Autowired
	FrontCompanyMapper  mapper;
	
	@Autowired
	JedisPool jedisPool;
	
	@Override
	public Enterprise findEnterprise(int qid)  throws Exception{
		Enterprise enterprise;		
		enterprise=mapper.getenterprise(qid);
		return enterprise;
		
//		try {
//			enterprise=mapper.getenterprise(qid);
//		} catch (Exception e) {
//			enterprise=null;
//			e.printStackTrace();
//		}
//		System.out.println("...Service...findEnterprise().....");
//		Gson gson = new Gson();
//		Jedis jedis = jedisPool.getResource();
//		String enterpriseStr = jedis.get("enterprise"+qid);
////		System.out.println(enterpriseStr+"0");
//		if(enterpriseStr ==null || enterpriseStr == ""){
////			System.out.println("1");
//			enterpriseStr = gson.toJson(mapper.getenterprise(qid));
//			jedis.set("enterprise"+qid, enterpriseStr);
//			enterpriseStr = jedis.get("enterprise"+qid);
////			System.out.println(enterpriseStr+"1");
//		}
////		System.out.println(enterpriseStr+"2");
//		enterprise = gson.fromJson(enterpriseStr, Enterprise.class);
	}

}
