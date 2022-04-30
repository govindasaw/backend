/**
 * 
 */
package com.saw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saw.model.Book;
import com.saw.model.MyEmployee;
import com.saw.model.Pen;
import com.saw.repository.MyEmployeeRepository;
import com.saw.repository.MyProductBookRepository;
import com.saw.repository.MyProductPenRepository;

/**
 * @author Govin
 *
 */
@Service
public class MyService {

	@Autowired
	private MyEmployeeRepository repository;

	@Autowired
	private MyProductBookRepository bookRepo;

	@Autowired
	private MyProductPenRepository penRepo;

	public void saveEmployee() {
		MyEmployee emp = new MyEmployee("Infosys Ltd.");
		emp.setName("Govinda Saw");
		emp.setPersonId(740511L);

		MyEmployee emp2 = new MyEmployee("Harman Connected Services Corporation India Pvt. Ltd");
		emp.setName("Govinda Saw");
		emp.setPersonId(26962L);

		repository.save(emp);
		repository.save(emp2);
	}

	public void getAllEmployee() {
		List<MyEmployee> list = repository.findAll();

		list.forEach(System.out::println);
	}

	public void saveProduct() {
		Pen p = new Pen(1, "Pen", "Red");
		penRepo.save(p);

		Book b = new Book(2, "Java Book", "ABC");
		bookRepo.save(b);

	}
	
	public void getBookAndPen() {
		penRepo.findAll().forEach(System.out::print);;
		bookRepo.findAll().forEach(System.out::print);;
	}

}
