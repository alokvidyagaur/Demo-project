package com.example.demo.EmployeeDAO;

import java.util.List;

import com.example.demo.entity.Employee;

public interface Employeedao 
{
 public List<Employee> findAll();

public void deleteById(int theId);

public void save(Employee theEmployee);

public Employee findById(int theId);
 
}
