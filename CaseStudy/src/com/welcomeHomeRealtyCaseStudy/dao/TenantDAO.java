package com.welcomeHomeRealtyCaseStudy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.CaseStudy.exceptions.CustomException;
import com.welcomeHomeRealty.dbConnection.DBConnection;
import com.welcomeHomeRealtyCaseStudy.entities.Apartment;
import com.welcomeHomeRealtyCaseStudy.entities.Invoice;
import com.welcomeHomeRealtyCaseStudy.entities.Tenant;
import com.welcomeHomeRealtyCaseStudy.services.InvoiceServices;
import com.welcomeHomeRealtyCaseStudy.services.UserLoginServices;

public class TenantDAO extends DBConnection implements TenantDAOI {

	@Override
	public int addTenant(Tenant tenant) {
		int result =0;
		try {
			this.connect();
			em.getTransaction().begin();
			em.persist(tenant);
			em.getTransaction().commit();
			result=1;
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
	public Tenant deleteTenant(int tenantId)  {
		Tenant deletedTenant = null;
		try {
			this.connect();
			deletedTenant = em.find(Tenant.class, tenantId);
			if(deletedTenant!=null) {
				//if Tenant has invoices 
				InvoiceServices invoiceService = new InvoiceServices();
				UserLoginServices userLoginService = new UserLoginServices();
				List<Invoice> invoiceList = invoiceService.showAllInvoicesByTenantService(deletedTenant.getTenantId(),false);
				System.out.println("invoice List: " + invoiceList);
				if(invoiceList.size()>0) {
					deletedTenant = null;
				}
				
				else {
					em.getTransaction().begin();
					em.remove(deletedTenant);
					em.getTransaction().commit();
				}
				
			}
			
		}
		catch(Exception e) {
			deletedTenant = null;
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		return deletedTenant;
	}

	@Override
	public int updateTenant(int tenantId, Tenant tenant) {
		int result = 0;
		try {
			this.connect();
			Tenant updateTenant = em.find(Tenant.class, tenantId);
			if(updateTenant != null) {
				em.getTransaction().begin();
				updateTenant.setApartment(tenant.getApartment());
				updateTenant.setFirstName(tenant.getFirstName());
				updateTenant.setLastName(tenant.getLastName());
				updateTenant.setPhoneNumber(tenant.getPhoneNumber());
				updateTenant.setEmail(tenant.getEmail());
				updateTenant.setLeaseStart(tenant.getLeaseStart());
				updateTenant.setLeaseEnd(tenant.getLeaseEnd());
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
	public Tenant getTenantById(int tenantId) {
		Tenant tenant = null;
		try {
			this.connect();
			tenant = em.find(Tenant.class, tenantId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		return tenant;
	}

	@Override
	public List<Tenant> showAllTenants() {
		List<Tenant> tenantList = new ArrayList<Tenant>();
		try {
			this.connect();
			Query query = em.createQuery("Select t from Tenant t order by t.lastName, t.firstName");
			tenantList = query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		
		return tenantList;
	}
	
	@Override
	public List<Tenant> showAllTenantsByApartmentId(int apartmentId) {
		List<Tenant> tenantList = new ArrayList<Tenant>();
		try {
			this.connect();
			Apartment apartment = em.find(Apartment.class, apartmentId);
			Query query = em.createQuery("Select t from Tenant t where t.apartment =:givenApartment order by t.lastName, t.firstName");
			query.setParameter("givenApartment", apartment);
			tenantList = query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		
		return tenantList;
	}
	
	@Override
	public double getTenantBalance(Tenant tenant) {
		double balance = 0.00;
		try {
			this.connect();
				Query query = em.createQuery("Select Sum(i.amount) from Invoice i where i.tenant = :givenTenant And i.paid = false");
				query.setParameter("givenTenant", tenant);
				balance =(double)query.getSingleResult();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		return balance;
	}
	

	

}
