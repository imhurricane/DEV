package com.appsoft.systerm.core.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.appsoft.systerm.Response.Contaniner;
import com.appsoft.systerm.Response.ResponseEntity;
import com.appsoft.systerm.core.menu.meta.Meta;
import com.appsoft.systerm.core.menu.meta.MetaService;
import com.appsoft.systerm.redis.RedisService;

@RestController
public class MenuController {
	
	private final Logger log = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	private MenuService menuService;
	@Autowired
	private MetaService metaService;
	
	@Autowired
	private RedisService redis;
	

	@PostMapping("/saveMenu")
	public ResponseEntity saveMenu(@RequestParam Map<String, Object> params) {
		
		String userId = (String) params.get("userId");
		String menuInfoStr = (String) params.get("menuInfo");
		
		JSONObject menuInfo = JSON.parseObject(menuInfoStr);
		
		Router router = new Router();
		router.setName(menuInfo.getString("name"));
		router.setPath(menuInfo.getString("path"));
		router.setComponent(menuInfo.getString("component"));
		router.setParentId(menuInfo.getString("parentId"));
		router.setLevel(menuInfo.getIntValue("level"));
		router.setXh(menuInfo.getIntValue("xh"));
		Meta meta = new Meta();
		JSONObject metaObj = (JSONObject) menuInfo.get("meta");
		meta.setTitle(metaObj.getString("title"));
		meta.setIcon(metaObj.getString("icon"));
		meta.setNotCache(metaObj.getBoolean("notCache"));
		if(metaObj.containsKey("metaId")) {
			meta.setMetaId(metaObj.getString("metaId"));
		}
		Meta dbMeta = metaService.saveMeta(meta);
		router.setMetaId(dbMeta.getMetaId());
		
		if(menuInfo.containsKey("menuId")) {
			router.setMenuId(menuInfo.getString("menuId"));
		}
		
		Router dbRouter = menuService.saveMenu(router);
		ArrayList<String> accesses = new ArrayList<>();
		accesses.add(dbRouter.getMenuId());
		dbMeta.setAccess(accesses);
		metaService.saveMeta(dbMeta);
		
		ResponseEntity entity = new ResponseEntity();
		entity.setCode(Contaniner.CODE_200);
		entity.setMsg("保存成功");
		entity.setData(router);
		
		return entity;
		
	}
	
	@PostMapping("/getMenuList")
	public ResponseEntity getMenuList(@RequestParam Map<String, Object> params){
		int pageNum = Integer.parseInt((String) params.get("pageNum"));
		int perPage = Integer.parseInt((String) params.get("perPage"));
		List<Router> routers = new ArrayList<>();
		Page<Router> page = menuService.getMenuList(pageNum, perPage);
		List<Router> list = page.getContent();
		for (int i = 0; i < list.size(); i++) {
			Router router = list.get(i);
			Meta meta = metaService.getMetaById(router.getMetaId());
			router.setMeta(meta);
			routers.add(router);
		}

		ResponseEntity entity = new ResponseEntity();
		entity.setCode(Contaniner.CODE_200);
		entity.setData(routers);
		entity.setMsg("请求成功");
		entity.setTotal((int) page.getTotalElements());
		return entity;
	}
	
	@PostMapping("/queryParentMenus")
	public ResponseEntity getParentMenuList(@RequestParam int currentLevel){
		List<HashMap<String,String>> parentMenuList = menuService.getParentMenuList();
		ResponseEntity entity = new ResponseEntity();
		entity.setData(parentMenuList);
		entity.setCode(Contaniner.CODE_200);
		return entity;
	}
	
	
	@PostMapping("/removeMenuById")
	public ResponseEntity removeMenuById(@RequestParam String menuId) {
		boolean flag = menuService.removeMenuById(menuId);
		ResponseEntity entity = new ResponseEntity();
		entity.setCode(Contaniner.CODE_200);
		entity.setData(flag);
		entity.setMsg("删除成功");
		return entity;
	}
	
	@PostMapping("/removeSelection")
	public ResponseEntity removeSelections(@RequestParam Map<String, Object> params) {
		
		String object = (String) params.get("selections");
		JSONArray array = JSONArray.parseArray(object);
		for (int i = 0; i < array.size(); i++) {
			String menuId = (String) array.get(i);
			menuService.removeMenuById(menuId);
		}
		ResponseEntity entity = new ResponseEntity();
		entity.setCode(Contaniner.CODE_200);
		entity.setMsg("删除成功");
		return entity;
	}
	
	@PostMapping("/getMenu")
	public ArrayList<Router> getMenu(@RequestParam Map<String, Object> params) {
		String userId = (String) params.get("userId");
		
		System.out.println("params:"+userId);
		
		ArrayList<Router> retruenRouterList = new ArrayList<>();
		
		//主页
//		ArrayList<Router> homeMenu = menuService.getMenuByLevel(0);
		
		//一级菜单
		ArrayList<Router> firstMenus = menuService.getMenuByLevel(1);
		for (int i = 0; i < firstMenus.size(); i++) {
			Router firstMenu = firstMenus.get(i);
			String menuId = firstMenu.getMenuId();
			ArrayList<Router> secondMenus = menuService.getMenuByParentId(menuId);
			
			//二级菜单
			ArrayList<Router> secondList = new ArrayList<>();
			for (int j = 0; j < secondMenus.size(); j++) {
				Router secondMenu = secondMenus.get(j);
				String secondeMenuId = secondMenu.getMenuId();
				ArrayList<Router> threedMenus = menuService.getMenuByParentId(secondeMenuId);
				
				//三级菜单
				ArrayList<Router> threedList = new ArrayList<>();
				for (int k = 0; k < threedMenus.size(); k++) {
					Router threedMenu = threedMenus.get(k);
					threedList.add(threedMenu);
				}
				secondMenu.setChildren(threedList);
				secondList.add(secondMenu);
			}
			firstMenu.setChildren(secondList);
			retruenRouterList.add(firstMenu);
		}
		
		
		System.out.println("retruenRouterList:"+retruenRouterList);
		
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
		metaMain.setIcon("md-home");
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
		
		ArrayList<Router> routerMainList1 = new ArrayList<>();
		
		Router childMain11 = new Router();
		childMain11.setPath("/userInfo");
		childMain11.setName("userInfo");
		childMain11.setComponent("setings/user-info/user");
		Meta metaMain11 = new Meta();
		metaMain11.setTitle("用户信息");
		metaMain11.setIcon("md-funnel");
		metaMain11.setNotCache(false);
		ArrayList<String> listMain11 = new ArrayList<>();
		listMain11.add("70d848d2051e48e492954314bf769dcb");
		metaMain11.setAccess(listMain11);
		childMain11.setMeta(metaMain11);
		
		routerMainList1.add(childMain11);
		
		Router childMain1 = new Router();
		childMain1.setPath("menuInfo");
		childMain1.setName("menuInfo");
		childMain1.setComponent("setings/menu-info/menu");
		Meta metaMain1 = new Meta();
		metaMain1.setTitle("菜单管理");
		metaMain1.setIcon("md-funnel");
		ArrayList<String> listMain1 = new ArrayList<>();
		listMain1.add("4cbae71bb2a645969feee6d0298894ff");
		metaMain1.setAccess(listMain1);
		childMain1.setMeta(metaMain1);
		routerMainList1.add(childMain1);
		
		router1.setChildren(routerMainList1);
		
		routerList.add(router1);
		
		System.out.println("routerList:"+routerList.toString());
		
		return retruenRouterList;
	}
	
	
}
