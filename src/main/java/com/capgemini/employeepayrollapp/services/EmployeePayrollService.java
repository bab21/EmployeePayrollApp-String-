package com.capgemini.employeepayrollapp.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;
import com.capgemini.employeepayrollapp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{
	private List<EmployeePayrollData> employeePayrollList=new ArrayList<>();

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeePayrollList.get(empId-1);
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData =null;
		empData =new EmployeePayrollData(employeePayrollList.size()+1,empPayrollDTO);
		employeePayrollList.add(empData);
		return empData;
	}

	public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData =this.getEmployeePayrollDataById(empId);
		
		empData.setName(empPayrollDTO.name);
		empData.setSalary(empPayrollDTO.salary);
		employeePayrollList.set(empId-1, empData);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeePayrollList.remove(empId-1);
	}
	
	
}
