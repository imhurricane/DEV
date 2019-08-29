package com.appsoft.systerm.core.yh;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	public ArrayList<LoginUser> getUser(){
		return (ArrayList<LoginUser>) loginMapper.getUser();
	};
	
	
	public LoginUser getUserById(String id){
		return loginMapper.getUserById(id);
	};
	
	public int saveUser(LoginUser user) {
		return loginMapper.saveUser(user.getUserId(),user.getAge(),user.getSex(),user.getUserLoginName(),user.getUserNameCh(),user.getUserPassword());
	}
	
	public LoginUser getLoginUser(String yhm,String passWord){
		return loginMapper.login(yhm, passWord);
	};
	
}
