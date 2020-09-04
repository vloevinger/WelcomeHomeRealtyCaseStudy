package com.welcomeHomeRealtyCaseStudy.dao;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.welcomeHomeRealty.dbConnection.DBConnection;
import com.welcomeHomeRealtyCaseStudy.entities.Apartment;
import com.welcomeHomeRealtyCaseStudy.entities.Building;
import com.welcomeHomeRealtyCaseStudy.services.ApartmentServices;


public class BuildingDAO extends DBConnection implements BuildingDAOI {
	
	@Override
	public int addBuilding(Building newBuilding) {
		int result = 0;
		 
		
		try {
			
			this.connect();
			em.getTransaction().begin();
			em.persist(newBuilding);
			em.getTransaction().commit();
			result =1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			this.disconnect();
		}
		
		return result;
	}

	@Override
	public Building deleteBuilding(int buildingId) {
		Building deleteBuilding = null;
		try {
			this.connect();
			deleteBuilding = em.find(Building.class, buildingId);
			if(deleteBuilding!=null) {
				//if Building has apartments, cannot delete building;
				ApartmentServices apartmentService = new ApartmentServices();
				List<Apartment> apartmentList =apartmentService.showAllApartmentsByBuildingService(deleteBuilding);
				if(apartmentList.size()>0) {
					deleteBuilding = null;
				}
				else {
					em.getTransaction().begin();
					em.remove(deleteBuilding);
					em.getTransaction().commit();
				}
			}
			
		}catch(Exception e) {
			e.getMessage();
		}
		
		finally {
			this.disconnect();
		}
		return deleteBuilding;
	}


	@Override
	public List<Building> showAllBuildings() {
		List<Building> buildingList = new ArrayList<>();
		try {
			connect();
			Query query = em.createQuery("Select b from Building b order by b.buildingName");
			buildingList = query.getResultList();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
			
		}
		
		return buildingList;
	}

	@Override
	public int updateBuilding(int buildingId, Building newBuilding) {
		int result = 0;
		try {
			connect();
			Building updateBuilding = em.find(Building.class, buildingId);
			if(updateBuilding!= null) {
				em.getTransaction().begin();
				
				updateBuilding.setBuildingName(newBuilding.getBuildingName());
				updateBuilding.setAddress(newBuilding.getAddress());
				updateBuilding.setCity(newBuilding.getCity());
				updateBuilding.setState(newBuilding.getState());
				updateBuilding.setZip(newBuilding.getZip());
				updateBuilding.setUnits(newBuilding.getUnits());
				updateBuilding.setCost(newBuilding.getCost());
				updateBuilding.setDatePurchased(newBuilding.getDatePurchased());
				if(newBuilding.getDateSold()!= null && !newBuilding.getDateSold().toString().equals("0001-01-01")) {
					updateBuilding.setDateSold(newBuilding.getDateSold());
				}
				
			    updateBuilding.setSalePrice(newBuilding.getSalePrice());
				
				em.getTransaction().commit();
				result = 1;
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		return result;
	}

	@Override
	public Building getBuildingById(int buildingId) {
		Building foundBuilding = null;
		try {
			connect();
			foundBuilding = em.find(Building.class, buildingId);
			}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		return foundBuilding;
	}

}
