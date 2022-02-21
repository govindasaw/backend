/**
 * 
 */
package com.example.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.user.User;
import com.example.service.UserService;

/**
 * @author Govin
 *
 */
@RestController
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping(value = "/users", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = "application/json")
	public ResponseEntity<?> saveUsers(@RequestParam(value = "files") MultipartFile[] files) {

		Arrays.asList(files).forEach(obj -> {
			try {
//				BufferedReader br = new BufferedReader(new InputStreamReader(obj.getInputStream()));
				userService.saveUsers(new BufferedReader(new InputStreamReader(obj.getInputStream())));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		});
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@GetMapping(value = "/users", produces = "application/json")
	public CompletableFuture<ResponseEntity<?>> findAllUsers() {
		return userService.findAllUsers().thenApply(ResponseEntity::ok);
	}

	@GetMapping(value = "/getUsersByThread", produces = "application/json")
	public ResponseEntity<?> getUsers() {
		CompletableFuture<List<User>> users1 = userService.findAllUsers();
		CompletableFuture<List<User>> users2 = userService.findAllUsers();
		CompletableFuture<List<User>> users3 = userService.findAllUsers();
		CompletableFuture.allOf(users1, users2, users3).join();
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
