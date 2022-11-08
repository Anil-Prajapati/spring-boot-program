package com.nareshit.transationmgmt.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nareshit.transationmgmt.model.Audit;
import com.nareshit.transationmgmt.model.Employee;
import com.nareshit.transationmgmt.model.Insurance;

@Service
public class OrganizationService {

	@Autowired
	private EmployeeService empService;

	@Autowired
	private InsuranceService insService;


	@Autowired
	private AuditService auditService;

	//Default Behaviour of @Transactional is Full Commit or Full Rollback

	//If we want to achieve partial rollback or partial commit --> Propogration Level.

	@Transactional(propagation = Propagation.REQUIRED) //Default propogration level

					//i) Which is going to notify the database to start transaction block
					//ii) Temp. Memory area will be created
	          		///iii) Commit/Roollback wil be handled by framework
	public void onBoardEmployee(Employee emp, Insurance ins) {



		Employee employee = empService.saveEmployee(emp);  //T1

		if (employee.getEmpId() != null) {
			//T2
			auditService.updateAudit(new Audit("Employee creation is sucess for " + employee.getEmpName()));
			ins.setEmpId(employee.getEmpId());

		} else {
			//2
			auditService.updateAudit(new Audit("Employee creation is Failed for " + employee.getEmpName()));
		}




		if (ins.getHealthInsuranceSchemeName().length() <= 4) {
			//T3
			auditService.updateAudit(new Audit("Insurance creation is Failed for  with insurance Name ....."
					+ ins.getHealthInsuranceSchemeName() + ".....For the Employe ...." + employee.getEmpName()));
			throw new RuntimeErrorException(null, "Error in Insurance");
		}

		else {
			//T1

			insService.registerInsurance(ins);
			//T3
			auditService.updateAudit(new Audit("Insurance creation is Sucess for " + employee.getEmpName()));
		}
	}

}
