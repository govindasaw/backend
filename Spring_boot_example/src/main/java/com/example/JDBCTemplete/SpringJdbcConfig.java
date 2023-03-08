/**
 * 
 */
package com.example.JDBCTemplete;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Govin
 *
 */
@Configuration
@ComponentScan("com.example.JDBCTemplete")
@Slf4j
public class SpringJdbcConfig {

	// MYSQL database configuration
	@Bean
	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/practice");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		log.info("MYSQL database configured");
		
		return dataSource;
	}

	// H2 Database config
//	@Bean
//	public DataSource dataSource() {
//		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("classpath:jdbc/schema.sql")
//				.addScript("classpath:jdbc/test-data.sql").build();
//	}

}
