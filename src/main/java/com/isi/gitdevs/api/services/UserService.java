package com.isi.gitdevs.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isi.gitdevs.api.models.User;
import com.isi.gitdevs.api.repositories.UserRepository;

@Service
public class UserService implements UserInterface {

   @Autowired
   private UserRepository userRepository;

   @Override
   public List<User> listAll() {
      return this.userRepository.findAll();
   }

   @Override
   public User create(User user) {
      return this.userRepository.save(user);
   }

   @Override
   public User search(String login) {
      return this.userRepository.findById(login).orElse(null);
   }

   @Override
   public User update(User user) {
      return this.userRepository.save(user);
   }

   @Override
   public void delete(String id) {
      this.userRepository.deleteById(id);
   }

}