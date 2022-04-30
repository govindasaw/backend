/**
 * 
 */
package com.cache.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cache.service.NumberService;

/**
 * @author Govin
 *
 */
@RestController
@RequestMapping(value = "/number")
public class NumberController {
	
	final static private Logger logger = LogManager.getLogger(NumberController.class.getName());
	
	@Autowired
    private NumberService numberService;

    @GetMapping(path = "/square/{number}")
    public String getSquare(@PathVariable Long number) {
    	logger.info("call numberService to square {}", number);
        return String.format("{\"square\": %s}", numberService.square(number));
    }

}
