package com.learn.micro.repository;

import com.learn.micro.module.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentService extends JpaRepository<Department, Long> {
}
