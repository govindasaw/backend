/**
 * 
 */
package com.cache.service;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

/**
 * @author Govin
 *
 */

@Service
public class NumberService {

	final static private Logger logger = LogManager.getLogger(NumberService.class.getName());

	@CachePut("posts")
	public BigDecimal square(Long number) {
		BigDecimal square = BigDecimal.valueOf(number).multiply(BigDecimal.valueOf(number));
		logger.info("square of {} is {}", number, square);
		return square;
	}

}
