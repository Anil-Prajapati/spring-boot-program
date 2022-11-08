package com.nareshit.transationmgmt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.transationmgmt.model.Employee;
import com.nareshit.transationmgmt.model.Insurance;

@Repository
public interface InsuranceDao extends CrudRepository<Insurance, Integer> {

}
