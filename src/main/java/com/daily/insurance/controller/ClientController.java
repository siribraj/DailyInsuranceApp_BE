package com.daily.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daily.insurance.model.LoginRequest;
import com.daily.insurance.model.RegistrationRequest;
import com.daily.insurance.model.RegistrationResponse;
import com.daily.insurance.model.User;
import com.daily.insurance.service.ClientServiceImpl;
import com.daily.insurance.service.PolicyServiceImpl;

@RestController
@CrossOrigin("*")
public class ClientController {

	@Autowired
	ClientServiceImpl clientService;

	@Autowired
	PolicyServiceImpl policyService;

	@PostMapping("/register")
	public RegistrationResponse addClient(@RequestBody RegistrationRequest req) {
		return clientService.addClient(req);
	}

	@PostMapping("/login")
	public User login(@RequestBody LoginRequest request) {
		return clientService.login(request);
	}
	
	@GetMapping("/userInfo/{userId}")
	public User getUserById(@PathVariable("userId") int userId) {
		return clientService.findUserById(userId);
		
	}

}
