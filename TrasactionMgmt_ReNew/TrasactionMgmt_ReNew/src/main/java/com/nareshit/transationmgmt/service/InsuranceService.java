package com.nareshit.transationmgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.transationmgmt.dao.EmployeeDao;
import com.nareshit.transationmgmt.dao.InsuranceDao;
import com.nareshit.transationmgmt.model.Employee;
import com.nareshit.transationmgmt.model.Insurance;

@Service
public class InsuranceService {

	@Autowired
	private InsuranceDao insDao;


	public Insurance registerInsurance(Insurance ins) {
		return insDao.save(ins);
	}
}
