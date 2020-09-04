package com.welcomeHomeRealtyCaseStudy.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.welcomeHomeRealty.dbConnection.DBConnection;
import com.welcomeHomeRealtyCaseStudy.entities.Tenant;
import com.welcomeHomeRealtyCaseStudy.entities.UserLogin;


public class UserLoginDAO extends DBConnection implements UserLoginDAOI {

	@Override
	public int addUserLogin(UserLogin userLogin) {
		int result = 0;
		try {
			this.connect();
			em.getTransaction().begin();
			em.persist(userLogin);
			em.getTransaction().commit();
			result =1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		
		return result;
	}

	@Override
	public UserLogin deleteUserLogin(int userLoginId) {
		UserLogin deletedUserLogin=null;
		try {
			this.connect();
			deletedUserLogin = em.find(UserLogin.class,userLoginId);
			if(deletedUserLogin !=null) {
				em.getTransaction().begin();
				em.remove(deletedUserLogin);
				em.getTransaction().commit();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		return deletedUserLogin;
	}

	@Override
	public int updateUserLogin(int userLoginId, UserLogin userLogin) {
		int result = 0;
		
		try {
			this.connect();
			UserLogin updatedUserLogin = em.find(UserLogin.class, userLoginId);
			if(updatedUserLogin!=null) {
				em.getTransaction().begin();
				updatedUserLogin.setTenant(userLogin.getTenant());
				updatedUserLogin.setUserName(userLogin.getUserName());
				updatedUserLogin.setPassword(userLogin.getPassword());
				updatedUserLogin.setRole(userLogin.getRole());
				em.getTransaction().commit();
				result = 1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		
		return result;
		
	}

	@Override
	public UserLogin getUserLoginById(int userLoginId) {
		UserLogin userLogin = null;
		try {
			this.connect();
			userLogin = em.find(UserLogin.class, userLoginId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		return userLogin;
	}
	
	

	@Override
	public List<UserLogin> showAllUserLogins() {
		List<UserLogin> userLoginList = new ArrayList<UserLogin>();
		try {
			this.connect();
			Query query = em.createQuery("Select i from UserLogin i");
			userLoginList = query.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		
		return userLoginList;
	}
	
	@Override
	public UserLogin getUserLoginByUsername(String userName) {
		UserLogin userLogin = null;
		try {
			this.connect();
			Query query = em.createQuery("select u from UserLogin u where u.userName = :givenUsername");
			query.setParameter("givenUsername", userName);
			userLogin = (UserLogin)query.getSingleResult();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		return userLogin;
	}
	
	public int validateUserSignUp(Tenant tenant, String userName, String password) {
		int result = 0;
		Tenant validTenant = null;
		List<UserLogin> userLoginList = new ArrayList<>();
		try {
			this.connect();
			Query query = em.createQuery("Select t from Tenant t where t.apartment = :givenApartment AND t.firstName = :givenFName AND"
					+ " t.lastName = :givenLName AND t.phoneNumber = :givenPhone AND t.email = :givenEmail");
			query.setParameter("givenApartment", tenant.getApartment());
			query.setParameter("givenFName", tenant.getFirstName());
			query.setParameter("givenLName",tenant.getLastName());
			query.setParameter("givenPhone",tenant.getPhoneNumber());
			query.setParameter("givenEmail", tenant.getEmail());
			validTenant = (Tenant)query.getSingleResult();
			if(validTenant!=null) {
				//check if user already signed up.
				Query userExists = em.createQuery("Select u from UserLogin u where u.tenant = :givenTenant");
				userExists.setParameter("givenTenant", validTenant);
				userLoginList = userExists.getResultList();
				//if user didn't sign up then check if username is taken already
				if(userLoginList.size()==0) {
					//check that username is not taken already
					List<String> usernames = new ArrayList<>();
					Query getAllUsernames = em.createQuery("Select u.userName from UserLogin u");
					usernames=getAllUsernames.getResultList();
					if(usernames.indexOf(userName) == -1) {
						//Sign up user
						UserLogin newUserLogin = new UserLogin(validTenant,userName,password,1);
						em.getTransaction().begin();
						em.persist(newUserLogin);
						em.getTransaction().commit();
						result=1;
					}
					else {
						//username taken 
						result =2;
					}
				}
				else {
					//user already has account
					result=3;
				}
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		
		return result;
	}
	
	public boolean validateUserLogin(String userName, String password) {
		boolean result = false;
		try {
			this.connect();
			Query query = em.createQuery("Select u from UserLogin u where u.userName = :givenUserName and u.password = :givenPassword");
			query.setParameter("givenUserName", userName);
			query.setParameter("givenPassword", password);
			try {
				UserLogin validUserLogin = (UserLogin)query.getSingleResult();
				if(validUserLogin != null) {
					result = true;
				}
			}
			catch(Exception e) {
				//no results in query
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		
		return result;
	}

}
