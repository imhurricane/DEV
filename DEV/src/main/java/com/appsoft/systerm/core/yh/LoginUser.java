package com.appsoft.systerm.core.yh;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class LoginUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "faceset_generator")
	@GenericGenerator(name = "faceset_generator", strategy = "uuid")
	private String userId;
	private String userLoginName;
	private String userPassword;
	private String userNameCh;
	private String userEmail;
	private String userPhonenum;
	private String lastLoginTime = "";// 最后登录时间
	private String lastOperateTime = "";// 最后操作的时间
	private String lastLogoutTime;
	private String userOrgId;// orgid
	private String userSiteId;// sitextm
	private String xtID;
	private boolean sex;
	private int age;
	private String deptName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserNameCh() {
		return userNameCh;
	}

	public void setUserNameCh(String userNameCh) {
		this.userNameCh = userNameCh;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhonenum() {
		return userPhonenum;
	}

	public void setUserPhonenum(String userPhonenum) {
		this.userPhonenum = userPhonenum;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastOperateTime() {
		return lastOperateTime;
	}

	public void setLastOperateTime(String lastOperateTime) {
		this.lastOperateTime = lastOperateTime;
	}

	public String getLastLogoutTime() {
		return lastLogoutTime;
	}

	public void setLastLogoutTime(String lastLogoutTime) {
		this.lastLogoutTime = lastLogoutTime;
	}

	public String getUserOrgId() {
		return userOrgId;
	}

	public void setUserOrgId(String userOrgId) {
		this.userOrgId = userOrgId;
	}

	public String getUserSiteId() {
		return userSiteId;
	}

	public void setUserSiteId(String userSiteId) {
		this.userSiteId = userSiteId;
	}

	public String getXtID() {
		return xtID;
	}

	public void setXtID(String xtID) {
		this.xtID = xtID;
	}

	public boolean getSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "LoginUser [userId=" + userId + ", userLoginName=" + userLoginName + ", userPassword=" + userPassword
				+ ", userNameCh=" + userNameCh + ", userEmail=" + userEmail + ", userPhonenum=" + userPhonenum
				+ ", lastLoginTime=" + lastLoginTime + ", lastOperateTime=" + lastOperateTime + ", lastLogoutTime="
				+ lastLogoutTime + ", userOrgId=" + userOrgId + ", userSiteId=" + userSiteId + ", xtID=" + xtID
				+ ", sex=" + sex + ", age=" + age + ", deptName=" + deptName + "]";
	}

}
