package com.capgemini.employeepayrollapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.employeepayrollapp.model.EmployeePayrollData;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeePayrollData,Integer> {
	
	@Query(value = "SELECT * FROM employee_payroll_data ", nativeQuery=true )
    public List<EmployeePayrollData> getAllEmployees();
	
	@Query(value ="SELECT * FROM employee_payroll_data e WHERE e.employee_id=:empId",nativeQuery=true)
	public EmployeePayrollData findEmployeeById(@Param("empId")int empId);

	public List<EmployeePayrollData> findBySalary(long l);

	public EmployeePayrollData findBySalaryAndStartDate(long l, String string);
	
}
