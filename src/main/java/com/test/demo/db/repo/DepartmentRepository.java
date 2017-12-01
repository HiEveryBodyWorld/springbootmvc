package com.test.demo.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.db.entity.Department;

@Repository
public interface DepartmentRepository extends  JpaRepository<Department, Integer>
{

}
