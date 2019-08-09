package com.appsoft.systerm.login;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.appsoft.systerm.user.User;


public interface LoginMapper {

	@Select(value = { "select * from user where yhm = #{yhm} and passWord = #{passWord}" })
	public User login(@Param("yhm") String yhm, @Param("passWord") String passWord);
	
}
