package com.appsoft.systerm.core.yh;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.appsoft.systerm.Response.Contaniner;
import com.appsoft.systerm.Response.ResponseEntity;
import com.appsoft.systerm.redis.RedisService;
import com.appsoft.utils.AppTool;

@RestController
@RequestMapping("userInfo")
public class LoginController {
	
	private final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService userService;

	@Autowired
	private RedisService redis;
	
	@RequestMapping("/register")
	public LoginUser registerLoginUser(HttpSession session,String nc,String userName,String passWord,String tel) {
		
//		JSONObject data = (JSONObject) JSONObject.parse(name);
//		
		LoginUser loginUser = new LoginUser();
		loginUser.setUserId(AppTool.getUUID());
		loginUser.setAge(18);
		loginUser.setSex("男");
		loginUser.setUserLoginName(userName);
		loginUser.setUserNameCh("超级管理员");
		loginUser.setUserPassword(passWord);
		userService.saveUser(loginUser);

		return loginUser;
	}
	
	@RequestMapping("login")
	public ResponseEntity login(String password, String userName,HttpSession session) {
		ResponseEntity entity = new ResponseEntity();
		LoginUser loginUser = userService.getLoginUser(userName,password);
		entity.setCode(Contaniner.CODE_200);
		entity.setMsg("登陆成功");
		entity.setData(loginUser);
		session.setAttribute("user", loginUser);
//		redis.set(user.getUserId(), session);
		log.info(loginUser.getUserNameCh());
		return entity;
	}
	
	@RequestMapping("/loginApp")
	public JSONObject loginApp(String password, String userName) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		JSONObject object = new JSONObject();
		String userXtm = AppTool.getUUID();
		object.put("userXtm", userXtm);
		object.put("userName", userName);
		object.put("currentUserXtm", userXtm);
		object.put("passWord", password);
		object.put("lastLoginDate", "2019-11-25 10:44:00");
		return object;
	}
	
	//getAccess
	@RequestMapping("/getAccess")
	public HashMap getAccess(String userId) {
		HashMap map = new HashMap<>();
		ArrayList<String> list = new ArrayList<>();
		list.add("f08f65918489452383cf3b45f7d30cde");
		list.add("49bb921daf7b4b8aadb549d06f2c8ebb");
		list.add("70d848d2051e48e492954314bf769dcb");
		list.add("80fef14bfc4f4caaaed8149da0e6d914");
		list.add("4cbae71bb2a645969feee6d0298894ff");
		list.add("d3971cdfc8504af7b96228d7f64a4dcb");
		map.put("code", Contaniner.CODE_200);
		map.put("msg", "获取权限");
		map.put("access", list);
		return map;
	}
	
	@RequestMapping("/getUser")
	public ArrayList<LoginUser> getUser() {
		ArrayList<LoginUser> list = userService.getUser();
		log.debug("list:"+list);
		return list;
	}
	
	@RequestMapping("/organization")
	public String changeUser(String id) {
//		LoginUser user = userService.getUserById(id);
//		System.out.println("list:"+user);
		return "";
	}
	
	@RequestMapping("/zy")
	public String zy(String id) {
//		LoginUser user = userService.getUserById(id);
//		System.out.println("list:"+user);
		return "";
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
