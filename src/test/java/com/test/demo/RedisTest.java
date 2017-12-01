package com.test.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.demo.db.repo.nosql.RedisRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	RedisRepository redisRepo;
	
	
	@Test
	public void testRedis(){
		redisRepo.add("test", "123", 1L);
		String val = redisRepo.get("test");
		assertEquals(val, "123");
		System.out.println(val);
		val = redisRepo.get("321");
		System.out.println(val);
		assertNull(val);
	}
}
