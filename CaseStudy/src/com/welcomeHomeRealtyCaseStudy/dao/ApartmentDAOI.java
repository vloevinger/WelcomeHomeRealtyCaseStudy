package com.welcomeHomeRealtyCaseStudy.dao;

import java.util.List;

import com.welcomeHomeRealtyCaseStudy.entities.Apartment;
import com.welcomeHomeRealtyCaseStudy.entities.Building;


public interface ApartmentDAOI {

	public int addApartment(Apartment apartment);
	public Apartment deleteApartment(int apartmentId);
	public int updateApartment(int apartmentId, Apartment apartment);
	public Apartment getApartmentById(int apartmentId);
	public List<Apartment> showAllApartmentsByBuilding(Building building);
}
