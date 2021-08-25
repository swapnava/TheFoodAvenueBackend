package com.codeWizard.tfa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a entity class for Login default constructor, parameterized
 *                           constructor along with getters and setters.
 *         Version             1.0
 *         Created Date    27-July-2021
 ************************************************************************************/


@Entity
public class Login {
	@Id
	@Column(name="userId", nullable=false)
	private int userid;
	@Column(name="Username", nullable=false)
	private String userName;
	@Column(name="Password", nullable=false)
	private String password;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Login() {
		super();
	}
	public Login(int userid, String userName, String password) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [userid=" + userid + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
