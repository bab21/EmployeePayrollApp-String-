package com.capgemini.employeepayrollapp.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;
import com.capgemini.employeepayrollapp.model.EmployeePayrollData;
import com.capgemini.employeepayrollapp.repository.EmployeeRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{
	private List<EmployeePayrollData> employeePayrollList=new ArrayList<>();
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeeRepository.getAllEmployees();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeeRepository.findEmployeeById(empId);
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData =null;
		empData =new EmployeePayrollData(empPayrollDTO);
		employeePayrollList.add(empData);
		employeeRepository.save(empData);
		return empData;
	}

	public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData =this.getEmployeePayrollDataById(empId);
		
		empData.setName(empPayrollDTO.name);
		empData.setSalary(empPayrollDTO.salary);
		employeeRepository.save(empData);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeeRepository.deleteById(empId);
	}
	
}
