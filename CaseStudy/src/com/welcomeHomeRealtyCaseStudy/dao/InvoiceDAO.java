package com.welcomeHomeRealtyCaseStudy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.welcomeHomeRealty.dbConnection.DBConnection;
import com.welcomeHomeRealtyCaseStudy.entities.Invoice;
import com.welcomeHomeRealtyCaseStudy.entities.Tenant;

public class InvoiceDAO extends DBConnection implements InvoiceDAOI {

	@Override
	public int addInvoice(Invoice invoice) {
		int result = 0;
		try {
			this.connect();
			em.getTransaction().begin();
			em.persist(invoice);
			em.getTransaction().commit();
			result =1;
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
	public Invoice deleteInvoice(int invoiceId) {
		Invoice deletedInvoice=null;
		try {
			this.connect();
			deletedInvoice = em.find(Invoice.class,invoiceId);
			if(deletedInvoice !=null) {
				em.getTransaction().begin();
				em.remove(deletedInvoice);
				em.getTransaction().commit();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		return deletedInvoice;
	}

	@Override
	public int updateInvoice(int invoiceId, Invoice invoice) {
		int result = 0;
		
		try {
			this.connect();
			Invoice updatedInvoice = em.find(Invoice.class, invoiceId);
			if(updatedInvoice!=null) {
				em.getTransaction().begin();
				updatedInvoice.setTenant(invoice.getTenant());
				updatedInvoice.setDescription(invoice.getDescription());
				updatedInvoice.setAmount(invoice.getAmount());
				updatedInvoice.setPaid(invoice.isPaid());
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
	public Invoice getInvoiceById(int invoiceId) {
		Invoice invoice = null;
		try {
			this.connect();
			invoice = em.find(Invoice.class, invoiceId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		return invoice;
	}

	@Override
	public List<Invoice> showAllInvoices() {
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		try {
			this.connect();
			Query query = em.createQuery("Select i from Invoice i order by i.tenant.lastName, i.tenant.firstName");
			invoiceList = query.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		
		return invoiceList;
	}

	@Override
	public List<Invoice> showAllInvoicesbyTenant(int tenantId,boolean showOpenInvoicesOnly) {
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		try {
			this.connect();
			Tenant tenant = em.find(Tenant.class, tenantId);
			Query query = null;
			if(showOpenInvoicesOnly) {
				 query = em.createQuery("Select i from Invoice i where i.tenant = :givenTenant AND i.paid = false order by i.tenant.lastName, i.tenant.firstName");
			}
			else {
			 query = em.createQuery("Select i from Invoice i where i.tenant = :givendTenant");	
			}
			
			query.setParameter("givenTenant", tenant);
			invoiceList = query.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			this.disconnect();
		}
		
		return invoiceList;
	}
	
	
	
	//need to add verification logic
	@Override
	public boolean verifyPaymentServices() {
		boolean result = false;
		//if verified
		//add verification logic here
		result = true;
		return result;
	}
	
}
