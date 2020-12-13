package com.capgemini.employeepayrollapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int deptId;
	private String deptName;
	
	public Department() {
	}
	
	public Department(String department) {
		// TODO Auto-generated constructor stu
		this.deptName=department;
	}

	public String getDeptName() {
		return this.deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName=deptName;
	}
	public int getDeptId() {
		return this.deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId=deptId;
	}
}
