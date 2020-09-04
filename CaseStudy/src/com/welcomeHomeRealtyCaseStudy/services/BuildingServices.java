package com.welcomeHomeRealtyCaseStudy.services;

import java.util.List;

import com.welcomeHomeRealtyCaseStudy.dao.BuildingDAO;
import com.welcomeHomeRealtyCaseStudy.entities.Building;



public class BuildingServices {
	private BuildingDAO buildingDao = new BuildingDAO();
	
	public boolean addBuildingService(Building newBuilding) {
		boolean result = false;
		if(buildingDao.addBuilding(newBuilding) == 1) {
			System.out.println("Building named "+ newBuilding.getBuildingName()+ " added successfully.");
			result = true;
		}
		else {
			System.out.println("Error: Building not added.");
		}
		return result;
	}
	
	public boolean deleteBuildingService(int buildingId) {
		boolean result = false;
		Building deletedBuilding =buildingDao.deleteBuilding(buildingId);
		if(deletedBuilding != null) {
				System.out.println("Building deleted succesfuly");
				result = true;
		}
		else
		{
			System.out.println("Error: Building not deleted");
		}
		return result;
	}
	
	public List<Building> showAllBuildingsService() {
		List<Building> buildingList =buildingDao.showAllBuildings();
		
		if(buildingList != null) {
			if(buildingList.size()>0) {
				for(Building b:buildingList) {
					System.out.println(b);
				}
			}
			else {
				System.out.println("No buildings to print out.");
			}
		
		}
		else {
			System.out.println("Error: Could not print out buildings");
		}
		return buildingList;
	}
	
	public boolean updateBuildingService(int buildingId, Building newBuilding) {
		boolean result = false;
		if(buildingDao.updateBuilding(buildingId, newBuilding) == 1) {
			System.out.println("Building updated successfuly");
			result = true;
		}
		else {
			System.out.println("Error: building not updated");
		}
		return result;
	}
	
	public Building getBuildingByIdService(int buildingId) {
		Building foundBuilding = buildingDao.getBuildingById(buildingId);
		if(foundBuilding != null) {
			System.out.println("Building found");
		}
		else {
			System.out.println("Error: Building does not exist");
		}
		return foundBuilding;
	}
	
}
