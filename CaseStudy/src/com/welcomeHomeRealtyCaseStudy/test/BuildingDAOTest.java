package com.welcomeHomeRealtyCaseStudy.test;



import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import com.welcomeHomeRealtyCaseStudy.dao.BuildingDAO;
import com.welcomeHomeRealtyCaseStudy.entities.Building;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)

public class BuildingDAOTest{
	private int paramId;
	private Building building;
	private static BuildingDAO buildingDao = new BuildingDAO();

	public BuildingDAOTest(int paramId, Building building) {
		this.paramId = paramId;
		this.building = building;
	}
	
	@Parameterized.Parameters
	public static Collection param() {
		Building building1 = new Building(1,"Mansfield Park","454 W 22nd Street","New York","NY","10011",12,1000000,Date.valueOf("2015-01-02"));
		Building building2 = new Building (2,"Northanger Abbey","39 W 37th Street","New York","NY","10018",18,2000000,Date.valueOf("2010-01-01"));
		Building building3 = new Building(3,"Norland Park","222 E 93rd Street","New York","NY","10128",10,1000000,Date.valueOf("2011-09-05"));
		Building building4 = new Building(4,"Pemberly","45 W 139tbuildingh Street","New York","NY","10037",12,3000000,Date.valueOf("2012-06-04"));
		Building building5 = new Building(5,"Churchill","480 Saint Nicholas Avenue","New York","NY","10030",8,1500000,Date.valueOf("2015-07-02"));	
		Building building6 = new Building(6,"Dashwood","500 E Houston Street","New York","NY","10002",6,7000000,Date.valueOf("2020-05-16"));
		Building building7 = new Building (7,"Barton","9 Saint James Place","Newark","NJ","07112",10,700000,Date.valueOf("2018-10-15"));	
		Building building8 = new Building(8,"Willoughby","206 Seymour Avenue","Newark","NJ","07108",10,500000,Date.valueOf("2010-11-11"));	
		Building building9 = new Building(9,"Wentworth","910 King Russ Road","Harrisburg","PA","17109",10,200000,Date.valueOf("2010-12-07"));	
		Building building10 = new Building(10,"Kellynch Hall","6985 New Oxford Rd","Harrisburg","PA","17112",2,150000,Date.valueOf("2019-3-05"));	

		
		
		
		return Arrays.asList(new Object[][] {
			{1,building1},
			{2,building2},
			{3,building3},
			{4,building4},
			{5,building5},
			{6,building6},
			{7,building7},
			{8,building8},
			{9,building9},
			{10,building10}
		});
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	 
	}

	@Test
	public void testCase1AddBuilding() {
		//given
		int expected = 1;
		//when
		int actual = buildingDao.addBuilding(building);
		//then
		assertEquals(expected,actual);
		
		
	}

	@Test
	public void testCase5DeleteBuilding() {
		//given
		Building expectedBuilding = building;
		//when
		Building actualBuilding = buildingDao.deleteBuilding(building.getBuildingId());
		//then
		assertEquals(expectedBuilding, actualBuilding);
	}

	@Test
	public void testCase2ShowAllBuildings() {
		
		//given
		List<Building> expectedBuilding = new ArrayList<>();
		expectedBuilding.add(building);
		//when
		List<Building> actualBuildingList = buildingDao.showAllBuildings();
		
		//then
		assertEquals(expectedBuilding,actualBuildingList);
	}

	@Test
	public void testCase4UpdateBuilding() {
		//given
		 int expected = 1;
		//when

		 building.setCity("Los Angeles");
		 int actual = buildingDao.updateBuilding(building.getBuildingId(), building);
		//then
		assertEquals(expected,actual);
	}

	@Test
	public void testCase3GetBuildingById() {
		//given
			Building expectedBuilding= building;

		//when
			Building actualBuilding = buildingDao.getBuildingById(building.getBuildingId());
		//then
			assertEquals(expectedBuilding,actualBuilding);
	}

}
