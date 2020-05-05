package com.PowerMonitoringSystem.services.impl;

import com.PowerMonitoringSystem.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.PowerMonitoringSystem.models.Roles;
import com.PowerMonitoringSystem.models.Users;
import com.PowerMonitoringSystem.repository.RoleRepository;
import com.PowerMonitoringSystem.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Users findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(Users user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Roles userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Roles>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

}