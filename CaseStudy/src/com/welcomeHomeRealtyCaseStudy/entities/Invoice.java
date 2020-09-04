package com.welcomeHomeRealtyCaseStudy.entities;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;

@Entity
@Table(name="Invoice",
uniqueConstraints = @UniqueConstraint(columnNames = {"description","tenantId"})
)
public class Invoice {
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int invoiceId;
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "tenantId")
	private Tenant tenant;
	
	@Basic
	@NotNull
	@Column(length=1000)
	private String description;
	
	@Basic
	@NotNull
	@Column(precision =12 , scale =2)
	private double amount;
	
	@Basic
	@NotNull
	private boolean paid;

	public Invoice() {

	}

	//for testing
	public Invoice(int invoiceId, com.welcomeHomeRealtyCaseStudy.entities.Tenant tenant, String description,
			double amount, boolean paid) {
		super();
		this.invoiceId = invoiceId;
		this.tenant = tenant;
		this.description = description;
		this.amount = amount;
		this.paid = paid;
	}

	public Invoice(com.welcomeHomeRealtyCaseStudy.entities.Tenant tenant, String description, double amount,
			boolean paid) {
		super();
		this.tenant = tenant;
		this.description = description;
		this.amount = amount;
		this.paid = paid;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + invoiceId;
		result = prime * result + (paid ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (invoiceId != other.invoiceId)
			return false;
		if (paid != other.paid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", Tenant=" + tenant + ", description=" + description + ", amount="
				+ amount + ", paid=" + paid + "]";
	}

	

	 
	
	}
