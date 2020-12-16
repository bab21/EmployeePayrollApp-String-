package com.capgemini.employeepayrollapp.dto;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.*;

import lombok.ToString;

public @ToString class EmployeePayrollDTO {
	@Pattern(regexp ="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee name Invalid")
	public String name;
	@Min(value =500,message ="Min wage should be 500")
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
	
}
