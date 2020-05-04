package com.PowerMonitoringSystem.services.api;

import com.PowerMonitoringSystem.models.Users;

public interface UserService {

	public Users findUserByEmail(String email);

	public void saveUser(Users user);
}