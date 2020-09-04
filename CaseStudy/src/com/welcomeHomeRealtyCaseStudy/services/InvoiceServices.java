package com.welcomeHomeRealtyCaseStudy.services;

import java.util.List;

import com.welcomeHomeRealtyCaseStudy.dao.InvoiceDAO;
import com.welcomeHomeRealtyCaseStudy.entities.Invoice;

public class InvoiceServices {
	private InvoiceDAO invoiceDao = new InvoiceDAO();
	
	public boolean addInvoiceService(Invoice invoice) {
		boolean result = false;
		if(invoiceDao.addInvoice(invoice)==1 ) {
			System.out.println("Invoice added");
			result=true;
		}
		else {
			System.out.println("Error: Invoice not added");
		}
		return result;
	}
	
	public boolean deleteInvoiceService(int invoiceId) {
		boolean result = false;
		if(invoiceDao.deleteInvoice(invoiceId) != null) {
			System.out.println("Invoice deleted");
			result = true;
		}
		else {
			System.out.println("Error: Invoice not deleted");
		}
		return result;
	}
	
	public List<Invoice> showAllInvoicesService() {
		List<Invoice> invoiceList = invoiceDao.showAllInvoices();
		if(invoiceList!= null) {
			if(invoiceList.size()>0) {
				for(Invoice i: invoiceList) {
					System.out.println(i);
				}
			}
			else {
				System.out.println("No Invoices to list");
			}
		}
		else {
			System.out.println("Error: could not print invoices");
		}
		
		return invoiceList;
	}
	public List<Invoice> showAllInvoicesByTenantService(int tenantId,boolean showOpenInvoicesOnly) {
		List<Invoice> invoiceList = invoiceDao.showAllInvoicesbyTenant(tenantId,showOpenInvoicesOnly);
		if(invoiceList!= null) {
			if(invoiceList.size()>0) {
				for(Invoice i: invoiceList) {
					System.out.println(i);
				}
			}
			else {
				System.out.println("No Invoices to list");
			}
		}
		else {
			System.out.println("Error: could not print invoices");
		}
		
		return invoiceList;
	}
	
	public boolean updateInvoiceService(int invoiceId, Invoice invoice) {
		boolean result = false;
		if(invoiceDao.updateInvoice(invoiceId, invoice) == 1) {
			System.out.println("Invoice updated");
			result=true;
		}
		else {
			System.out.println("Error: invoice not updated");
		}
		return result;
	}
	
	public Invoice getInvoiceByIdService(int invoiceId) {
		Invoice invoice = invoiceDao.getInvoiceById(invoiceId);
		if(invoice != null) {
			System.out.println("Invoice found");
			System.out.println(invoice);
		}
		else {
			System.out.println("Error: Invoice does not exist");
		}
		return invoice;
	}
	
	//to be completed
	public boolean verifyPaymentService() {
		boolean result = invoiceDao.verifyPaymentServices();
		return result;
	}
	
	
}
