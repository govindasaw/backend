/**
 * 
 */
package com.example.JDBCTemplete;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author Govin
 *
 */
public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("ID"));
		user.setUserName(rs.getString("USERNAME"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setCreatedTime(rs.getDate("CREATEDTIME"));
		user.setUpdatedTime(rs.getDate("UPDATEDTIME"));
		user.setUserType(UserType.valueOf(rs.getString("USERTYPE")));
		user.setDateofBirth(rs.getDate("DATEOFBIRTH"));
		return user;
	}

}
