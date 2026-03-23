package com.cdsc.spirngmvcdemo.service;

import com.cdsc.spirngmvcdemo.model.User;

public interface UserService {

	void userSignup(User user);
	
	User userLogin(String un, String psw);

}
