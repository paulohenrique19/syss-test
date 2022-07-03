package com.syss.syssemployessystem.service.impl;

import java.util.Optional;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syss.syssemployessystem.models.Employee;
import com.syss.syssemployessystem.repository.EmployeeRepository;
import com.syss.syssemployessystem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> allEmployees() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee employeePerID(String id) {
		
		Optional<Employee> obj = employeeRepository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public Employee newEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public Employee update(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public void delete(String id) {
		this.employeeRepository.deleteById(id);
	}

	

}
