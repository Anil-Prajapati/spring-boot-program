package com.derivedmethod.implementation.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.derivedmethod.implementation.model.Employee;

public interface EmployeeRepositoryDAO extends CrudRepository<Employee, Long> {
	public List<Object[]> findMaxSalariesByDept(List<String> deptNames);
	
	
	
}
