package com.appsoft.systerm.user;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;


public interface UserMapper {
	
	@Select(value = { "select * from user" })
	public List<User> getUser();
	
	@Select(value = { "select * from user where id = #{id}" })
	public User getUserById(String id);
	
	
	
//	@SelectKey(keyProperty = "id", resultType = String.class, before = true, statement = "select replace(uuid(), '-', '') as id from dual")
	@Insert("insert into user (id,name,yhm,passWord,tel) values(#{id}, #{name}, #{yhm}, #{passWord},#{tel})")
	public int insertUser(User user);
	
}
