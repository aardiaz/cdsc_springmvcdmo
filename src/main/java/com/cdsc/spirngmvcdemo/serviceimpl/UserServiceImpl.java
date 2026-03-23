package com.cdsc.spirngmvcdemo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.cdsc.spirngmvcdemo.model.User;
import com.cdsc.spirngmvcdemo.repository.UserRepository;
import com.cdsc.spirngmvcdemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository  userRepo;

	@Override
	public void userSignup(User user) {
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userRepo.save(user);
	}

	@Override
	public User userLogin(String un, String psw) {
		
		return userRepo.findByUsernameAndPassword(un, DigestUtils.md5DigestAsHex(psw.getBytes()));
	}

}
