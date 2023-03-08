/**
 * 
 */
package com.example.JDBCTemplete;

import java.util.Date;

import lombok.Data;

/**
 * @author Govin
 *
 */
@Data
public class User {

	private Long id;
	private String userName;
	private String password;
	private Date createdTime;
	private Date updatedTime;
	private Date dateofBirth;
	private UserType userType; // Enum Type

}

enum UserType {

	EMPLOYEE, STUDENT;
}
