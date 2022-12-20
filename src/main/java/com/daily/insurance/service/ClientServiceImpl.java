package com.daily.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.insurance.model.User;
import com.daily.insurance.model.Constants;
import com.daily.insurance.model.LoginRequest;
import com.daily.insurance.model.RegistrationRequest;
import com.daily.insurance.model.RegistrationResponse;
import com.daily.insurance.repository.ClientRepo;
import com.daily.insurance.utils.PasswordUtils;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepo clientRepo;

	private PasswordUtils util = new PasswordUtils();

	@Override
	public RegistrationResponse addClient(RegistrationRequest req) {
		User user = new User();
		String hashPassword = util.hashPassword(req.getPassword());
		user.setId(req.getId());
		user.setFirtName(req.getFirstName());
		user.setLastName(req.getLastName());
		user.setUserName(req.getUserName());
		user.setPassword(hashPassword);
		user.setEmailId(req.getEmailId());
		User saveRes = clientRepo.saveAndFlush(user);
		RegistrationResponse res = new RegistrationResponse();
		res.setUserName(saveRes.getUserName());
		res.setStatusCode(Constants.SUCCESS_CODE.toString());
		res.setResponseMessage(Constants.REG_SUCCESS_MSG.toString());
		return res;
	}

	@Override
	public User login(LoginRequest req) {
		User user = clientRepo.findClient(req.getUsername());
		if (user != null) {
			if (util.checkPass(req.getPassword(), user.getPassword())) {
				return user;
			} else
				return null;
		}
		return null;
	}

	@Override
	public User findUserById(int userId) {
		return clientRepo.findById(userId).get();
	}

}
