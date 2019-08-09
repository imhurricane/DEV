package com.appsoft.systerm.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsoft.utils.AppTool;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@RequestMapping("/register")
	public User addUser(String nc,String yhm,String passWord,String tel) {
		
//		JSONObject data = (JSONObject) JSONObject.parse(name);
//		
//		String str = (String) data.get("name");
//		System.out.println("str:"+str);
		System.out.println("name:"+nc);
		User user = new User();
		String id = AppTool.getUUID();
		user.setId(id);
		user.setTel(tel);
		user.setName(nc);
		user.setPassWord(passWord);
		user.setYhm(yhm);
		int count = userService.saveUser(user);
		System.out.println("count:"+count);
		if(count > 0) {
			return user;
		}
		return null;
	}
	
	
	@RequestMapping("/delUser")
	public String delUser(String name) {
		
		return "";
	}
	
	@RequestMapping("/changeUser")
	public User changeUser(String id) {
		User user = userService.getUserById(id);
		System.out.println("list:"+user);
		return user;
	}
	
	@RequestMapping("/getUserById")
	public User getUserById(String id) {
		User user = userService.getUserById(id);
		return user;
	}
	
	
	@RequestMapping("/getUser")
	public List<User> getUsersByName() {
		List<User> list = userService.getUser();
		return list;
	}
	
	
	
}
