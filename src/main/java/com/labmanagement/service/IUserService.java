package com.labmanagement.service;

import com.labmanagement.model.entity.User;

public interface IUserService {

	Object login(User userLogin) throws Exception;
	Object register(User user);
	Boolean verifyToken(String token);
	
}
