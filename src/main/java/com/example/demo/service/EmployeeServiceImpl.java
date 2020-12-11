package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.EmployeeDAO.Employeedao;
import com.example.demo.entity.Employee;
@Service
public  class EmployeeServiceImpl implements EmployeeService {
    
	private Employeedao employeedao;
	@Autowired
	public EmployeeServiceImpl (Employeedao theEmployeeDao)
	{
	employeedao=theEmployeeDao;
	}
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeedao.findAll();
	}

	
	@Override
	@Transactional
	public  void deleteById(int theId) {
	
		employeedao.deleteById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		 employeedao.save(theEmployee);
		
	}
	@Override
	@Transactional
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeedao.findById(theId);
		 
	}

}
