/**
 * 
 */
package com.saw.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Govin
 *
 */
//Using the MappedSuperclass strategy
@Entity
@Table(name="MYEMPLOYEES")
public class MyEmployee extends Person{
	
	private String company;

	/**
	 * 
	 */
	public MyEmployee() {
		super();
	}

	/**
	 * @param company
	 */
	public MyEmployee(String company) {
		super();
		this.company = company;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "MyEmployee [company=" + company + ", getPersonId()=" + getPersonId() + ", getName()=" + getName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
