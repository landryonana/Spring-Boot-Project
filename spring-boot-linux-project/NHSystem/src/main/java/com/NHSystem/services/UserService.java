package com.NHSystem.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.NHSystem.entities.Role;
import com.NHSystem.entities.User;
import com.NHSystem.repositories.UserRepository;

@Service
public class UserService {

		@Autowired
		private UserRepository userRepo;
		
		public void createUser(User user) {
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			Role userRole = new Role("USER");
			List<Role> roles = new ArrayList<>();
			roles.add(userRole);
			user.setRoles(roles);
			userRepo.save(user);
			
		}
		
		public void createAdmin(User user) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			Role role = new Role("ADMIN");
			List<Role> roles = new ArrayList<>();
			roles.add(role);
			userRepo.save(user);
		}
		
		public User getUserByEmail(String email) {
			
			return userRepo.findUserByEmail(email);
		}

		public boolean isUserPresent(String email) {
			
			User user =userRepo.findUserByEmail(email);
			if(user!=null)
				return true;
			
			return false;
		}

		public List<User> findAll() {
			
			return userRepo.findAll();
		}

		public List<User> findByName(String name) {
			
			return userRepo.findUserByNameLike("%"+name+"%");
		}
	
}
