package com.appsoft.systerm.core.yh;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface LoginMapper {

	@Select(value = { "select * from loginuser where userLoginName = #{loginName} and userPassword = #{password}" })
	public LoginUser login(@Param("loginName") String loginName, @Param("password") String password);
	
	
	public LoginUser getUserById(@Param("yhm") String yhm, @Param("passWord") String passWord);
	
	public LoginUser getUserById(@Param("yhm") String yhm);

	@Select(value = {"select * from loginuser"})
	public ArrayList<LoginUser> getUser();
	
	@Insert(value= {"insert into loginUser (userid,age,sex,userLoginName,userNameCh,userPassword) "
			+ "values(#{userId},#{age},#{sex},#{loginName},#{userName},#{password})"})
	public int saveUser(@Param("userId") String userId,@Param("age")int age,@Param("sex")String sex,@Param("loginName")String loginName,@Param("userName")String userName,@Param("password")String password);
}
