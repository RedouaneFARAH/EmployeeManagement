package com.javainuse.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Employee;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/employees" })
public class TestController {

	private List<Employee> employees = createList();

	@GetMapping(produces = "application/json")
	public List<Employee> firstPage() {
		return employees;
	}
	
	@DeleteMapping(path = { "/{id}" })
	public Employee delete(@PathVariable("id") String id) {
		Employee deletedEmp = null;
		System.out.println(id);
		for (Employee emp : employees) {
			if (emp.getEmpId().equals(id)) {
				employees.remove(emp);
				deletedEmp = emp;
				break;
			}
		}
		return deletedEmp;
	}

	@PostMapping
	public Employee create(@RequestBody Employee user) {
		employees.add(user);
		System.out.println(employees);
		return user;
	}
	
	private static List<Employee> createList() {
		List<Employee> tempEmployees = new ArrayList<Employee>();
		Employee emp1 = new Employee();
		emp1.setName("redouane");
		emp1.setDesignation("manager");
		emp1.setEmpId("1");
		emp1.setSalary(50000);

		Employee emp2 = new Employee();
		emp2.setName("ayoub");
		emp2.setDesignation("developer");
		emp2.setEmpId("2");
		emp2.setSalary(20000);
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);
		return tempEmployees;
	}


}