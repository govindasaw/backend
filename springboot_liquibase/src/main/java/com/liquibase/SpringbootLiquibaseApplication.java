package com.liquibase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.liquibase.model.Employee;
import com.liquibase.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootLiquibaseApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLiquibaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee = getEmployee();
		employeeRepository.save(employee);
	}

	private Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName("Govinda Saw");
		employee.setEmail("gsaw@gmail.com");
		employee.setSalary(50000.00);
		return employee;
	}

}
