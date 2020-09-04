package com.welcomeHomeRealtyCaseStudy.services;

import java.util.List;

import com.welcomeHomeRealtyCaseStudy.dao.UserLoginDAO;
import com.welcomeHomeRealtyCaseStudy.entities.Tenant;
import com.welcomeHomeRealtyCaseStudy.entities.UserLogin;

public class UserLoginServices {
private UserLoginDAO userLoginDao = new UserLoginDAO();
	
	public void addUserLoginService(UserLogin userLogin) {
		if(userLoginDao.addUserLogin(userLogin)==1 ) {
			System.out.println("UserLogin added");
		}
		else {
			System.out.println("Error: UserLogin not added");
		}
	}
	
	public void deleteUserLoginService(int userLoginId) {
		if(userLoginDao.deleteUserLogin(userLoginId) != null) {
			System.out.println("UserLogin deleted");
		}
		else {
			System.out.println("Error: UserLogin not deleted");
		}
	}
	
	public void showAllUserLoginsService() {
		List<UserLogin> userLoginList = userLoginDao.showAllUserLogins();
		if(userLoginList!= null) {
			if(userLoginList.size()>0) {
				for(UserLogin i: userLoginList) {
					System.out.println(i);
				}
			}
			else {
				System.out.println("No UserLogins to list");
			}
		}
		else {
			System.out.println("Error: could not print userLogins");
		}
	}
	
	public void updateUserLoginService(int userLoginId, UserLogin userLogin) {
		if(userLoginDao.updateUserLogin(userLoginId, userLogin) == 1) {
			System.out.println("UserLogin updated");
		}
		else {
			System.out.println("Error: userLogin not updated");
		}
	}
	
	public void getUserLoginByIdService(int userLoginId) {
		UserLogin userLogin = userLoginDao.getUserLoginById(userLoginId);
		if(userLogin != null) {
			System.out.println("UserLogin found");
			System.out.println(userLogin);
		}
		else {
			System.out.println("Error: UserLogin does not exist");
		}
	}
	public UserLogin getUserLoginByUsernameService(String userName) {
		UserLogin userLogin = userLoginDao.getUserLoginByUsername(userName);
		if(userLogin != null) {
			System.out.println("UserLogin found");
			System.out.println(userLogin);
		}
		else {
			System.out.println("Error: UserLogin does not exist");
		}
		return userLogin;
	}
	public int validateUserSignUpService(Tenant tenant, String userName, String password) {
		int result = userLoginDao.validateUserSignUp(tenant, userName, password);
		if(result==1) {
			System.out.println("User account created");
		}
		else if(result==2) {
			System.out.println("Error: That username is taken. Please pick another.");
		}
		else if(result==3) {
			System.out.println("Error: You already have an account. Call the office for help");
		}
		else {
			System.out.println("Error: Tenant account not found. Call Office for help.");
		}
		return result;
	}
	
	public boolean validateUserLoginService(String userName, String password) {
		boolean result = false;
		if(userLoginDao.validateUserLogin(userName, password)) {
			System.out.println("Login Successful");
			result=true;
		}
		else {
			System.out.println("Invalid login credentials");
		}
		return result;
	}
	
}
