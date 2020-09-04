package com.welcomeHomeRealtyCaseStudy.entities;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

@Entity
public class UserLogin {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name = "tenantId")
	private Tenant tenant;
	
	@Basic
	@NotNull
	@Column(length=15, unique=true)
	private String userName;
	
	@Basic
	@NotNull
	@Column(length=15)
	private String password;
	
	@Basic
	@NotNull
	private int role;
	
	public UserLogin() {
	
	}

	//for testing
	public UserLogin(int userId, Tenant tenant, String userName, String password, int role) {
		this.userId = userId;
		this.tenant = tenant;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	
	
	public UserLogin(Tenant tenant, String userName, String password, int role) {
		this.tenant = tenant;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}



	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + role;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLogin other = (UserLogin) obj;
		if (role != other.role)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserLogin [userId=" + userId + ", tenant=" + tenant + ", userName=" + userName + ", password="
				+ password + ", Role=" + role + "]";
	}

	
	
}
