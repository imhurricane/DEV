package com.appsoft.systerm.core.yh;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface LoginMapper {

	@Select(value = { "select * from user where yhm = #{yhm} and passWord = #{passWord}" })
	public LoginUser login(@Param("yhm") String yhm, @Param("passWord") String passWord);
	
	
	public LoginUser getUserById(@Param("yhm") String yhm, @Param("passWord") String passWord);
	
	public LoginUser getUserById(@Param("yhm") String yhm);
}
