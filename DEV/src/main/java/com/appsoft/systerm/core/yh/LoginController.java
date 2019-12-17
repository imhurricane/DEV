package com.appsoft.systerm.core.yh;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
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

	@PostMapping("/addUser")
	public ResponseEntity registerLoginUser(@RequestParam Map<String, Object> map) {

		String data = (String) map.get("data");
		System.out.println("data:" + data);
		JSONObject jsonObject = JSONObject.parseObject(data);

		LoginUser loginUser = new LoginUser();
		loginUser.setAge(jsonObject.getIntValue("age"));
		loginUser.setSex(jsonObject.getBooleanValue("sex"));
		loginUser.setUserLoginName(jsonObject.getString("userLoginName"));
		loginUser.setUserNameCh(jsonObject.getString("userNameCh"));
		loginUser.setUserPassword(jsonObject.getString("userPassword"));
		loginUser.setLastLoginTime(jsonObject.getString("lastLoginTime"));
		loginUser.setLastOperateTime(jsonObject.getString("lastOperateTime"));
		if (jsonObject.containsKey("userId")) {
			loginUser.setUserId(jsonObject.getString("userId"));
		}

		LoginUser saveUser = userService.saveUser(loginUser);
		ResponseEntity entity = new ResponseEntity();
		entity.setCode(Contaniner.CODE_200);
		entity.setMsg("保存成功");
		entity.setData(saveUser);
		return entity;
	}

	@PostMapping("login")
	public ResponseEntity login(String password, String userName, HttpSession session) {
		ResponseEntity entity = new ResponseEntity();
		LoginUser loginUser = userService.getLoginUser(userName, password);
		entity.setCode(Contaniner.CODE_200);
		entity.setMsg("登陆成功");
		entity.setData(loginUser);
		session.setAttribute("user", loginUser);
//		redis.set(user.getUserId(), session);
		log.info(loginUser.getUserPassword());
		return entity;
	}

	@PostMapping("/loginApp")
	public JSONObject loginApp(String password, String userName)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		JSONObject object = new JSONObject();
		String userXtm = AppTool.getUUID();
		object.put("userXtm", userXtm);
		object.put("userName", userName);
		object.put("currentUserXtm", userXtm);
		object.put("passWord", password);
		object.put("lastLoginDate", "2019-11-25 10:44:00");
		return object;
	}

	// getAccess
	@PostMapping("/getAccess")
	public HashMap getAccess(String userId) {
		HashMap map = new HashMap<>();
		ArrayList<String> list = new ArrayList<>();
		list.add("f08f65918489452383cf3b45f7d30cde");
		list.add("49bb921daf7b4b8aadb549d06f2c8ebb");
		list.add("70d848d2051e48e492954314bf769dcb");
		list.add("80fef14bfc4f4caaaed8149da0e6d914");
		list.add("4cbae71bb2a645969feee6d0298894ff");
		list.add("d3971cdfc8504af7b96228d7f64a4dcb");
		list.add("402882e86f031fd2016f032edd0f0007");
		list.add("402882e86f031fd2016f03308c7b0009");
		list.add("402882e86f031fd2016f03316594000b");
		list.add("402882e86f031fd2016f033311ef000d");
		list.add("70d848d2051e48e49294314bf769dasd");
		list.add("70d848d2051e48e49294314bf769dasd");
		list.add("70d848d2051e48e49294314bf769dasd");
		map.put("code", Contaniner.CODE_200);
		map.put("msg", "获取权限");
		map.put("access", list);
		return map;
	}

	@PostMapping("/getUser")
	public ResponseEntity getUser(int pageNum, int perPage) {
		Page page = userService.getUser(pageNum,perPage);
		
		List<LoginUser> users = page.getContent();

		ResponseEntity entity = new ResponseEntity();
		entity.setCode(Contaniner.CODE_200);
		entity.setData(users);
		entity.setTotal((int) page.getTotalElements());
		entity.setMsg("请求成功");
		return entity;
	}

	@PostMapping("/deleteSelectionsUser")
	public String deleteSelectionsUser(@RequestParam Map<String, Object> map) {
		String userIds = (String) map.get("xtmArray");
		JSONArray jsonArray = JSONArray.parseArray(userIds);
		for (int i = 0; i < jsonArray.size(); i++) {
			String userId = (String) jsonArray.get(i);
			System.out.println("userId:" + userId);
		}
		return "";
	}

	@PostMapping("/deleteUser")
	public String deleteUser(@RequestParam Map<String, Object> map) {

//		LoginUser user = userService.getUserById(id);
//		System.out.println("list:"+user);
		return "";
	}

	@PostMapping("/getUserById4")
	public LoginUser getUserById(String id) {
		LoginUser user = userService.getUserById(id);
		return user;
	}


}
