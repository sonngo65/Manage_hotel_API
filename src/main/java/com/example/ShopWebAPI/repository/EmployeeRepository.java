package com.example.ShopWebAPI.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ShopWebAPI.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, UUID>{

}
