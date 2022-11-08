package com.nareshit.transationmgmt.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nareshit.transationmgmt.model.Employee;
import com.nareshit.transationmgmt.model.Insurance;

@Service
public class OrganizationService {

	@Autowired
	private EmployeeService empService;

	@Autowired
	private InsuranceService insService;

	//Default Behaviour of @Transactional is Full Commit or Full Rollback

	//If we want to achieve partial rollback or partial commit --> Propogration Level.

	@Transactional(propagation = Propagation.REQUIRED) //Default propogration level

					//i) Which is going to notify the database to start transaction block
					//ii) Temp. Memory area will be created
	          		///iii) Commit/Roollback wil be handled by framework
	public void onBoardEmployee(Employee emp, Insurance ins) {

		empService.saveEmployee(emp);  //DML1

		if (ins.getHealthInsuranceSchemeName().length() <= 4) {
			throw new RuntimeErrorException(null, "Error in Insurance");
		} else {
			ins.setEmpId(emp.getEmpId());

			insService.registerInsurance(ins); //DML2
		}
	}

}
