package com.capgemini.employeepayrollapp.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.capgemini.employeepayrollapp.dto.EmployeePayrollDTO;
import com.capgemini.employeepayrollapp.dto.ResponseDTO;
import com.capgemini.employeepayrollapp.model.Department;
import com.capgemini.employeepayrollapp.model.EmployeePayrollData;
import com.capgemini.employeepayrollapp.repository.EmployeeRepository;
import com.capgemini.employeepayrollapp.services.EmailService;
import com.capgemini.employeepayrollapp.services.IDepartmentService;
import com.capgemini.employeepayrollapp.services.IEmployeePayrollService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.capgemini.employeepayrollapp.exceptions.CustomException;
import java.util.*;

import javax.validation.Valid;

@CrossOrigin( origins="*",allowedHeaders = "*")
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeePayrollController.class);
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	@Autowired
	private IDepartmentService departmentService;
	@Autowired
	private EmailService emailService;
	
	
	@RequestMapping(value= {"","/","/get"})
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
		List<EmployeePayrollData> empDataList =null;
		empDataList =employeePayrollService.getEmployeePayrollData();
		ResponseDTO respDTO =new ResponseDTO("Get Call for ID Successfull",empDataList);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value= {"/department"})
	public ResponseEntity<ResponseDTO> getAllDepartments(){
		List<Department> deptList =null;
		deptList = departmentService.getAllDepartment();
		ResponseDTO respDTO =new ResponseDTO("Get Call for ID Successfull",deptList);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
		
	}
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
		logger.info("Inside Controller");
		if(empId==0) {
			logger.info("This Id does not exit");
			throw new CustomException("This Id does not exits");
		}
		EmployeePayrollData empData =null;
		empData =employeePayrollService.getEmployeePayrollDataById(empId);
		ResponseDTO respDTO =new ResponseDTO("Get Call for ID Successfull",empData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(
							 @Valid @RequestBody EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData empData=null;
		empData =employeePayrollService.createEmployeePayrollData(empPayrollDTO);
		emailService.sendSimpleMessage("queen212811@gmail.com", "checking", "Hello there");
		ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully",empData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
		
	}
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
							@Valid @RequestBody EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData empData=null;
		empData =employeePayrollService.updateEmployeePayrollData(empId,empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully",empData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
		employeePayrollService.deleteEmployeePayrollData(empId);
		ResponseDTO respDTO =new ResponseDTO("Deleted Successfully","Deleted id: "+empId);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@ExceptionHandler({CustomException.class})
    public String handleException(CustomException e) {
        System.out.println("Exception occurred");
        return "Error";
    }
	
}
