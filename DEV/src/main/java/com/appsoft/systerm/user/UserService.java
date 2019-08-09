package com.appsoft.systerm.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public List<User> getUser(){
		return userMapper.getUser();
	};
	
	
	public User getUserById(String id){
		return userMapper.getUserById(id);
	};
	
	public int saveUser(User user) {
		return userMapper.insertUser(user);
	}
	
}
