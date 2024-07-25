package com.jadecross.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jadecross.payroll.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}