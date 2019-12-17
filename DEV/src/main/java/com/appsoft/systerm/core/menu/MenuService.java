package com.appsoft.systerm.core.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.appsoft.systerm.core.menu.meta.Meta;
import com.appsoft.systerm.core.menu.meta.MetaRepository;
import com.appsoft.systerm.core.menu.meta.MetaService;


@Service
public class MenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	private RouterRepository routerRepository;
	
	@Autowired
	private MetaRepository metaRepository;
	
	@Autowired
	private MetaService metaService;
	
	public ArrayList<Router> getMenuByLevel(int level){
		
		ArrayList<Router> routers = routerRepository.getMenuByLevel(level);
		for (int i = 0; i < routers.size(); i++) {
			Optional<Meta> optional = metaRepository.findById(routers.get(i).getMetaId());
			routers.get(i).setMeta(optional.get());
		}
		return routers;
		
	};
	
	public ArrayList<Router> getMenuByParentId(String menuId){
		ArrayList<Router> routers = routerRepository.getMenuByParentId(menuId);
		for (int i = 0; i < routers.size(); i++) {
			Optional<Meta> optional = metaRepository.findById(routers.get(i).getMetaId());
			routers.get(i).setMeta(optional.get());
		}
		
		return routers;
	}
	
	public Router saveMenu(Router router) {
		Router dbRouter = routerRepository.save(router);
		
		return routerRepository.save(router);
		
	}
	
	public Page<Router> getMenuList(int pageNum,int prePage){
		PageRequest pageable = PageRequest.of(pageNum-1, 10,Sort.Direction.ASC,("xh"));
		Page<Router> page = routerRepository.findAll(pageable);
		return page;
	}

	public List<HashMap<String,String>> getParentMenuList() {
		
		List<HashMap<String,String>> parentMenus = new ArrayList<>();
		List<Router> list = routerRepository.findAll();
		for (int i = 0; i < list.size(); i++) {
			HashMap<String,String> map = new HashMap<>();
			map.put("value", list.get(i).getMenuId());
			map.put("label", list.get(i).getName());
			parentMenus.add(map);
		}
		return parentMenus;
	}

	public boolean removeMenuById(String menuId) {
		try{
			boolean existsById = routerRepository.existsById(menuId);
			if (existsById) {
				Optional<Router> optional = routerRepository.findById(menuId);
				if(metaRepository.existsById(optional.get().getMetaId())) {
					metaRepository.deleteById(optional.get().getMetaId());
				}
				routerRepository.deleteById(menuId);
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
}
