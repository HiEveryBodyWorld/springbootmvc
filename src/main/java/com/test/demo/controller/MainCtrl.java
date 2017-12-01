package com.test.demo.controller;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.db.entity.User;






@RestController
@RequestMapping("/service/user")
public class MainCtrl extends AbstracController{	
	
	
	@RequestMapping("/login/{name}")
	Object login(@PathVariable("name") String name,HttpServletRequest request)
	{		
		log.debug("invoke user by name:"+name);
		request.getSession().setAttribute("user", name);
		//User user =userRepo.findByUsernameLike(name+"%"); 
		return "login ok";
	}
	
	@RequestMapping("/get/{page}/{size}/{order}")
	Object getpage(@PathVariable("page") Integer page,@PathVariable("size") Integer size,
			@PathVariable("order") String order)
	{		
				
		
		Page<User> lst = userRepo.findAll(buildPageRequest(page, size, order,"desc"));		
		
		log.info("total:"+lst.getTotalElements());
		return lst;
	}
	
	@RequestMapping("/get")
	Object getuser(HttpServletRequest request)
	{				
		String uname =(String)request.getSession().getAttribute("user");
		User user =userRepo.findByUsernameLike(uname+"%");
		
		return user;
	}
	
	@RequestMapping("/find/{name}")
	Object find(@PathVariable("name") String name)
	{				
		Specification<User> userspec = getUserWhere(name);
		
		return userRepo.findAll(userspec);
	}
	
	
	@RequestMapping("redis/get")
	Object getRedis()
	{
		return redisRepo.get("name");
	}
	
	
}
