package com.syss.syssemployessystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.syss.syssemployessystem.models.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

	

	
	
	
	
}
