package com.welcomeHomeRealtyCaseStudy.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;

@Entity
@Table(name="Apartment",
uniqueConstraints= @UniqueConstraint(columnNames= {"apartmentName","building.buildingId"})
)
public class Apartment {
	
	
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int apartmentId;
	
	@ManyToOne
	@NotNull
	private Building building;
	
	@Basic
	@NotNull
	@Column(length=2)
	private String apartmentName;
	
	@Basic
	@NotNull
	private int rooms;
	
	@Basic
	@NotNull
	private int bedrooms;
	
	@Basic
	@NotNull
	@Column(precision = 12 )
	private double bathrooms;
	
	@Basic
	@NotNull
	private int squareFeet;
	
	@Basic
	@NotNull
	private boolean rented;
	
	public Apartment() {
		
	}

	public Apartment(Building building, String apartmentName, int rooms, int bedrooms,
			double bathrooms, int squareFeet, boolean rented) {
		this.building = building;
		this.apartmentName = apartmentName;
		this.rooms = rooms;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.squareFeet = squareFeet;
		this.rented = rented;
	}
	
	
	//for testing only
	public Apartment(int apartmentId, Building building, String apartmentName, int rooms, int bedrooms,
			double bathrooms, int squareFeet, boolean rented) {
		super();
		this.apartmentId = apartmentId;
		this.building = building;
		this.apartmentName = apartmentName;
		this.rooms = rooms;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.squareFeet = squareFeet;
		this.rented = rented;
	}

	public int getApartmentId() {
		return apartmentId;
	}


	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public int getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	public double getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(double bathrooms) {
		this.bathrooms = bathrooms;
	}

	public int getSquareFeet() {
		return squareFeet;
	}

	public void setSquareFeet(int squareFeet) {
		this.squareFeet = squareFeet;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + apartmentId;
		result = prime * result + ((apartmentName == null) ? 0 : apartmentName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(bathrooms);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + bedrooms;
		result = prime * result + ((building == null) ? 0 : building.hashCode());
		result = prime * result + (rented ? 1231 : 1237);
		result = prime * result + rooms;
		result = prime * result + squareFeet;
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
		Apartment other = (Apartment) obj;
		if (apartmentId != other.apartmentId)
			return false;
		if (apartmentName == null) {
			if (other.apartmentName != null)
				return false;
		} else if (!apartmentName.equals(other.apartmentName))
			return false;
		if (Double.doubleToLongBits(bathrooms) != Double.doubleToLongBits(other.bathrooms))
			return false;
		if (bedrooms != other.bedrooms)
			return false;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (rented != other.rented)
			return false;
		if (rooms != other.rooms)
			return false;
		if (squareFeet != other.squareFeet)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Apartment [apartmentId=" + apartmentId + ", building=" + building + ", apartmentName=" + apartmentName
				+ ", rooms=" + rooms + ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms + ", squareFeet="
				+ squareFeet + ", rented=" + rented + "]";
	}

	
	
	
	
	
	
}
