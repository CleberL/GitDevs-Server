package com.isi.gitdevs.api.services;

import java.util.List;

import com.isi.gitdevs.api.models.User;

public interface UserInterface {

	List<User> listAll();

	User create(User user);

	User search(String login);

	User update(User user);

	void delete(String login);

}
