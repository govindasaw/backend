/**
 * 
 */
package com.example.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.user.User;

/**
 * @author Govin
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
