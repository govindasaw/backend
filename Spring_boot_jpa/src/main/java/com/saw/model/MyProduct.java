/**
 * 
 */
package com.saw.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author Govin
 *
 */

//The Single Table strategy creates one table for each class hierarchy
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class MyProduct {
	
	@Id
    private long productId;
    private String name;
	/**
	 * @param productId
	 * @param name
	 */
	public MyProduct(long productId, String name) {
		super();
		this.productId = productId;
		this.name = name;
	}
	/**
	 * 
	 */
	public MyProduct() {
		super();
	}
	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
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
		return "MyProduct [productId=" + productId + ", name=" + name + "]";
	}
    
    

}
