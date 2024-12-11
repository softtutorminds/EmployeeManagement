package com.pranay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranay.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
