package com.capgemini.employeepayrollapp.services;
import com.capgemini.employeepayrollapp.model.*;
import com.capgemini.employeepayrollapp.dto.*;
import java.util.*;

public interface IEmployeePayrollService {
	List<EmployeePayrollData> getEmployeePayrollData();
	EmployeePayrollData getEmployeePayrollDataById(int empId);
	
	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
	
	EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO);
	
	void deleteEmployeePayrollData(int empId);
}
