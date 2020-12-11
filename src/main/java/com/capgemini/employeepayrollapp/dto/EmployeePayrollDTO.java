package com.capgemini.employeepayrollapp.dto;
import java.time.LocalDate;
public class EmployeePayrollDTO {
	public String name;
	public long salary;
	public char gender;
	public LocalDate startDate;
	public String notes;
	
	public EmployeePayrollDTO(String name,long salary,char gender,LocalDate startDate,String notes) {
		this.name=name;
		this.salary=salary;
		this.gender=gender;
		this.startDate=startDate;
		this.notes=notes;
	}
	public String toString() {
		return "Name= "+name+" Salary= "+salary+"gender= "+gender+"Start Date "+startDate+" Notes :"+notes;
	}
}
