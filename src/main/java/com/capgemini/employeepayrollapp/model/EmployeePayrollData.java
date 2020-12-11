package com.capgemini.employeepayrollapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "employee_payroll_data")
public class EmployeePayrollData {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeeId;
	private String name;
	private long salary;
	private char gender;
	
	@Column(name="start_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;
	private String notes;
//	private String email;
	
	public EmployeePayrollData() {
		
	}
	public EmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO) {
		this.employeeId=empId;
		this.name=empPayrollDTO.name;
		this.salary=empPayrollDTO.salary;
		this.gender=empPayrollDTO.gender;
		this.startDate=empPayrollDTO.startDate;
		this.notes=empPayrollDTO.notes;
	}
	
	public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		this.name=empPayrollDTO.name;
		this.salary=empPayrollDTO.salary;
		this.gender=empPayrollDTO.gender;
		this.startDate=empPayrollDTO.startDate;
		this.notes=empPayrollDTO.notes;
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
	public void setGender(char gender) {
		this.gender=gender;
	}
	public char getGender() {
		return this.gender;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate=startDate;
	}
	public LocalDate getStartDate() {
		return this.startDate;
	}
	public void setNotes(String notes) {
		this.notes=notes;
	}
	public String getNotes() {
		return this.notes;
	}
//	public void setEmail(String email) {
//		this.email=email;
//	}
//	public String getEmail() {
//		return this.email;
//	}
	@Override
	public String toString() {
		return "id:"+this.employeeId+"Name: "+this.name+"Salary: "+this.salary+"Start Date: "+this.startDate;
	}

}
