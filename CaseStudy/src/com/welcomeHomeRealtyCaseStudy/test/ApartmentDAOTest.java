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
import com.welcomeHomeRealtyCaseStudy.entities.Apartment;
import com.welcomeHomeRealtyCaseStudy.entities.Building;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)

public class ApartmentDAOTest {
	private int paramId;
	private Apartment apartment;
	private static BuildingDAO buildingDao = new BuildingDAO();
	private static ApartmentDAO apartmentDao = new ApartmentDAO();
	private static Building building1 = new Building(1,"Mansfield Park","454 W 22nd Street","New York","NY","10011",12,1000000,Date.valueOf("2015-01-02"));
	private static Building building2 = new Building (2,"Northanger Abbey","39 W 37th Street","New York","NY","10018",18,2000000,Date.valueOf("2010-01-01"));
	private static Building building3 = new Building(3,"Norland Park","222 E 93rd Street","New York","NY","10128",10,1000000,Date.valueOf("2011-09-05"));
	private static Building building4 = new Building(4,"Pemberly","45 W 139tbuildingh Street","New York","NY","10037",12,3000000,Date.valueOf("2012-06-04"));
	private static Building building5 = new Building(5,"Churchill","480 Saint Nicholas Avenue","New York","NY","10030",8,1500000,Date.valueOf("2015-07-02"));	
	
	
	public ApartmentDAOTest(int paramId, Apartment apartment) {
		this.paramId = paramId;
		this.apartment = apartment;
	}
	
	@Parameterized.Parameters
	public static Collection param() {
		
		Apartment apartment1 = new Apartment(1,building1,"1A",5,2,1.5,2500,true);
		Apartment apartment2 = new Apartment(2,building1,"1B",5,2,1.5,2500,true);
		Apartment apartment3 = new Apartment(3,building2,"1A",5,2,1.5,2500,true);
		Apartment apartment4 = new Apartment(4,building2,"1B",5,2,1.5,2500,true);
		Apartment apartment5 = new Apartment(5,building3,"1A",5,2,1.5,2500,true);
		Apartment apartment6 = new Apartment(6,building3,"1B",5,2,1.5,2500,true);
		Apartment apartment7 = new Apartment(7,building4,"1A",5,2,1.5,2500,true);
		Apartment apartment8 = new Apartment(8,building4,"1B",5,2,1.5,2500,true);
		Apartment apartment9 = new Apartment(9,building5,"1A",5,2,1.5,2500,true);
		Apartment apartment10 = new Apartment(10,building5,"1B",5,2,1.5,2500,true);
		
		
		
		return Arrays.asList(new Object[][] {
			{1,apartment1},
			{2,apartment2},
			{3,apartment3},
			{4,apartment4},
			{5,apartment5},
			{6,apartment6},
			{7,apartment7},
			{8,apartment8},
			{9,apartment9},
			{10,apartment10}
		});
	}
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		buildingDao.addBuilding(building1);
		buildingDao.addBuilding(building2);
		buildingDao.addBuilding(building3);
		buildingDao.addBuilding(building4);
		buildingDao.addBuilding(building5);
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
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
	public void testCase1AddApartment() {
		//given
		int expected=1;
		//when
		int actual = apartmentDao.addApartment(apartment);
		//then
		assertEquals(expected,actual);
	}

	@Test
	public void testCase5DeleteApartment() {
		//given
				Apartment expectedApartment = apartment;
				//when
				Apartment actualApartment = apartmentDao.deleteApartment(apartment.getApartmentId());
			
				//then
				assertEquals(expectedApartment, actualApartment);
	}

	@Test
	public void testCase4UpdateApartment() {
		//given
		 int expected = 1;
		//when

		 apartment.setApartmentName("1Z");
		 int actual = apartmentDao.updateApartment(apartment.getApartmentId(), apartment);
		//then
		assertEquals(expected,actual);
	}

	@Test
	public void testCase3GetApartmentById() {
		//given
		Apartment expectedApartment= apartment;

	//when
		Apartment actualApartment = apartmentDao.getApartmentById(apartment.getApartmentId());
	//then
		assertEquals(expectedApartment,actualApartment);
	}

	@Test
	public void testCase2ShowAllApartmentsByBuilding() {
		//given
		List<Apartment> expectedApartment = new ArrayList<>();
		expectedApartment.add(apartment);
		//when
		List<Apartment> actualApartmentList = apartmentDao.showAllApartmentsByBuilding(apartment.getBuilding());
		
		//then
		assertEquals(expectedApartment,actualApartmentList);
	}

}
