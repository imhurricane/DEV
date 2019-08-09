package com.appsoft.systerm.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsoft.systerm.user.User;

@Service
public class LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	
	public User login(String yhm, String passWord) {
		return loginMapper.login(yhm, passWord);
	}
}
