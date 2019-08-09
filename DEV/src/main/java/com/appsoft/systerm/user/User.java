package com.appsoft.systerm.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User {
	
	@Id
	@GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
	private String id;
	private String name;
//	private int sex;

	private String yhm;
	private String tel;
	
//	public final int getSex() {
//		return sex;
//	}
//	public final void setSex(int sex) {
//		this.sex = sex;
//	}
	public final String getTel() {
		return tel;
	}
	public final void setTel(String tel) {
		this.tel = tel;
	}
	private String passWord;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYhm() {
		return yhm;
	}
	public void setYhm(String yhm) {
		this.yhm = yhm;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", yhm=" + yhm + ", tel=" + tel + ", passWord=" + passWord + "]";
	}


	

}
