package com.capgemini.employeepayrollapp.dto;
import java.time.LocalDate;
import java.util.List;
public class EmployeePayrollDTO {
	public String name;
	public long salary;
	public char gender;
	public LocalDate startDate;
	public String notes;
	public String profilePic;
	public List<String> departments;
	public EmployeePayrollDTO(String name,long salary,char gender,LocalDate startDate,String notes,String profilePic,List<String> departments) {
		this.name=name;
		this.salary=salary;
		this.gender=gender;
		this.startDate=startDate;
		this.notes=notes;
		this.profilePic=profilePic;
		this.departments=departments;
		
	}
	public String toString() {
		return "Name= "+name+" Salary= "+salary+"gender= "+gender+"Start Date "+startDate+" Notes :"+notes;
	}
}
