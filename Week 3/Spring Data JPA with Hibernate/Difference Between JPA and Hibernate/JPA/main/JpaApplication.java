package com.example.JPA;

import com.example.JPA.entity.Employee;
import com.example.JPA.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	public EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee emp = new Employee();
		emp.setName("Aditi");
		emp.setDepartment("IT");
		emp.setSalary(60000);

		employeeService.addEmployee(emp);
		System.out.println("Employee added using JpaApplication!");
	}
}
