package com.welcomeHomeRealtyCaseStudy.services;

import java.util.List;

import com.welcomeHomeRealtyCaseStudy.dao.InvoiceDAO;
import com.welcomeHomeRealtyCaseStudy.entities.Invoice;

public class InvoiceServices {
	private InvoiceDAO invoiceDao = new InvoiceDAO();
	
	public boolean addInvoiceService(Invoice invoice) {
		boolean result = false;
		if(invoiceDao.addInvoice(invoice)==1 ) {
			result=true;
		}
		return result;
	}
	
	public boolean deleteInvoiceService(int invoiceId) {
		boolean result = false;
		if(invoiceDao.deleteInvoice(invoiceId) != null) {
			result = true;
		}
		return result;
	}
	
	public List<Invoice> showAllInvoicesService() {
		List<Invoice> invoiceList = invoiceDao.showAllInvoices();
		return invoiceList;
	}
	public List<Invoice> showAllInvoicesByTenantService(int tenantId,boolean showOpenInvoicesOnly) {
		List<Invoice> invoiceList = invoiceDao.showAllInvoicesbyTenant(tenantId,showOpenInvoicesOnly);
		return invoiceList;
	}
	
	public boolean updateInvoiceService(int invoiceId, Invoice invoice) {
		boolean result = false;
		if(invoiceDao.updateInvoice(invoiceId, invoice) == 1) {
			result=true;
		}
		return result;
	}
	
	public Invoice getInvoiceByIdService(int invoiceId) {
		Invoice invoice = invoiceDao.getInvoiceById(invoiceId);
		return invoice;
	}
	
	//to be completed
	public boolean verifyPaymentService() {
		boolean result = invoiceDao.verifyPaymentServices();
		return result;
	}
	
	
}
