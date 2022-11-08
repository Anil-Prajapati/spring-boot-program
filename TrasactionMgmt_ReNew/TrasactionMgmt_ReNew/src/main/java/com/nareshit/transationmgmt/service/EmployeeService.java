package com.nareshit.transationmgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.transationmgmt.dao.EmployeeDao;
import com.nareshit.transationmgmt.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao empDao;


	public Employee saveEmployee(Employee emp) {
		return empDao.save(emp);
	}
}
