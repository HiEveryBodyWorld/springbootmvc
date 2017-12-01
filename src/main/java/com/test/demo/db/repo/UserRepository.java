package com.test.demo.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.test.demo.db.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User>{

	User findByUsernameLike(String name);
}
