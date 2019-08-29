package com.appsoft.systerm.core.menu;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsoft.systerm.redis.RedisService;

@RestController
public class MenuController {
	
	private final Logger log = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	private RedisService redis;
	
	@RequestMapping("/getMenu")
	public ArrayList<Router> getAccess() {
		
		ArrayList<Router> routerList = new ArrayList<>();
		Router router = new Router();
		router.setPath("/");
		router.setName("/");
		router.setComponent("Main");
		Meta meta = new Meta();
		meta.setTitle("首页");
		meta.setIcon("md-menu");
		ArrayList<String> list = new ArrayList<>();
		list.add("49bb921daf7b4b8aadb549d06f2c8ebb");
		meta.setAccess(list);
		router.setMeta(meta);
		
		
		Router childMain = new Router();
		childMain.setPath("home");
		childMain.setName("home");
		childMain.setComponent("Main");
		Meta metaMain = new Meta();
		metaMain.setTitle("首页");
		metaMain.setIcon("md-menu");
		ArrayList<String> listMain = new ArrayList<>();
		listMain.add("f08f65918489452383cf3b45f7d30cde");
		metaMain.setAccess(listMain);
		childMain.setMeta(metaMain);
		ArrayList<Router> routerMainList = new ArrayList<>();
		routerMainList.add(childMain);
		router.setChildren(routerMainList);
		
		routerList.add(router);
		
		
		Router router1 = new Router();
		router1.setPath("/setings");
		router1.setName("/setings");
		router1.setComponent("Main");
		Meta meta1 = new Meta();
		meta1.setTitle("系统设置");
		meta1.setIcon("md-menu");
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("80fef14bfc4f4caaaed8149da0e6d914");
		meta1.setAccess(list1);
		router1.setMeta(meta1);
		
		
		Router childMain1 = new Router();
		childMain1.setPath("UserInfo");
		childMain1.setName("UserInfo");
		childMain1.setComponent("info/user/UserMap");
		Meta metaMain1 = new Meta();
		metaMain1.setTitle("用户配置");
		metaMain1.setIcon("md-funnel");
		ArrayList<String> listMain1 = new ArrayList<>();
		listMain1.add("4cbae71bb2a645969feee6d0298894ff");
		metaMain1.setAccess(listMain1);
		childMain1.setMeta(metaMain1);
		ArrayList<Router> routerMainList1 = new ArrayList<>();
		routerMainList1.add(childMain1);
		
		Router childMain11 = new Router();
		childMain11.setPath("org");
		childMain11.setName("org");
		childMain11.setComponent("setings/org/org");
		Meta metaMain11 = new Meta();
		metaMain11.setTitle("机构配置");
		metaMain11.setIcon("md-funnel");
		ArrayList<String> listMain11 = new ArrayList<>();
		listMain11.add("70d848d2051e48e492954314bf769dcb");
		metaMain11.setAccess(listMain11);
		childMain11.setMeta(metaMain11);
//		ArrayList<Router> routerMainList11 = new ArrayList<>();
//		routerMainList1.add(childMain11);
		routerMainList1.add(childMain11);
		
		
		router1.setChildren(routerMainList1);
		
		
		
		routerList.add(router1);
		
		log.info("routerList:"+routerList.toString());
		
		return routerList;
	}
	
	
}
