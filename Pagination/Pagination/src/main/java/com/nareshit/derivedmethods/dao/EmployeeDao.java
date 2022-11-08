package com.nareshit.derivedmethods.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.derivedmethods.model.Employee;
import com.nareshit.derivedmethods.model.Person;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long>{




	//Abstract Method for the Named Query having Group by Clause
	public List<Object[]> findMaxSalariesByDept(List<String> deptNames);



}
