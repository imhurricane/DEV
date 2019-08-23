package com.appsoft.systerm.core.yh;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsoft.utils.AppTool;

@RestController
@RequestMapping("Login")
public class LoginController {
	
	private final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService userService;

	
	@RequestMapping("/register1")
	public LoginUser registerLoginUser(String nc,String yhm,String passWord,String tel) {
		
//		JSONObject data = (JSONObject) JSONObject.parse(name);
//		
//		String str = (String) data.get("name");
//		System.out.println("str:"+str);
		System.out.println("name:"+nc);
		LoginUser user = new LoginUser();
		String id = AppTool.getUUID();
		user.setUserId(id);
		
		int count = userService.saveUser(user);
		System.out.println("count:"+count);
		if(count > 0) {
			return user;
		}
		return null;
	}
	
	
	@RequestMapping("/delUser2")
	public String delUser(String name) {
		
		return "";
	}
	
	@RequestMapping("/changeUser3")
	public LoginUser changeUser(String id) {
		LoginUser user = userService.getUserById(id);
		System.out.println("list:"+user);
		return user;
	}
	
	@RequestMapping("/getUserById4")
	public LoginUser getUserById(String id) {
		LoginUser user = userService.getUserById(id);
		return user;
	}
	
	
	@RequestMapping("/getUser5")
	public List<LoginUser> getUsersByName() {
		List<LoginUser> list = userService.getUser();
		return list;
	}
	
	
	
}
