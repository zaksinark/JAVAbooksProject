package com.zak.books.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.zak.books.models.Login;
import com.zak.books.models.User;
import com.zak.books.repositories.UserRepo;

@Service
public class UserService {
	private final UserRepo userRepo;
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}
	
	public User getOne(Long id) {
		Optional<User> user = userRepo.findById(id);
		return user.isPresent() ? user.get() : null;
	}
	
	public User getOne(String email) {
		Optional<User> user = userRepo.findByEmail(email);
		return user.isPresent() ? user.get() : null;
	}
	
	public User login(Login loginUser, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		User user = getOne(loginUser.getEmail());
		if(user == null) {
			result.rejectValue("email", "Unique", "Invalid cred");
			return null;
		}
		if(!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
			result.rejectValue("email", "Match", "Invalid cred");
			return null;
		}
		return user;
	}


}