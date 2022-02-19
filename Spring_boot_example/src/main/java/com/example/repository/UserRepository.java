/**
 * 
 */
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.User;

/**
 * @author Govin
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
