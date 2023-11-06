package com.example.ShopWebAPI.service.impl;

import org.springframework.stereotype.Service;

import com.example.ShopWebAPI.entity.Employee;
import com.example.ShopWebAPI.payload.EmployeeDto;
import com.example.ShopWebAPI.repository.EmployeeRepository;
import com.example.ShopWebAPI.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	private final EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee add(Employee empl) {
		Employee savedEmployee = employeeRepository.save(empl);
		
		return savedEmployee;
	}

	@Override
	public Employee update(Employee empl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee remove(Employee empl) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
