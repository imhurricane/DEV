package com.appsoft.systerm.core.menu;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface MenuMapper {

	@Select(value = { "select * from router where level = #{level}" })
	public ArrayList<Router> getMenuByLevel(int level);
	
	@Select(value = { "select * from router where menuId = #{menuId}" })
	public ArrayList<Router> getMenuById(String menuId);
	
	
	
	@Insert(value= {"insert into loginUser (userid,age,sex,userLoginName,userNameCh,userPassword) "
			+ "values(#{userId},#{age},#{sex},#{loginName},#{userName},#{password})"})
	public int saveUser(@Param("userId") String userId,@Param("age")int age,@Param("sex")String sex,@Param("loginName")String loginName,@Param("userName")String userName,@Param("password")String password);

//	public Router saveMenu(@Param("") String );

	@Select(value = { "select * from router where level = #{level}" })
	public ArrayList<Router> getMenuList(int pageNum, int prePage);
	
	
}
