package com.welcomeHomeRealtyCaseStudy.dao;

import java.util.List;
import com.welcomeHomeRealtyCaseStudy.entities.Tenant;

public interface TenantDAOI {
	public int addTenant(Tenant tenant);
	public Tenant deleteTenant(int tenantId);
	public int updateTenant(int tenantId, Tenant tenant);
	public Tenant getTenantById(int tenantId);
	public List<Tenant> showAllTenants();
	public List<Tenant> showAllTenantsByApartmentId(int apartmentId);
	public double getTenantBalance(Tenant tenant);
}
