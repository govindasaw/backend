/**
 * 
 */
package com.liquibase.repository;

import org.springframework.data.repository.CrudRepository;

import com.liquibase.model.Employee;

/**
 * @author Govin
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
