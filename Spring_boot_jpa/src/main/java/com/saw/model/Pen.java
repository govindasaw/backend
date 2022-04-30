/**
 * 
 */
package com.saw.model;

import javax.persistence.Entity;

/**
 * @author Govin
 *
 */
@Entity
public class Pen extends MyProduct {
	private String color;

	/**
	 * @param productId
	 * @param name
	 */
	public Pen(long productId, String name) {
		super(productId, name);
	}

	public Pen() {
	}

	/**
	 * @param productId
	 * @param name
	 * @param color
	 */
	public Pen(long productId, String name, String color) {
		super(productId, name);
		this.color = color;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Pen [color=" + color + "]";
	}

}
