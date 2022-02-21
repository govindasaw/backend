/**
 * 
 */
package com.example.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.book.Book;

/**
 * @author Govin
 *
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

}
