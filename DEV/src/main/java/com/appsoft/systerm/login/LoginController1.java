package com.appsoft.systerm.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsoft.systerm.http.HttpService;
import com.appsoft.systerm.redis.RedisService;
import com.appsoft.systerm.user.User;

@RestController
public class LoginController {

	@Autowired
	private LoginService LoginService;
	
	@Autowired
	private HttpService httpService;
	
	@Autowired
	private RedisService redis;
	
	@RequestMapping("/login")
	public User login(@RequestParam String yhm,@RequestParam String passWord) {
		try {
			httpService.doPost("http:www.baidu.com");
			redis.set("", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("yhm:"+yhm);
		User user = LoginService.login(yhm, passWord);
		
		if(user != null) {
			return user;
		}
		
		return null;
	}
}
