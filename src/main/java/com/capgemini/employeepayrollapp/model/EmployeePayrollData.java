package com.capgemini.employeepayrollapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;

@Entity
public class EmployeePayrollData {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
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
