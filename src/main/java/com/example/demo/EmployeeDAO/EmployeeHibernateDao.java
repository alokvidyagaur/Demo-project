package com.example.demo.EmployeeDAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;
@Repository
public class EmployeeHibernateDao implements Employeedao {

	private EntityManager entitymanager;
	@Autowired
	public EmployeeHibernateDao (EntityManager theEntityManager)
	{
		entitymanager=theEntityManager;
	}
	@Override

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		Session CurrentSession=entitymanager.unwrap(Session.class);
		Query<Employee> theQuery=CurrentSession.createQuery("from Employee",Employee.class);
		List<Employee> employees=theQuery.getResultList();
		return employees;
	}
	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Session currentSession=entitymanager.unwrap(Session.class);
		Employee theEmployee=currentSession.get(Employee.class,theId);
		return theEmployee;
	}
	@Override
	public void save(Employee theEmployee) { 
		// TODO Auto-generated method stub
		Session currentSession=entitymanager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmployee);
	 
	
	}
	@Override
	public void deleteById(int theId) {
		Session currentSession=entitymanager.unwrap(Session.class);
		Query theQuery=currentSession.createQuery("delete from Employee where id=:EmployeeId ");
		theQuery.setParameter("employeeId",theId);
		
		theQuery.executeUpdate();
		
		
	}

}
