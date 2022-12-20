package com.daily.insurance.service;

import com.daily.insurance.model.LoginRequest;
import com.daily.insurance.model.RegistrationRequest;
import com.daily.insurance.model.RegistrationResponse;
import com.daily.insurance.model.User;

public interface ClientService {

	public RegistrationResponse addClient(RegistrationRequest user);
	public User login(LoginRequest req);
	public User findUserById(int userId);
}
