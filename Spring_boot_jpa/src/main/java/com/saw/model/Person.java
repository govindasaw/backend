/**
 * 
 */
package com.saw.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Govin
 *
 */
// Using the MappedSuperclass strategy
@MappedSuperclass
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personId;
	private String name;
	/**
	 * 
	 */
	public Person() {
		super();
	}
	/**
	 * @param personId
	 * @param name
	 */
	public Person(Long personId, String name) {
		super();
		this.personId = personId;
		this.name = name;
	}
	/**
	 * @return the personId
	 */
	public Long getPersonId() {
		return personId;
	}
	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + "]";
	}
	
	

}
