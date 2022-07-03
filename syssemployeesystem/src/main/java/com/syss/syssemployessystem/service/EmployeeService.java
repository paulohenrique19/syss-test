package com.syss.syssemployessystem.service;

import java.util.List;

import com.syss.syssemployessystem.models.Employee;

public interface EmployeeService {

	List<Employee> allEmployees();
	
	Employee employeePerID(String id);
	
	Employee newEmployee(Employee employee);
	
	Employee update(Employee employee);
	
	void delete(String id);
	
	
	
}
