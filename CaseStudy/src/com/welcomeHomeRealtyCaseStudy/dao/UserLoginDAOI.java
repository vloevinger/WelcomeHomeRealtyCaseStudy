package com.welcomeHomeRealtyCaseStudy.dao;

import java.util.List;

import com.welcomeHomeRealtyCaseStudy.entities.Tenant;
import com.welcomeHomeRealtyCaseStudy.entities.UserLogin;

public interface UserLoginDAOI {
	public int addUserLogin(UserLogin userLogin);
	public UserLogin deleteUserLogin(int userLoginId);
	public int updateUserLogin(int userLoginId, UserLogin newUserLogin);
	public UserLogin getUserLoginById(int userLoginId);
	public List<UserLogin> showAllUserLogins();
	public UserLogin getUserLoginByUsername(String userName);
	public int validateUserSignUp(Tenant tenant, String userName, String password);
	public boolean validateUserLogin(String userName, String password);
}
