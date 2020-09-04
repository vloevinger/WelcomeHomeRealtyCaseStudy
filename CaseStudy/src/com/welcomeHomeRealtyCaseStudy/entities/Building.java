package com.welcomeHomeRealtyCaseStudy.entities;



import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;


@Entity
@Table(
name="Building", 
uniqueConstraints=@UniqueConstraint(columnNames={"address", "city","state","zip"})
)
public class Building  {
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int buildingId;
	
	@Basic
	@NotNull
	@Column(length=200, unique=true)
	private String buildingName;
	
	@Basic
	@NotNull
	@Column(length=100)
	private String address;
	
	@Basic
	@NotNull
	@Column(length=200)
	private String city;
	
	@Basic
	@NotNull
	@Column(length=2)
	private String state;
	
	@Basic
	@NotNull
	@Column(length=10)
	private String zip;
	
	@Basic
	@NotNull
	private int units;
	
	@Basic
	@NotNull
	@Column(precision = 12 , scale= 2)
	private double cost;
	
	@Basic
	@NotNull
	private Date datePurchased;
	
	@Basic
	private Date dateSold;

	@Basic
	@Column(precision = 12 , scale= 2)
	private double salePrice;
	
	public Building() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Building(String buildingName, String address, String city, String state, String zip, int units, double cost,
			Date datePurchased) {
		super();
		this.buildingName = buildingName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.units = units;
		this.cost = cost;
		this.datePurchased = datePurchased;
		this.dateSold= null;
		this.salePrice=0;
	}

	public Building(String buildingName, String address, String city, String state, String zip, int units, double cost,
			Date datePurchased, Date dateSold, double salePrice) {
		super();
		this.buildingName = buildingName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.units = units;
		this.cost = cost;
		this.datePurchased= datePurchased;
		this.dateSold = dateSold;	
		this.salePrice = salePrice;
	}
	
	
//for testing only
	public Building(int buildingId, String buildingName, String address, String city, String state, String zip,
		int units, double cost, Date datePurchased) {
		this.buildingId = buildingId;
		this.buildingName = buildingName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.units = units;
		this.cost = cost;
		this.datePurchased = datePurchased;
		this.dateSold = null;
		this.salePrice = 0;
	}


	public int getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(int buildingId) {
		this.buildingId =buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Date getDatePurchased() {
		return datePurchased;
	}

	public void setDatePurchased(Date datePurchased) {
		this.datePurchased = datePurchased;
	}

	public Date getDateSold() {
		return dateSold;
	}

	public void setDateSold(Date dateSold) {
		this.dateSold = dateSold;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + buildingId;
		result = prime * result + ((buildingName == null) ? 0 : buildingName.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((datePurchased == null) ? 0 : datePurchased.hashCode());
		result = prime * result + ((dateSold == null) ? 0 : dateSold.hashCode());
		temp = Double.doubleToLongBits(salePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + units;
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		Building other = (Building) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (buildingId != other.buildingId)
			return false;
		if (buildingName == null) {
			if (other.buildingName != null)
				return false;
		} else if (!buildingName.equals(other.buildingName))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (datePurchased == null) {
			if (other.datePurchased != null)
				return false;
		} else if (!datePurchased.equals(other.datePurchased))
			return false;
		if (dateSold == null) {
			if (other.dateSold != null)
				return false;
		} else if (!dateSold.equals(other.dateSold))
			return false;
		if (Double.doubleToLongBits(salePrice) != Double.doubleToLongBits(other.salePrice))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (units != other.units)
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Building [buildingId=" + buildingId + ", buildingName=" + buildingName + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", units=" + units + ", cost=" + cost
				+ ", datePurchased=" + datePurchased + ", dateSold=" + dateSold + ", salePrice=" + salePrice + "]";
	}
	

	
	

	
}


