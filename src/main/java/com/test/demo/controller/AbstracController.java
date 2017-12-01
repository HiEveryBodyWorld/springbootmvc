package com.test.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import com.test.demo.db.entity.User;
import com.test.demo.db.repo.DepartmentRepository;
import com.test.demo.db.repo.UserRepository;
import com.test.demo.db.repo.nosql.RedisRepository;

public class AbstracController {

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected UserRepository userRepo;

	@Autowired
	protected DepartmentRepository departRepo;

	@Autowired
	protected RedisRepository redisRepo;

	/*
	 * @param pageNum 当前页
	 * 
	 * @param pageSize 每页条数
	 * 
	 * @param sortType 排序字段
	 * 
	 * @param direction 排序方向
	 */
	@SuppressWarnings("unlikely-arg-type")
	protected PageRequest buildPageRequest(int pageNum, int pageSize, String sortType, String direction) {
		Sort sort = null;

		if (sortType==null || "".equals(sortType)) {
			return new PageRequest(pageNum - 1, pageSize);
		} else if (sortType!=null && !"".equals(sortType)) {
			if (Direction.ASC.equals(direction)) {
				sort = new Sort(Direction.ASC, sortType);
			} else {
				sort = new Sort(Direction.DESC, sortType);
			}
			return new PageRequest(pageNum - 1, pageSize, sort);
		} else {
			sort = new Sort(Direction.ASC, sortType);
			return new PageRequest(pageNum - 1, pageSize, sort);
		}
	}

	protected PageRequest buildPageRequest(int pageNum, int pageSize, String sortType) {
		return buildPageRequest(pageNum, pageSize, sortType, null);
	}
	
	protected Specification<User> getUserWhere(String name) {
		Specification<User> specification = new Specification<User>() {

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				List<Predicate> predicate = new ArrayList<>();
				if (name!=null && !"".equals(name)) {
					predicate.add(cb.like(root.get("username").as(String.class), name+"%"));
				}
				Predicate[] pre = new Predicate[predicate.size()];
                return query.where(predicate.toArray(pre)).getRestriction();
			}
			
		};
		return specification;
	}

}
