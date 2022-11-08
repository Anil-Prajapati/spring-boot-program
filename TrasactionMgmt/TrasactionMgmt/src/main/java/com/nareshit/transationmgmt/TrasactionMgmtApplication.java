package com.nareshit.transationmgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nareshit.transationmgmt.model.Employee;
import com.nareshit.transationmgmt.model.Insurance;
import com.nareshit.transationmgmt.service.OrganizationService;

@SpringBootApplication
public class TrasactionMgmtApplication implements CommandLineRunner{


	@Autowired
	private OrganizationService orgService;

	public static void main(String[] args) {
		SpringApplication.run(TrasactionMgmtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee emp = new Employee();
		emp.setEmpName("Arun");

		Insurance employeeHealthInsurance = new Insurance();
		employeeHealthInsurance.setHealthInsuranceSchemeName("TestArun");
		employeeHealthInsurance.setCoverageAmount(1000000);

		orgService.onBoardEmployee(emp, employeeHealthInsurance);

	}

}
