package com.capgemini.employeepayrollapp.model;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.persistence.JoinColumn;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.employeepayrollapp.controllers.EmployeePayrollController;
import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.capgemini.employeepayrollapp.services.*;
import lombok.Data;

@Entity
@Table(name = "employee_payroll_data")
@Data
public class EmployeePayrollData {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int employeeId;
	private String name;
	private long salary;
	private char gender;
	
	@Column(name="profile_pic")
	private String profilePic;
	@Column(name="start_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;
	private String notes;
	@ElementCollection
	@CollectionTable(name="employee_department",joinColumns = @JoinColumn(name = "id"))
	@Column(name="department")
	private List<String> departments;
	
	public EmployeePayrollData() {
		
	}
	public EmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO) {
		this.employeeId=empId;
		this.updateEmployeePayrollData(empPayrollDTO);
	}
	
	public void updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		this.name=empPayrollDTO.name;
		this.salary=empPayrollDTO.salary;
		this.gender=empPayrollDTO.gender;
		this.startDate=empPayrollDTO.startDate;
		this.notes=empPayrollDTO.notes;
		this.profilePic=empPayrollDTO.profilePic;
		this.departments=empPayrollDTO.departments;
	}
}
