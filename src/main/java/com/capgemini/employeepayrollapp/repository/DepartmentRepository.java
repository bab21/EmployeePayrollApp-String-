package com.capgemini.employeepayrollapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.employeepayrollapp.model.*;
import java.util.*;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer>{
	
	@Query(value ="SELECT * FROM department d WHERE d.dept_name=:deptName",nativeQuery=true)
	public List<Department> findByDeptName(@Param("deptName") String deptName);

	@Query(value = "SELECT * FROM department",nativeQuery=true)
	public List<Department> getAllDepartment();
	
//	@Query(value ="SELECT * FROM employee_payroll_data e WHERE e.employee_id=:empId",nativeQuery=true)
//	public EmployeePayrollData findEmployeeById(@Param("empId")int empId);
}
