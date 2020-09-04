package com.welcomeHomeRealtyCaseStudy.dao;

import java.util.List;

import com.welcomeHomeRealtyCaseStudy.entities.Building;



public interface BuildingDAOI {

	public int addBuilding(Building building);
	public Building deleteBuilding(int buildingId);
	public int updateBuilding(int buildingId, Building newBuilding);
	public Building getBuildingById(int buildingId);
	public List<Building> showAllBuildings();
	
}
