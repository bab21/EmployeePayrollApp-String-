package com.capgemini.employeepayrollapp.services;
import java.util.*;

import org.springframework.stereotype.Service;

import com.capgemini.employeepayrollapp.model.*;
@Service
public interface IDepartmentService {
	List<Department> findByDeptName(String deptName);

	List<Department> getAllDepartment();
}
