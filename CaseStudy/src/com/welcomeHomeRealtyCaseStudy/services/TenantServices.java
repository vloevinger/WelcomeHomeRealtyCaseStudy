package com.welcomeHomeRealtyCaseStudy.services;

import java.util.List;

import com.welcomeHomeRealtyCaseStudy.dao.TenantDAO;
import com.welcomeHomeRealtyCaseStudy.entities.Tenant;

public class TenantServices {

	private TenantDAO tenantDao = new TenantDAO();
	
	public boolean addTenantService(Tenant newTenant) {
		boolean result = false;
		if(tenantDao.addTenant(newTenant) == 1) {
			result = true;
		}
		return result;
	}
	
	public boolean deleteTenantService(int tenantId) {
		boolean result = false;
		if(tenantDao.deleteTenant(tenantId) != null) {
			result=true;
		}
		return result;
	}
	
	public List<Tenant> showAllTenantsService() {
		List<Tenant> tenantList = tenantDao.showAllTenants(); 
		return tenantList;
	}
	
	public boolean updateTenantService(int tenantId, Tenant tenant) {
		boolean result = false;
		if(tenantDao.updateTenant(tenantId, tenant)==1) {
			result=true;
		}
		return result;
	}
	
	
	public Tenant getTenantByIdService(int tenantId) {
		Tenant foundTenant = tenantDao.getTenantById(tenantId);
		return foundTenant;
	}
	
	public List<Tenant> showAllTenantsByApartmentIdService(int apartmentId) {
		List<Tenant> tenantList = tenantDao.showAllTenantsByApartmentId(apartmentId);
			return tenantList;
	}
	
	public double getTenantBalanceService(Tenant tenant) {
		double balance = 0.00;
		balance = tenantDao.getTenantBalance(tenant);
		return balance;
		
	}
}
