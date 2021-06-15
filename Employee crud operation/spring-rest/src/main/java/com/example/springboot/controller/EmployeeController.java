package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Employee;
import com.example.springboot.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employee")
	private List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employee/{empid}")
	private Employee getEmployee(@PathVariable("empid") int id) {
		return employeeService.getEmployee(id);
	}

	@DeleteMapping("/employee/{empid}")
	private void deleteEmployee(@PathVariable("empid") int id) {
		employeeService.deleteEmployee(id);
	}

	@DeleteMapping("/employee")
	private void deleteAllEmployee() {
		employeeService.deleteAllEmployees();
	}

	@PostMapping("/employee")
	private int addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return employee.getEmp_id();
	}

	@PutMapping("/employee/{empid}")
	private Employee update(@RequestBody Employee employee, @PathVariable("empid") int id) {
		employeeService.updateEmployee(employee, id);
		return employee;
	}
}