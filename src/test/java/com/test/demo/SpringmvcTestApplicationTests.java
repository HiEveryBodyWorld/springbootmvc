package com.test.demo;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringmvcTestApplicationTests {
	
	@Before
	public void init()
	{
		System.out.println("init test");
	}
	@Test
	public void contextLoads() {
	}

}
