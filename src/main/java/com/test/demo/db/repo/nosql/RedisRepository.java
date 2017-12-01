package com.test.demo.db.repo.nosql;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository {

	@Autowired
	RedisTemplate<String, String> redisTemplate;
	
	public void add(String key,String value) {
		redisTemplate.opsForValue().set(key, value);
	}
	public void add(String key,String value,Long time) {
		redisTemplate.opsForValue().set(key, value, time, TimeUnit.MINUTES);
	}
	
	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}
	
	public void delete(String key) {
		redisTemplate.opsForValue().getOperations().delete(key);
	}
	
}
