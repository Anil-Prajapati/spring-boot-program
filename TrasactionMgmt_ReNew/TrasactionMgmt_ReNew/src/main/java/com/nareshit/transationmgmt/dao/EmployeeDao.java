package com.nareshit.transationmgmt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.transationmgmt.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

}
