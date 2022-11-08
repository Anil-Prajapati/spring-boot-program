package com.nareshit.transationmgmt.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_insurance")
public class Insurance {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="insurance_id")
	private Integer insuranceId;


	private Integer empId;

	@Column(name="healthInsuranceSchemeName")
	private String healthInsuranceSchemeName;

	private int coverageAmount;

	public Integer getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getHealthInsuranceSchemeName() {
		return healthInsuranceSchemeName;
	}

	public void setHealthInsuranceSchemeName(String healthInsuranceSchemeName) {
		this.healthInsuranceSchemeName = healthInsuranceSchemeName;
	}

	public int getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(int coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public Insurance(Integer empId, String healthInsuranceSchemeName, int coverageAmount) {
		super();
		this.empId = empId;
		this.healthInsuranceSchemeName = healthInsuranceSchemeName;
		this.coverageAmount = coverageAmount;
	}

	public Insurance() {}

	@Override
	public String toString() {
		return "Insurance [insuranceId=" + insuranceId + ", empId=" + empId + ", healthInsuranceSchemeName="
				+ healthInsuranceSchemeName + ", coverageAmount=" + coverageAmount + "]";
	}








}
