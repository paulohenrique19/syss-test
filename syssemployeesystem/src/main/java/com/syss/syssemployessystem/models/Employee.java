package com.syss.syssemployessystem.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="employee") 
public class Employee {

	@Id
	private String id;
	private String name;
	private String email;
	private String department;
	private double salary;
	private String birth_date;
	
	public Employee() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@NotBlank(message = "Name cannot be null")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@NotBlank(message = "Email cannot be null")
	@Email(message = "Invalid email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotBlank(message = "Department cannot be null")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	
	public double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@NotBlank(message = "Birth date cannot be null")
	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	
	
}
