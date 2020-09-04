package com.welcomeHomeRealtyCaseStudy.services;

import java.util.List;

import com.welcomeHomeRealtyCaseStudy.dao.UserLoginDAO;
import com.welcomeHomeRealtyCaseStudy.entities.Tenant;
import com.welcomeHomeRealtyCaseStudy.entities.UserLogin;

public class UserLoginServices {
private UserLoginDAO userLoginDao = new UserLoginDAO();
	
	public int addUserLoginService(UserLogin userLogin) {
		int result = userLoginDao.addUserLogin(userLogin);
		return result;
	}
	
	public UserLogin deleteUserLoginService(int userLoginId) {
		UserLogin deletedUserLogin = userLoginDao.deleteUserLogin(userLoginId);
		return deletedUserLogin;
				
	}
	
	public List<UserLogin> showAllUserLoginsService() {
		List<UserLogin> userLoginList = userLoginDao.showAllUserLogins();
		return userLoginList;
	}
	
	public int updateUserLoginService(int userLoginId, UserLogin userLogin) {
		int result = userLoginDao.updateUserLogin(userLoginId, userLogin);
		return result;
	}
	
	public UserLogin getUserLoginByIdService(int userLoginId) {
		UserLogin userLogin = userLoginDao.getUserLoginById(userLoginId);
		return userLogin;
	}
	public UserLogin getUserLoginByUsernameService(String userName) {
		UserLogin userLogin = userLoginDao.getUserLoginByUsername(userName);
		return userLogin;
	}
	public int validateUserSignUpService(Tenant tenant, String userName, String password) {
		int result = userLoginDao.validateUserSignUp(tenant, userName, password);
		return result;
	}
	
	public boolean validateUserLoginService(String userName, String password) {
		boolean result = false;
		if(userLoginDao.validateUserLogin(userName, password)) {
			result=true;
		}
		return result;
	}
	
}
