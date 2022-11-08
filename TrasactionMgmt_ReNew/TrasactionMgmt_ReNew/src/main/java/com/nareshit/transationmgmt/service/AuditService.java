package com.nareshit.transationmgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nareshit.transationmgmt.dao.AuditDao;
import com.nareshit.transationmgmt.dao.EmployeeDao;
import com.nareshit.transationmgmt.model.Audit;
import com.nareshit.transationmgmt.model.Employee;

@Service
public class AuditService {

	@Autowired
	private AuditDao auditDao;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Audit updateAudit(Audit audit) {
		return auditDao.save(audit);
	}
}
