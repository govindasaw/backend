/**
 * 
 */
package com.example.controller.stringToXMLDocument;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.stringToXMLDocument.StringToXMLDocumentService;

/**
 * @author Govin
 *
 */
@RestController
@RequestMapping("/stringToXMLDocument")
public class StringToXMLDocument {

	private Logger logger = LoggerFactory.getLogger(StringToXMLDocument.class);

	@Autowired
	private StringToXMLDocumentService service;

	@PostMapping(value = "/getXMLString")
	public String getString(@RequestBody String xmlString) {
		logger.info("In Controller method");
		return service.convertStringToXMLDocument(xmlString);

	}

}
