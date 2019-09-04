package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.model.CustomUserDetail;
import com.model.User;
import com.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	// Find all User
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	// Find User by username
	public User findByID(int id) {
		Optional<User> op = userRepository.findById(id);
		if (!op.isPresent()) {
			System.out.println("Not exist user id: " + id);
			return null;
		}
		return op.get();
	}

	// Add or update User
	public void save(User user) {
		userRepository.save(user);
	}

	// Delete User
	public void delete(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetail(user);
	}
}
