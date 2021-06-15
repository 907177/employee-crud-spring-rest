package com.example.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springboot.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
