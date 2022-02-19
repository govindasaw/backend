/**
 * 
 */
package com.example.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

/**
 * @author Govin
 *
 */
@Service
public class UserService {

	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Async
	public CompletableFuture<List<User>> saveUsers(BufferedReader br) throws Exception {

		long start = System.currentTimeMillis();
		List<User> users = parseCSVFile(br);
		logger.info("saving list of users of size {}", users.size(), "" + Thread.currentThread().getName());
		users = userRepository.saveAll(users);
		long end = System.currentTimeMillis();
		logger.info("Total time {}", (end - start));
		return CompletableFuture.completedFuture(users);

	}

	@Async
	public CompletableFuture<List<User>> findAllUsers() {
		logger.info("get list of user by " + Thread.currentThread().getName());
		List<User> users = userRepository.findAll();
		return CompletableFuture.completedFuture(users);
	}

	private List<User> parseCSVFile(final BufferedReader br) throws Exception {
		final List<User> users = new ArrayList<>();
		try {
			String line;
			while ((line = br.readLine()) != null) {
				final String[] data = line.split(",");
				final User user = new User();
				user.setName(data[0]);
				user.setEmail(data[1]);
				user.setGender(data[2]);
				users.add(user);
			}
			return users;
		} catch (

		FileNotFoundException e) {
			logger.error(e.getMessage());
			throw new FileNotFoundException(e.getMessage());
		} catch (IOException e) {
			logger.error("Failed to parse CSV file {}", e);
			throw new Exception("Failed to parse CSV file {}", e);
		}
	}
}
