package com.welcomeHomeRealtyCaseStudy.dao;

import java.util.List;


import com.welcomeHomeRealtyCaseStudy.entities.Invoice;

public interface InvoiceDAOI {
	public int addInvoice(Invoice invoice);
	public Invoice deleteInvoice(int invoiceId);
	public int updateInvoice(int invoiceId, Invoice newInvoice);
	public Invoice getInvoiceById(int invoiceId);
	public List<Invoice> showAllInvoices();
	public List<Invoice> showAllInvoicesbyTenant(int tenantId,boolean showOpenInvoicesOnly);
	public boolean verifyPaymentServices();
}
