package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EmployeeDAO.Employeedao;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeerestController
{
private EmployeeService employeeservice;
@Autowired
public EmployeerestController(EmployeeService theEmployeeService)
{
	employeeservice=theEmployeeService;
}
@GetMapping("/employees")
public List<Employee> findAll()
{
	return employeeservice.findAll();
	
}
@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId)
	{
	Employee theEmployee=employeeservice.findById(employeeId);
	if(theEmployee==null)
	{
		
	}
		return theEmployee;
	
	}
@PostMapping("/employees/{employeeId}")
public Employee addEmployee(@RequestBody Employee theEmployee)
{
	theEmployee.setId(0);
	employeeservice.save(theEmployee);
	return theEmployee;
}
@PutMapping("/employeees")
public Employee updateEmployee(@RequestBody Employee theEmployee)
{
	employeeservice.save(theEmployee);
	return theEmployee;
}
@DeleteMapping("/employees/{employeeId}")
public String deleteEmployee(@PathVariable int employeeId)
{
	Employee tempEmployee=employeeservice.findById(employeeId);
	if(tempEmployee==null)
	{
		throw new RuntimeException("Employee id not found" +employeeId);
	}
	employeeservice.deleteById(employeeId);
	return "Deleted employee id"+employeeId;

}
}
