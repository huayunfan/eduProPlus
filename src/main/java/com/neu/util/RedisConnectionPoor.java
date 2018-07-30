package com.neu.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public  class RedisConnectionPoor {
	private static String ADDR = "123.206.32.30";    
	private static int PORT = 6379;
	private static String AUTH = "";
	private static int MAX_ACTIVE = 1024;
	private static int MAX_IDLE = 200;
	private static long MAX_WAIT = 10000;
	private static int TIMEOUT = 10000;
	private static boolean TEST_ON_BORROW = true;    
	private static JedisPool jedisPool = null;

	public static Jedis getJedis(){
		
//		JedisPoolConfig只能通过set来传值
		JedisPoolConfig config = new JedisPoolConfig();
		
//		jedisPool只能通过构造方法来传值
		jedisPool = new JedisPool(config, ADDR, PORT);
		return jedisPool.getResource();
	}
	
	

}
