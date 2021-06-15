package com.example.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(emp -> employees.add(emp));
		return employees;
	}

	public Employee getEmployee(int id) {
		Employee employee = new Employee();
		employee = employeeRepository.findById(id).get();
		return employee;
	}

	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	public void deleteAllEmployees() {
		employeeRepository.deleteAll();
	}

	public void updateEmployee(Employee employee, int id) {
		employeeRepository.save(employee);
	}
}
