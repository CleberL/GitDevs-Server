package com.isi.gitdevs.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.isi.gitdevs.api.models.User;

public interface UserRepository extends MongoRepository<User, String> {
	
}