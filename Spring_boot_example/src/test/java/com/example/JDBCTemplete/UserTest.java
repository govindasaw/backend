/**
 * 
 */
package com.example.JDBCTemplete;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Govin
 *
 */
@SpringBootTest
@Slf4j
public class UserTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	@DisplayName("find-all-users-test")
	void findAllUsersTest() {
		log.info("JDBC Templete Test");
		String sql = "SELECT * FROM USER";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		assertTrue(users.size() == 12);
		users.forEach(System.err::println); // just to print in red color
	}

	@DisplayName("find-users-by-type-test")
	@ParameterizedTest
	@EnumSource(value = UserType.class)
	void findUsersByTypeTest(UserType userType) {
		log.info("Start");
		String sql = "SELECT * FROM USER WHERE USERTYPE = ?";
		List<User> users = jdbcTemplate.query(sql, new Object[] { userType }, new int[] { Types.VARCHAR },
				new UserMapper());
		log.info("UserType : {}", userType);
		if (userType.equals(UserType.STUDENT))
			assertTrue(users.size() == 4);
		else
			assertTrue(users.size() == 8);

		System.err.println(users);

		log.info("End");
	}

	@DisplayName("find-users-by-name-test")
	@ParameterizedTest
	@ValueSource(strings = { "%Peter%" })
	void findUsersByNameTest(String name) {
		log.info("Start");
		String sql = "SELECT * FROM USER where USERNAME LIKE ?";
		Map<UserType, List<User>> users = jdbcTemplate.query(sql, new Object[] { name }, new UserResultSetExtracter());
		assertTrue(users.get(UserType.STUDENT).size() == 2);
		assertTrue(users.get(UserType.EMPLOYEE).size() == 2);
		log.info("End");
	}
}
