/**
 * 
 */
package com.saw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saw.model.MyEmployee;

/**
 * @author Govin
 *
 */
@Repository
public interface MyEmployeeRepository extends JpaRepository<MyEmployee, Long> {

}
