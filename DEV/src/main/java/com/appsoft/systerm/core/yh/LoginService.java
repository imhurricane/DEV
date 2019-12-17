package com.appsoft.systerm.core.yh;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Autowired
	private LoginUserRepository userRepository;
	
	public Page getUser(int pageNum,int prePage){
		//,Sort.Direction.ASC,("xh")
		PageRequest pageable = PageRequest.of(pageNum-1, prePage);
		
		return userRepository.findAll(pageable);
	};
	
	
	public LoginUser getUserById(String id){
		return loginMapper.getUserById(id);
	};
	
	public LoginUser saveUser(LoginUser user) {
		
		return userRepository.save(user);
	}
	
	public LoginUser getLoginUser(String yhm,String passWord){
		return loginMapper.login(yhm, passWord);
	};
	
}
