/**
 * 
 */
package com.example.service.stringToXMLDocument;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @author Govin
 *
 */
@Service
public class StringToXMLDocumentService {

	private Logger logger = LoggerFactory.getLogger(StringToXMLDocumentService.class);

	public String convertStringToXMLDocument(String xmlString) {

		logger.info("String:-  {}", xmlString.length());

		// Parser that produces DOM object trees from XML content
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// API to obtain DOM Document instance
		DocumentBuilder builder = null;
		NodeList list = null;

		try {

			// optional, but recommended
			// process XML securely, avoid attacks like XML External Entities (XXE)
			factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

			// Create DocumentBuilder with default configuration
			builder = factory.newDocumentBuilder();

			// Parse the content to Document object
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));

			// optional, but recommended
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			// Verify XML document is build correctly
//			logger.info("doc 1st Child Node Name:- {}", doc.getDocumentElement().getNodeName());s

			// get <staff>
			list = doc.getElementsByTagName("staff");

			for (int temp = 0; temp < list.getLength(); temp++) {

				Node node = list.item(temp);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) node;

					// get staff's attribute
					String id = element.getAttribute("id");

					// get text
					String firstname = element.getElementsByTagName("firstname").item(0).getTextContent();
					String lastname = element.getElementsByTagName("lastname").item(0).getTextContent();
					String nickname = element.getElementsByTagName("nickname").item(0).getTextContent();

					NodeList salaryNodeList = element.getElementsByTagName("salary");
					String salary = salaryNodeList.item(0).getTextContent();

					// get salary's attribute
					String currency = salaryNodeList.item(0).getAttributes().getNamedItem("currency").getTextContent();

					System.out.println("Current Element :" + node.getNodeName());
					System.out.println("Staff Id : " + id);
					System.out.println("First Name : " + firstname);
					System.out.println("Last Name : " + lastname);
					System.out.println("Nick Name : " + nickname);
					System.out.printf("Salary [Currency] : %,.2f [%s]%n%n", Float.parseFloat(salary), currency);

				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {

			logger.error(e.getMessage());
		}
		return String.valueOf(list.getLength());

	}

}
