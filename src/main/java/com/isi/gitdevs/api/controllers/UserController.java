package com.isi.gitdevs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isi.gitdevs.api.models.User;
import com.isi.gitdevs.api.services.UserInterface;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserInterface userInterface;

	@GetMapping
	public ResponseEntity<List<User>> listAll() {
		return ResponseEntity.ok(this.userInterface.listAll());
	}

	@GetMapping(path = "/{login}")
	public ResponseEntity<User> search(@PathVariable(name = "login") String login) {
		return ResponseEntity.ok(this.userInterface.search(login));
	}

	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user) {
		return ResponseEntity.ok(this.userInterface.create(user));
	}

	@PutMapping(path = "/{login}")
	public ResponseEntity<User> update(@PathVariable(name = "login") String login, @RequestBody User user) {
		user.setLogin(login);
		return ResponseEntity.ok(this.userInterface.update(user));
	}

	@DeleteMapping(path = "/{login}")
	public ResponseEntity<Integer> delete(@PathVariable(name = "login") String login) {
		this.userInterface.delete(login);
		return ResponseEntity.ok(1);
	}

}