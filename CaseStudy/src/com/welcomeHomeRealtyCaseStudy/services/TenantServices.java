package com.welcomeHomeRealtyCaseStudy.services;

import java.util.List;

import com.welcomeHomeRealtyCaseStudy.dao.TenantDAO;
import com.welcomeHomeRealtyCaseStudy.entities.Tenant;

public class TenantServices {

	private TenantDAO tenantDao = new TenantDAO();
	
	public boolean addTenantService(Tenant newTenant) {
		boolean result = false;
		if(tenantDao.addTenant(newTenant) == 1) {
			System.out.println("Tenant added");
			result = true;
		}
		else {
			System.out.println("Error: Tenant not added");
		}
		return result;
	}
	
	public boolean deleteTenantService(int tenantId) {
		boolean result = false;
		if(tenantDao.deleteTenant(tenantId) != null) {
			System.out.println("Tenant deleted");
			result=true;
		}
		else {
			System.out.println("Tenant non deleted");
		}
		
		return result;
	}
	
	public List<Tenant> showAllTenantsService() {
		List<Tenant> tenantList = tenantDao.showAllTenants(); 
		if(tenantList != null) {
			if(tenantList.size()>0) {
				for(Tenant t : tenantList) {
					System.out.println(t);
				}
			}
			else {
				System.out.println("No Tenants");
			}
		}
		else {
			System.out.println("Error Could not print out tenant list.");
		}
		return tenantList;
	}
	
	public boolean updateTenantService(int tenantId, Tenant tenant) {
		boolean result = false;
		if(tenantDao.updateTenant(tenantId, tenant)==1) {
			System.out.println("Tenant updated successfully");
			result=true;
		}
		else {
			System.out.println("Error: Tenant not updated");
		}
		return result;
	}
	
	
	public Tenant getTenantByIdService(int tenantId) {
		Tenant foundTenant = tenantDao.getTenantById(tenantId);
		if(foundTenant != null) {
			System.out.println("Tenant found");
			System.out.println(foundTenant);
		}
		else {
			System.out.println("Error: Tenant not found");
		}
		return foundTenant;
	}
	
	public List<Tenant> showAllTenantsByApartmentIdService(int apartmentId) {
		List<Tenant> tenantList = tenantDao.showAllTenantsByApartmentId(apartmentId);
		if(tenantList != null) {
			if(tenantList.size()>0) {
				for(Tenant t : tenantList) {
					System.out.println(t);
				}
			}
			else {
				System.out.println("No Tenants");
			}
		}
		else {
			System.out.println("Error Could not print out tenant list.");
		}
		return tenantList;
	}
	
	public double getTenantBalanceService(Tenant tenant) {
		double balance = 0.00;
		balance = tenantDao.getTenantBalance(tenant);
		return balance;
		
	}
}
