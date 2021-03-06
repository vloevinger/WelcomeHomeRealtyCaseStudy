package com.welcomeHomeRealtyCaseStudy.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import com.welcomeHomeRealtyCaseStudy.dao.ApartmentDAO;
import com.welcomeHomeRealtyCaseStudy.dao.BuildingDAO;
import com.welcomeHomeRealtyCaseStudy.dao.TenantDAO;
import com.welcomeHomeRealtyCaseStudy.dao.UserLoginDAO;
import com.welcomeHomeRealtyCaseStudy.entities.Apartment;
import com.welcomeHomeRealtyCaseStudy.entities.Building;
import com.welcomeHomeRealtyCaseStudy.entities.Invoice;
import com.welcomeHomeRealtyCaseStudy.entities.Tenant;
import com.welcomeHomeRealtyCaseStudy.entities.UserLogin;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class UserLoginDAOTest {
	private int paramId;
	private UserLogin userLogin;
	private static BuildingDAO buildingDao = new BuildingDAO();
	private static ApartmentDAO apartmentDao = new ApartmentDAO();
	private static TenantDAO tenantDao = new TenantDAO();
	private static UserLoginDAO userLoginDao = new UserLoginDAO();
	private static Building building1 = new Building(1,"Mansfield Park","454 W 22nd Street","New York","NY","10011",12,1000000,Date.valueOf("2015-01-02"));
	private static Building building2 = new Building (2,"Northanger Abbey","39 W 37th Street","New York","NY","10018",18,2000000,Date.valueOf("2010-01-01"));
	private static Building building3 = new Building(3,"Norland Park","222 E 93rd Street","New York","NY","10128",10,1000000,Date.valueOf("2011-09-05"));
	private static Building building4 = new Building(4,"Pemberly","45 W 139tbuildingh Street","New York","NY","10037",12,3000000,Date.valueOf("2012-06-04"));
	private static Building building5 = new Building(5,"Churchill","480 Saint Nicholas Avenue","New York","NY","10030",8,1500000,Date.valueOf("2015-07-02"));	
	private static Apartment apartment1 = new Apartment(1,building1,"1A",5,2,1.5,2500,true);
	private static Apartment apartment2 = new Apartment(2,building1,"1B",5,2,1.5,2500,true);
	private static Apartment apartment3 = new Apartment(3,building2,"1A",5,2,1.5,2500,true);
	private static Apartment apartment4 = new Apartment(4,building2,"1B",5,2,1.5,2500,true);
	private static Apartment apartment5 = new Apartment(5,building3,"1A",5,2,1.5,2500,true);
	private static Apartment apartment6 = new Apartment(6,building3,"1B",5,2,1.5,2500,true);
	private static Apartment apartment7 = new Apartment(7,building4,"1A",5,2,1.5,2500,true);
	private static Apartment apartment8 = new Apartment(8,building4,"1B",5,2,1.5,2500,true);
	private static Apartment apartment9 = new Apartment(9,building5,"1A",5,2,1.5,2500,true);
	private static Apartment apartment10 = new Apartment(10,building5,"1B",5,2,1.5,2500,true);
	private static Tenant tenant1 = new Tenant(1,apartment1,"Elinor","Dashwood","3238288840","e.dashwood@gmail.com",Date.valueOf("2020-01-01"),Date.valueOf("2020-12-31"));
	private static Tenant tenant2 = new Tenant(2,apartment2,"Colonel","Brandon","3238288841","c.Brandon@gmail.com",Date.valueOf("2020-01-02"),Date.valueOf("2020-12-31"));
	private static Tenant tenant3 = new Tenant(3,apartment3,"Edward","Ferars","3238288842","e.ferars@gmail.com",Date.valueOf("2020-01-03"),Date.valueOf("2020-12-31"));
	private static Tenant tenant4 = new Tenant(4,apartment4,"Eliza","Brandon","3238288843","e.brandon@gmail.com",Date.valueOf("2020-01-04"),Date.valueOf("2020-12-31"));
	private static Tenant tenant5 = new Tenant(5,apartment5,"Jane","Bennet","3238288844","j.bennet@gmail.com",Date.valueOf("2020-01-05"),Date.valueOf("2020-12-31"));
	private static Tenant tenant6 = new Tenant(6,apartment6,"Fitzwilliam","Darcy","3238288845","f.darcy@gmail.com",Date.valueOf("2020-01-06"),Date.valueOf("2020-12-31"));
	private static Tenant tenant7 = new Tenant(7,apartment7,"George","Wickham","3238288846","g.wickham@gmail.com",Date.valueOf("2020-01-07"),Date.valueOf("2020-12-31"));
	private static Tenant tenant8 = new Tenant(8,apartment8,"Fanny","Price","3238288847","f.price@gmail.com",Date.valueOf("2020-01-08"),Date.valueOf("2020-12-31"));
	private static Tenant tenant9 = new Tenant(9,apartment9,"Emma","Woodhouse","3238288848","e.woodhouse@gmail.com",Date.valueOf("2020-01-09"),Date.valueOf("2020-12-31"));
	private static Tenant tenant10 = new Tenant(10,apartment10,"Jane","Fairfax","3238288849","j.fairfax@gmail.com",Date.valueOf("2020-01-10"),Date.valueOf("2020-12-31"));
	
	
	public UserLoginDAOTest(int paramId, UserLogin userLogin) {
		this.paramId = paramId;
		this.userLogin = userLogin;
	}
	
	@Parameterized.Parameters
	public static Collection param() {
		UserLogin userLogin1 = new UserLogin(1,tenant1,"valerieL","password",1);
		UserLogin userLogin2 = new UserLogin(2,tenant2,"valerieL1","password",1);
		UserLogin userLogin3 = new UserLogin(3,tenant3,"valerieL2","password",1);
		UserLogin userLogin4 = new UserLogin(4,tenant4,"valerieL3","password",1);
		UserLogin userLogin5 = new UserLogin(5,tenant5,"valerieL4","password",1);
		UserLogin userLogin6 = new UserLogin(6,null,"adminacct","adminacct",2);
		
		return Arrays.asList(new Object[][] {
			{1,userLogin1},
			{2,userLogin2},
			{3,userLogin3},
			{4,userLogin4},
			{5,userLogin5},
			{6,userLogin6}
		});
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		buildingDao.addBuilding(building1);
		buildingDao.addBuilding(building2);
		buildingDao.addBuilding(building3);
		buildingDao.addBuilding(building4);
		buildingDao.addBuilding(building5);
		apartmentDao.addApartment(apartment1);
		apartmentDao.addApartment(apartment2);
		apartmentDao.addApartment(apartment3);
		apartmentDao.addApartment(apartment4);
		apartmentDao.addApartment(apartment5);
		apartmentDao.addApartment(apartment6);
		apartmentDao.addApartment(apartment7);
		apartmentDao.addApartment(apartment8);
		apartmentDao.addApartment(apartment9);
		apartmentDao.addApartment(apartment10);
		tenantDao.addTenant(tenant1);
		tenantDao.addTenant(tenant2);
		tenantDao.addTenant(tenant3);
		tenantDao.addTenant(tenant4);
		tenantDao.addTenant(tenant5);
		tenantDao.addTenant(tenant6);
		tenantDao.addTenant(tenant7);
		tenantDao.addTenant(tenant8);
		tenantDao.addTenant(tenant9);
		tenantDao.addTenant(tenant10);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tenantDao.deleteTenant(tenant1.getTenantId());
		tenantDao.deleteTenant(tenant2.getTenantId());
		tenantDao.deleteTenant(tenant3.getTenantId());
		tenantDao.deleteTenant(tenant4.getTenantId());
		tenantDao.deleteTenant(tenant5.getTenantId());
		tenantDao.deleteTenant(tenant6.getTenantId());
		tenantDao.deleteTenant(tenant7.getTenantId());
		tenantDao.deleteTenant(tenant8.getTenantId());
		tenantDao.deleteTenant(tenant9.getTenantId());
		tenantDao.deleteTenant(tenant10.getTenantId());
		apartmentDao.deleteApartment(apartment1.getApartmentId());
		apartmentDao.deleteApartment(apartment2.getApartmentId());
		apartmentDao.deleteApartment(apartment3.getApartmentId());
		apartmentDao.deleteApartment(apartment4.getApartmentId());
		apartmentDao.deleteApartment(apartment5.getApartmentId());
		apartmentDao.deleteApartment(apartment6.getApartmentId());
		apartmentDao.deleteApartment(apartment7.getApartmentId());
		apartmentDao.deleteApartment(apartment8.getApartmentId());
		apartmentDao.deleteApartment(apartment9.getApartmentId());
		apartmentDao.deleteApartment(apartment10.getApartmentId());
		buildingDao.deleteBuilding(building1.getBuildingId());
		buildingDao.deleteBuilding(building2.getBuildingId());
		buildingDao.deleteBuilding(building3.getBuildingId());
		buildingDao.deleteBuilding(building4.getBuildingId());
		buildingDao.deleteBuilding(building5.getBuildingId());
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCase1AddUserLogin() {
		//given
		int expected=1;
		//when
		int actual = userLoginDao.addUserLogin(userLogin);
		//then
		assertEquals(expected,actual);
	}

	@Test
	public void testCase6DeleteUserLogin() {
		//given
		UserLogin expectedUserLogin = userLogin;
		//when
		UserLogin actualUserLogin = userLoginDao.deleteUserLogin(userLogin.getUserId());
	
		//then
			assertEquals(expectedUserLogin, actualUserLogin);
	}

	@Test
	public void testCase5UpdateUserLogin() {
		//given
		 int expected = 1;
		//when

		 userLogin.setUserName("UserUpdate");
		 int actual = userLoginDao.updateUserLogin(userLogin.getUserId(), userLogin);
		//then
		assertEquals(expected,actual);
	}

	@Test
	public void testCase4GetUserLoginById() {
		//given
		UserLogin expectedUserLogin= userLogin;

		//when
		UserLogin actualUserLogin = userLoginDao.getUserLoginById(userLogin.getUserId());
		//then
		assertEquals(expectedUserLogin,actualUserLogin);
	}

	@Test
	public void testCase2ShowAllUserLogins() {
		//given
		List<UserLogin> expectedUserLogin = new ArrayList<>();
		expectedUserLogin.add(userLogin);
		//when
		List<UserLogin> actualUserLoginList = userLoginDao.showAllUserLogins();
		
		//then
		assertEquals(expectedUserLogin,actualUserLoginList);
	}

	@Test
	public void testCase3GetUserLoginByUsername() {
		//given
				UserLogin expectedUserLogin = userLogin;
				//when
				UserLogin actualUserLogin = userLoginDao.getUserLoginByUsername(userLogin.getUserName());
						
				//then
				assertEquals(expectedUserLogin,actualUserLogin);
	}



}
