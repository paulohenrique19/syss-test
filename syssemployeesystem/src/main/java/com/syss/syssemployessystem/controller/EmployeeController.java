package com.syss.syssemployessystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syss.syssemployessystem.models.Employee;
import com.syss.syssemployessystem.responses.Response;
import com.syss.syssemployessystem.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(path = "/employees")
@Api(value="SYSS Employee Manager")
@CrossOrigin(origins="*")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	@ApiOperation(value="List all employee's")
	public ResponseEntity<Response<List<Employee>>> allEmployees(){
		return ResponseEntity.ok(new Response<List<Employee>>(this.employeeService.allEmployees()));
	}
	
	@GetMapping(path = "/{id}")
	@ApiOperation(value="Get employee per ID")
	public ResponseEntity<Response<Employee>> employeePerID(@PathVariable(name = "id") String id){
		return ResponseEntity.ok(new Response<Employee>(this.employeeService.employeePerID(id)));
	}
	
	@PostMapping
	@ApiOperation(value="Register a new employee")
	public ResponseEntity<Response<Employee>> newEmployee(@Valid @RequestBody Employee employee, BindingResult result){
		if (result.hasErrors()) {
			List<String> error = new ArrayList<String>();
			result.getAllErrors().forEach(errors -> error.add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Employee>(error));
			
		}
		return ResponseEntity.ok(new Response<Employee>(this.employeeService.newEmployee(employee)));
	}
	
	@PutMapping(path = "/{id}")
	@ApiOperation(value="Update a employee")
	public ResponseEntity<Response<Employee>> update(@PathVariable(name = "id") String id, @Valid @RequestBody Employee employee, BindingResult result){
		if (result.hasErrors()) {
			List<String> error = new ArrayList<String>();
			result.getAllErrors().forEach(errors -> error.add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Employee>(error));
			
		}
		employee.setId(id);
		return ResponseEntity.ok(new Response<Employee>(this.employeeService.update(employee)));
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value="Delete a employee")
	public ResponseEntity<Response<Integer>> delete(@PathVariable(name = "id") String id){
		this.employeeService.delete(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
	
	
		
	
	
}
