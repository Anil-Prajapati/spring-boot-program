package com.nareshit.advjpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.advjpa.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long>{

	//Abstract Method for the Named Query having Group by Clause
		public List<Object[]> findMaxSalariesByDept(List<String> deptNames);
}
