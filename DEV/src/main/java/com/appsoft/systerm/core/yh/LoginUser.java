package com.appsoft.systerm.core.yh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginUser implements Serializable{

	private static final long serialVersionUID = -2113201070938218262L;
	@Id
	@Column(length = 32)
	private String userId; 
	private String userLoginName;
	private String userPassword;
	private String userNameCh;
	private String userEmail;
	private String userPhonenum;
	private String lastLoginTime = "";//最后登录时间
	private String lastOperateTime = "";// 最后操作的时间
	private String lastLogoutTime;
	private String userOrgId;// orgid
	private String userSiteId;// sitextm
	private String xtID;
	private String sex;
	private int age;
	private String deptName;
	public final String getUserId() {
		return userId;
	}
	public final void setUserId(String userId) {
		this.userId = userId;
	}
	public final String getUserLoginName() {
		return userLoginName;
	}
	public final void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}
	public final String getUserPassword() {
		return userPassword;
	}
	public final void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public final String getUserNameCh() {
		return userNameCh;
	}
	public final void setUserNameCh(String userNameCh) {
		this.userNameCh = userNameCh;
	}
	public final String getUserEmail() {
		return userEmail;
	}
	public final void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public final String getUserPhonenum() {
		return userPhonenum;
	}
	public final void setUserPhonenum(String userPhonenum) {
		this.userPhonenum = userPhonenum;
	}
	public final String getLastLoginTime() {
		return lastLoginTime;
	}
	public final void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public final String getLastOperateTime() {
		return lastOperateTime;
	}
	public final void setLastOperateTime(String lastOperateTime) {
		this.lastOperateTime = lastOperateTime;
	}
	public final String getLastLogoutTime() {
		return lastLogoutTime;
	}
	public final void setLastLogoutTime(String lastLogoutTime) {
		this.lastLogoutTime = lastLogoutTime;
	}
	public final String getUserOrgId() {
		return userOrgId;
	}
	public final void setUserOrgId(String userOrgId) {
		this.userOrgId = userOrgId;
	}
	public final String getUserSiteId() {
		return userSiteId;
	}
	public final void setUserSiteId(String userSiteId) {
		this.userSiteId = userSiteId;
	}
	public final String getXtID() {
		return xtID;
	}
	public final void setXtID(String xtID) {
		this.xtID = xtID;
	}
	public final String getSex() {
		return sex;
	}
	public final void setSex(String sex) {
		this.sex = sex;
	}
	public final int getAge() {
		return age;
	}
	public final void setAge(int age) {
		this.age = age;
	}
	public final String getDeptName() {
		return deptName;
	}
	public final void setDeptName(String deptName) {
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
