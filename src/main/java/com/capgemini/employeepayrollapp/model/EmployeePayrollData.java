package com.capgemini.employeepayrollapp.model;

import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;

public class EmployeePayrollData {
	private int employeeId;
	private String name;
	private long salary;
	
	public EmployeePayrollData() {
		
	}
	public EmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO) {
		this.employeeId=empId;
		this.name=empPayrollDTO.name;
		this.salary=empPayrollDTO.salary;
	}
	public int getEmployeeId() {
		return this.employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId=employeeId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setSalary(long salary) {
		this.salary=salary;
	}
	public long getSalary() {
		return this.salary;
	}

}
