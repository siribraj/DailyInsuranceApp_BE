package com.daily.insurance.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.daily.insurance.model.RegistrationResponse;
import com.daily.insurance.model.User;
import com.daily.insurance.service.ClientServiceImpl;

@AutoConfigureMockMvc
@SpringBootTest
class ClientControllerTest {
	
	@Mock
	private ClientServiceImpl clientService;
	
	@InjectMocks
	private ClientController clientController;

	@Test
	void testAddClient() {
		RegistrationResponse res = new RegistrationResponse();
		res.setStatusCode("200");
		res.setResponseMessage("Registration successful");
		res.setUserName("raymond");
		
		when(clientController.addClient(any())).thenReturn(res);

		assertEquals("200", res.getStatusCode());
	}

	@Test
	void testLogin() {
		User user = new User();
		user.setFirtName("Raymond");
		user.setLastName("Holt");
		user.setEmailId("raymond@gmail.com");
		user.setUserName("raymond");
		user.setPassword("Raymond@1");
		
		when(clientController.login(any())).thenReturn(user);
		assertEquals("raymond", user.getUserName());
	}

	@Test
	void testGetUserById() {
		User user = new User();
		user.setId(1);
		user.setFirtName("Raymond");
		user.setLastName("Holt");
		user.setEmailId("raymond@gmail.com");
		user.setUserName("raymond");
		user.setPassword("Raymond@1");
		
		when(clientController.getUserById(1)).thenReturn(user);
		assertEquals("raymond", user.getUserName());
	}

}
