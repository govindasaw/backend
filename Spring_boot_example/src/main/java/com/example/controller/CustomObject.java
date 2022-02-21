/**
 * 
 */
package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CustomService;

/**
 * @author Govin
 *
 */
@RestController
public class CustomObject {

	private Logger logger = LoggerFactory.getLogger(CustomObject.class);

	@Autowired
	CustomService service;

	@PostMapping(value = "/getValue")
	public String getString(@RequestBody String object) {
		logger.info("In getString method");
		return service.fun(object);

	}

}
