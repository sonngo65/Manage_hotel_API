package com.example.ShopWebAPI.service;

import com.example.ShopWebAPI.entity.Employee;
import com.example.ShopWebAPI.payload.EmployeeDto;

public interface EmployeeService {
	Employee add(Employee empl);
	Employee update(Employee empl);
	Employee remove(Employee empl);
}
