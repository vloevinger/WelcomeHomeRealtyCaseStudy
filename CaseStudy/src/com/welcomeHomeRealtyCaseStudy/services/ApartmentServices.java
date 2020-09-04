package com.welcomeHomeRealtyCaseStudy.services;

import java.util.List;

import com.welcomeHomeRealtyCaseStudy.dao.ApartmentDAO;
import com.welcomeHomeRealtyCaseStudy.entities.Apartment;
import com.welcomeHomeRealtyCaseStudy.entities.Building;

public class ApartmentServices {

	private ApartmentDAO apartmentDao = new ApartmentDAO();
	
	public boolean addApartmentService(Apartment newApartment) {
		boolean result = false;
		if(apartmentDao.addApartment(newApartment) == 1) {
			System.out.println("Apartment named " + newApartment.getApartmentName() + " added succesfully");
			result = true;
		}
		else {
			System.out.println("Error: Apartment not added");
		}
		return result;
	}
	
	public boolean deleteApartmentService(int apartmentId) {
		boolean result = false;
		if(apartmentDao.deleteApartment(apartmentId) != null) {
			System.out.println("Apartment deleted succesfully");
			result = true;
		}
		else {
			System.out.println("Error: Apartment not deleted");
		}
		return result;
	}
	
	public List<Apartment> showAllApartmentsByBuildingService(Building building) {
		List<Apartment> apartmentList = apartmentDao.showAllApartmentsByBuilding(building);
		if(apartmentList != null) {
			if(apartmentList.size()>0) {
				for(Apartment a: apartmentList) {
					System.out.println(a);
				}
			}
			else {
				System.out.println("There are no apartments in this building");
			}
			
		}
		else {
			System.out.println("Error: Could not print out apartment list.");
		}
		
		return apartmentList;
	}
	
	public boolean updateApartmentService(int apartmentId, Apartment apartment) {
		boolean result = false;
		if(apartmentDao.updateApartment(apartmentId, apartment) == 1) {
			System.out.println("Apartment updated succesfully");
			result = true;
		}
		else {
			System.out.println("Error: apartment not  updated");
		}
		return result;
	}
	
	
	public Apartment getApartmentByIdService(int apartmentId) {
		Apartment foundApartment = apartmentDao.getApartmentById(apartmentId);
		if(foundApartment != null) {
			System.out.println("Apartment found");
			System.out.println(foundApartment);
		}
		else {
			System.out.println("Error: Apartment does not exist");
		}
		return foundApartment;
	}
	

}
