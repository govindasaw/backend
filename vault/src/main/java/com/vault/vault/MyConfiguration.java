/**
 * 
 */
package com.vault.vault;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @author gsaw
 *
 */
@ConfigurationProperties
@Data
public class MyConfiguration {

	private String key;

}
