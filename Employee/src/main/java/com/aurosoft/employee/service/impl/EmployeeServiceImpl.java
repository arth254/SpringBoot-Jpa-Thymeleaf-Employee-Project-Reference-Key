package com.aurosoft.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurosoft.employee.entity.Employee;
import com.aurosoft.employee.repository.EmployeeRepository;
import com.aurosoft.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository repository;
	
	
	
	@Override
	public List<Employee> listAllEmployees() {
		
		return repository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return repository.findById(id).orElseThrow();
	}

	@Override
	public void insertEmployee(Employee employee) {
		
		repository.save(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		repository.save(employee);
		
	}

	@Override
	public int deleteEmployee(int id) {
		
		 repository.deleteById(id);
		 return id;
	}

	

}
