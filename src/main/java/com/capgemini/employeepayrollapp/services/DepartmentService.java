package com.capgemini.employeepayrollapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.capgemini.employeepayrollapp.repository.DepartmentRepository;
import com.capgemini.employeepayrollapp.repository.EmployeeRepository;
import java.util.*;
import com.capgemini.employeepayrollapp.model.*;

@Service
@Configurable
public class DepartmentService implements IDepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	public List<Department> findByDeptName(String deptName){
		return departmentRepository.findByDeptName(deptName);
	}
	@Override
	public List<Department> getAllDepartment() {
		
		return departmentRepository.getAllDepartment();
	}

}
