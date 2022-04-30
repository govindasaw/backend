/**
 * 
 */
package com.saw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saw.model.Book;

/**
 * @author Govin
 *
 */
public interface MyProductBookRepository extends JpaRepository<Book, Long> {

}
