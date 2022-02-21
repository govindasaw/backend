/**
 * 
 */
package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * @author Govin
 *
 */
@Service
public class CustomService {

	private Logger logger = LoggerFactory.getLogger(CustomService.class);

	public String fun(String object) {
		JsonObject jsonObject = new Gson().fromJson(object, JsonObject.class);
		logger.info(jsonObject.keySet().toString());
		return jsonObject.get("Total Test Cases").getAsString();

	}

}
