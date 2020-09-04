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
			result = true;
		}
		return result;
	}
	
	public boolean deleteApartmentService(int apartmentId) {
		boolean result = false;
		if(apartmentDao.deleteApartment(apartmentId) != null) {
			result = true;
		}
		return result;
	}
	
	public List<Apartment> showAllApartmentsByBuildingService(Building building) {
		List<Apartment> apartmentList = apartmentDao.showAllApartmentsByBuilding(building);
		return apartmentList;
	}
	
	public boolean updateApartmentService(int apartmentId, Apartment apartment) {
		boolean result = false;
		if(apartmentDao.updateApartment(apartmentId, apartment) == 1) {
			result = true;
		}
		return result;
	}
	
	
	public Apartment getApartmentByIdService(int apartmentId) {
		Apartment foundApartment = apartmentDao.getApartmentById(apartmentId);
		return foundApartment;
	}
	

}
