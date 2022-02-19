/**
 * 
 */
package com.vault.vault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Govin
 *
 */
@Getter
@ToString
@Configuration
public class Secretss {
	
	@Value("${username}")
	String username;

//	@Value("${password}")
//	String password;


}
