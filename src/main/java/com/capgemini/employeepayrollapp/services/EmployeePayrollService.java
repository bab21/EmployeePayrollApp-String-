package com.capgemini.employeepayrollapp.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;
import com.capgemini.employeepayrollapp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		List<EmployeePayrollData> empDataList =new ArrayList<>();
		empDataList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("Suruchi",30000)));
		return empDataList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		EmployeePayrollData empData =null;
		empData =new EmployeePayrollData(1,new EmployeePayrollDTO("Yashi",30000));
		return empData;
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData =null;
		empData =new EmployeePayrollData(1,empPayrollDTO);
		return empData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData =null;
		empData =new EmployeePayrollData(1,empPayrollDTO);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		// TODO Auto-generated method stub
		
	}
	
	
}
