package com.welcomeHomeRealtyCaseStudy.entities;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;
@Entity
@Table(name = "Tenant", 
uniqueConstraints = @UniqueConstraint(columnNames = {"email","apartment.apartmentId"})
)
public class Tenant {
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int tenantId;

	@ManyToOne
	@NotNull
	private Apartment apartment;  
	
	@Basic
	@NotNull
	@Column(length=100)
	private String firstName;
	
	@Basic
	@NotNull
	@Column(length=100)
	private String lastName;
	
	@Basic
	@NotNull
	@Column(length=10)
	private String phoneNumber;
	
	@Basic
	@NotNull
	@Column(length=100)
	private String email;
	
	@Basic
	@NotNull
	private Date leaseStart;
	
	@Basic
	@NotNull
	private Date leaseEnd;
	
	@Basic
	@Column(length=1000)
	@NotNull
	private String leaseLocation;

	public Tenant() {
	
	}

	//for testing
	public Tenant(int tenantId, Apartment apartment, String firstName, String lastName, String phoneNumber,
			String email, Date leaseStart, Date leaseEnd) {
	
		this.tenantId = tenantId;
		this.apartment = apartment;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.leaseStart = leaseStart;
		this.leaseEnd = leaseEnd;
		this.leaseLocation = Integer.toString(tenantId) + "_" + apartment.getApartmentId();
	}

	public Tenant(Apartment apartment, String firstName, String lastName, String phoneNumber, String email,
			Date leaseStart, Date leaseEnd) {
		this.apartment = apartment;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.leaseStart = leaseStart;
		this.leaseEnd = leaseEnd;
		this.leaseLocation = lastName + "_" + firstName + "_" + leaseStart;
	}
	

	public Tenant(Apartment apartment, String firstName, String lastName, String phoneNumber, String email) {
		super();
		this.apartment = apartment;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public int getTenantId() {
		return tenantId;
	}
	

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLeaseStart() {
		return leaseStart;
	}

	public void setLeaseStart(Date leaseStart) {
		this.leaseStart = leaseStart;
	}

	public Date getLeaseEnd() {
		return leaseEnd;
	}

	public void setLeaseEnd(Date leaseEnd) {
		this.leaseEnd = leaseEnd;
	}

	public String getLeaseLocation() {
		return leaseLocation;
	}

	public void setLeaseLocation(String leaseLocation) {
		this.leaseLocation = leaseLocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apartment == null) ? 0 : apartment.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((leaseEnd == null) ? 0 : leaseEnd.hashCode());
		result = prime * result + ((leaseLocation == null) ? 0 : leaseLocation.hashCode());
		result = prime * result + ((leaseStart == null) ? 0 : leaseStart.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + tenantId;
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
		Tenant other = (Tenant) obj;
		if (apartment == null) {
			if (other.apartment != null)
				return false;
		} else if (!apartment.equals(other.apartment))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (leaseEnd == null) {
			if (other.leaseEnd != null)
				return false;
		} else if (!leaseEnd.equals(other.leaseEnd))
			return false;
		if (leaseLocation == null) {
			if (other.leaseLocation != null)
				return false;
		} else if (!leaseLocation.equals(other.leaseLocation))
			return false;
		if (leaseStart == null) {
			if (other.leaseStart != null)
				return false;
		} else if (!leaseStart.equals(other.leaseStart))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (tenantId != other.tenantId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", apartment=" + apartment + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phoneNumber=" + phoneNumber + ", email=" + email + ", leaseStart=" + leaseStart
				+ ", leaseEnd=" + leaseEnd + ", leaseLocation=" + leaseLocation + "]";
	}
	
	
	
	
	
	}
