/**
 * 
 */
package com.saw.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Govin
 *
 */
@Entity
@DiscriminatorValue("B")
public class Book extends MyProduct {

	private String author;

	/**
	 * @param productId
	 * @param name
	 * @param author
	 */
	public Book(long productId, String name, String author) {
		super(productId, name);
		this.author = author;
	}

	public Book() {
	}

	/**
	 * @param productId
	 * @param name
	 */
	public Book(long productId, String name) {
		super(productId, name);
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + "]";
	}

}
