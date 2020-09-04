package com.welcomeHomeRealtyCaseStudy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.welcomeHomeRealty.dbConnection.DBConnection;
import com.welcomeHomeRealtyCaseStudy.entities.Apartment;
import com.welcomeHomeRealtyCaseStudy.entities.Building;
import com.welcomeHomeRealtyCaseStudy.entities.Tenant;
import com.welcomeHomeRealtyCaseStudy.services.TenantServices;

public class ApartmentDAO extends DBConnection implements ApartmentDAOI {

	@Override
	public int addApartment(Apartment apartment) {
		int result = 0;
		try {
			this.connect();
			em.getTransaction().begin();
			em.persist(apartment);
			em.getTransaction().commit();
			result = 1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		return result;
		
	}

	@Override
	public Apartment deleteApartment(int apartmentId) {
		Apartment deletedApartment  = null;
		try {
			this.connect();
			deletedApartment  = em.find(Apartment.class, apartmentId);
			if(deletedApartment != null) {
				//if Apartment has tenants, cannot delete
				TenantServices tenantService = new TenantServices();
				List<Tenant> tenantList = tenantService.showAllTenantsByApartmentIdService(apartmentId);
				if(tenantList.size()>0){
					deletedApartment = null;
				}
				else {
					em.getTransaction().begin();
					em.remove(deletedApartment);
					em.getTransaction().commit();
				}
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		return deletedApartment;
	}

	@Override
	public int updateApartment(int apartmentId, Apartment apartment) {
		int result = 0;
		try {
			this.connect();
			Apartment updateApartment = em.find(Apartment.class, apartmentId);
			if(updateApartment != null) {
				em.getTransaction().begin();
				updateApartment.setBuilding(apartment.getBuilding());
				updateApartment.setApartmentName(apartment.getApartmentName());
				updateApartment.setRooms(apartment.getRooms());
				updateApartment.setBedrooms(apartment.getBedrooms());
				updateApartment.setBathrooms(apartment.getBathrooms());
				updateApartment.setSquareFeet(apartment.getSquareFeet());
				updateApartment.setRented(apartment.isRented());			
				em.getTransaction().commit();
				result = 1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		
		return result;
	}

	@Override
	public Apartment getApartmentById(int apartmentId) {
		Apartment foundApartment = null;
		try {
			this.connect();
			foundApartment = em.find(Apartment.class, apartmentId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		
		return foundApartment;
	}

	@Override
	public List<Apartment> showAllApartmentsByBuilding(Building building) {
		List<Apartment> apartmentList = new ArrayList<Apartment>();
		try 
		{
			this.connect();
			Query query = em.createQuery("Select a from Apartment a where a.building = :givenBuilding order by a.apartmentName");
			query.setParameter("givenBuilding", building);
			apartmentList = query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		
		return apartmentList;
	}
	

	
	
}
