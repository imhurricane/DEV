package com.appsoft.systerm.core.menu;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RouterRepository extends JpaRepository<Router,String>{
	
	@Query(value="select a from Router a where a.level = ?1 order by xh asc")
	ArrayList<Router> getMenuByLevel(int level);
	
	@Query(value="select a from Router a where a.parentId = ?1 order by xh asc")
	ArrayList<Router> getMenuByParentId(String menuId);
	
	
	
	
}
