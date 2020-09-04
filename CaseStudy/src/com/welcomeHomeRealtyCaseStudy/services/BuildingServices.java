package com.welcomeHomeRealtyCaseStudy.services;

import java.util.List;

import com.welcomeHomeRealtyCaseStudy.dao.BuildingDAO;
import com.welcomeHomeRealtyCaseStudy.entities.Building;



public class BuildingServices {
	private BuildingDAO buildingDao = new BuildingDAO();
	
	public boolean addBuildingService(Building newBuilding) {
		boolean result = false;
		if(buildingDao.addBuilding(newBuilding) == 1) {
			result = true;
		}
		
		return result;
	}
	
	public boolean deleteBuildingService(int buildingId) {
		boolean result = false;
		Building deletedBuilding =buildingDao.deleteBuilding(buildingId);
		if(deletedBuilding != null) {
			result = true;
		}
		
		return result;
	}
	
	public List<Building> showAllBuildingsService() {
		List<Building> buildingList =buildingDao.showAllBuildings();
		return buildingList;
	}
	
	public boolean updateBuildingService(int buildingId, Building newBuilding) {
		boolean result = false;
		if(buildingDao.updateBuilding(buildingId, newBuilding) == 1) {
			result = true;
		}
		return result;
	}
	
	public Building getBuildingByIdService(int buildingId) {
		Building foundBuilding = buildingDao.getBuildingById(buildingId);
		return foundBuilding;
	}
	
}
