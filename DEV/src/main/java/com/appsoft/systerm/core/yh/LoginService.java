package com.appsoft.systerm.core.yh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	public List<LoginUser> getUser(){
		return (List<LoginUser>) loginMapper.login("", "");
	};
	
	
	public LoginUser getUserById(String id){
		return loginMapper.getUserById(id);
	};
	
	public int saveUser(LoginUser user) {
		return 0;
	}
	
}
