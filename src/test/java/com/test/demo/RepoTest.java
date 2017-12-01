package com.test.demo;

import static org.junit.Assert.*;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.demo.db.entity.Department;
import com.test.demo.db.entity.User;
import com.test.demo.db.repo.DepartmentRepository;
import com.test.demo.db.repo.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepoTest {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	DepartmentRepository departRepo;

	@Test
	public void testNotNull() {
		assertNotNull(userRepo);
		assertNotNull(departRepo);
	}
	
	@Test
	@Transactional
	@Rollback
	public void testUserRepo()
	{
		long ori = userRepo.count();		//查看当前数量
		Department department = departRepo.findOne(1);
		User user = new User();
		user.setDepartment(department);
		user.setUsername("test");
		System.out.println(user.getId());
		userRepo.save(user);				//插入一条信息
		System.out.println(user.getId());	
		assertEquals(++ori, userRepo.count());//验证数量是否加1
	}
	

}
