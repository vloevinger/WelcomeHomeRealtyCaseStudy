package com.welcomeHomeRealtyCaseStudy.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import com.welcomeHomeRealtyCaseStudy.dao.ApartmentDAO;
import com.welcomeHomeRealtyCaseStudy.dao.BuildingDAO;
import com.welcomeHomeRealtyCaseStudy.dao.InvoiceDAO;
import com.welcomeHomeRealtyCaseStudy.dao.TenantDAO;
import com.welcomeHomeRealtyCaseStudy.entities.Apartment;
import com.welcomeHomeRealtyCaseStudy.entities.Building;
import com.welcomeHomeRealtyCaseStudy.entities.Invoice;
import com.welcomeHomeRealtyCaseStudy.entities.Tenant;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class InvoiceDAOTest {
	private int paramId;
	private Invoice invoice;
	private static BuildingDAO buildingDao = new BuildingDAO();
	private static ApartmentDAO apartmentDao = new ApartmentDAO();
	private static TenantDAO tenantDao = new TenantDAO();
	private static InvoiceDAO invoiceDao = new InvoiceDAO();
	
	private static Building building1 = new Building(1,"Mansfield Park","454 W 22nd Street","New York","NY","10011",12,1000000,Date.valueOf("2015-01-02"));
	private static Building building2 = new Building (2,"Northanger Abbey","39 W 37th Street","New York","NY","10018",18,2000000,Date.valueOf("2010-01-01"));
	private static Building building3 = new Building(3,"Norland Park","222 E 93rd Street","New York","NY","10128",10,1000000,Date.valueOf("2011-09-05"));
	private static Building building4 = new Building(4,"Pemberly","45 W 139tbuildingh Street","New York","NY","10037",12,3000000,Date.valueOf("2012-06-04"));
	private static Building building5 = new Building(5,"Churchill","480 Saint Nicholas Avenue","New York","NY","10030",8,1500000,Date.valueOf("2015-07-02"));	
	private static Apartment apartment1 = new Apartment(1,building1,"1A",5,2,1.5,2500,true);
	private static Apartment apartment2 = new Apartment(2,building1,"1B",5,2,1.5,2500,true);
	private static Apartment apartment3 = new Apartment(3,building2,"1A",5,2,1.5,2500,true);
	private static Apartment apartment4 = new Apartment(4,building2,"1B",5,2,1.5,2500,true);
	private static Apartment apartment5 = new Apartment(5,building3,"1A",5,2,1.5,2500,true);
	private static Apartment apartment6 = new Apartment(6,building3,"1B",5,2,1.5,2500,true);
	private static Apartment apartment7 = new Apartment(7,building4,"1A",5,2,1.5,2500,true);
	private static Apartment apartment8 = new Apartment(8,building4,"1B",5,2,1.5,2500,true);
	private static Apartment apartment9 = new Apartment(9,building5,"1A",5,2,1.5,2500,true);
	private static Apartment apartment10 = new Apartment(10,building5,"1B",5,2,1.5,2500,true);
	private static Tenant tenant1 = new Tenant(1,apartment1,"Elinor","Dashwood","3238288840","e.dashwood@gmail.com",Date.valueOf("2020-01-01"),Date.valueOf("2020-12-31"));
	private static Tenant tenant2 = new Tenant(2,apartment2,"Colonel","Brandon","3238288841","c.Brandon@gmail.com",Date.valueOf("2020-01-02"),Date.valueOf("2020-12-31"));
	private static Tenant tenant3 = new Tenant(3,apartment3,"Edward","Ferars","3238288842","e.ferars@gmail.com",Date.valueOf("2020-01-03"),Date.valueOf("2020-12-31"));
	private static Tenant tenant4 = new Tenant(4,apartment4,"Eliza","Brandon","3238288843","e.brandon@gmail.com",Date.valueOf("2020-01-04"),Date.valueOf("2020-12-31"));
	private static Tenant tenant5 = new Tenant(5,apartment5,"Jane","Bennet","3238288844","j.bennet@gmail.com",Date.valueOf("2020-01-05"),Date.valueOf("2020-12-31"));
	private static Tenant tenant6 = new Tenant(6,apartment6,"Fitzwilliam","Darcy","3238288845","f.darcy@gmail.com",Date.valueOf("2020-01-06"),Date.valueOf("2020-12-31"));
	private static Tenant tenant7 = new Tenant(7,apartment7,"George","Wickham","3238288846","g.wickham@gmail.com",Date.valueOf("2020-01-07"),Date.valueOf("2020-12-31"));
	private static Tenant tenant8 = new Tenant(8,apartment8,"Fanny","Price","3238288847","f.price@gmail.com",Date.valueOf("2020-01-08"),Date.valueOf("2020-12-31"));
	private static Tenant tenant9 = new Tenant(9,apartment9,"Emma","Woodhouse","3238288848","e.woodhouse@gmail.com",Date.valueOf("2020-01-09"),Date.valueOf("2020-12-31"));
	private static Tenant tenant10 = new Tenant(10,apartment10,"Jane","Fairfax","3238288849","j.fairfax@gmail.com",Date.valueOf("2020-01-10"),Date.valueOf("2020-12-31"));
	
	
	public InvoiceDAOTest(int paramId, Invoice invoice) {
		this.paramId = paramId;
		this.invoice = invoice;
	}
	
	@Parameterized.Parameters
	public static Collection param() {
		Invoice invoice1 = new Invoice(tenant1,"January rent",1500.00,false);
		Invoice invoice2 = new Invoice(tenant1,"February rent",1500.00,false);
		Invoice invoice3 = new Invoice(tenant1,"March rent",1500.00,false);
		
		Invoice invoice4= new Invoice(tenant2,"January rent",1500.00,false);
		Invoice invoice5 = new Invoice(tenant2,"February rent",1500.00,false);
		Invoice invoice6 = new Invoice(tenant2,"March rent",1500.00,false);

		Invoice invoice7 = new Invoice(tenant3,"January rent",1500.00,false);
		Invoice invoice8 = new Invoice(tenant3,"February rent",1500.00,false);
		Invoice invoice9 = new Invoice(tenant3,"March rent",1500.00,false);

		Invoice invoice10= new Invoice(tenant4,"January rent",1500.00,false);
		Invoice invoice11= new Invoice(tenant4,"February rent",1500.00,false);
		Invoice invoice12= new Invoice(tenant4,"March rent",1500.00,false);

		Invoice invoice13= new Invoice(tenant5,"January rent",1500.00,false);
		Invoice invoice14= new Invoice(tenant5,"February rent",1500.00,false);
		Invoice invoice15= new Invoice(tenant5,"March rent",1500.00,false);

		Invoice invoice16= new Invoice(tenant6,"January rent",1500.00,false);
		Invoice invoice17= new Invoice(tenant6,"February rent",1500.00,false);
		Invoice invoice18= new Invoice(tenant6,"March rent",1500.00,false);

		Invoice invoice19= new Invoice(tenant7,"January rent",1500.00,false);
		Invoice invoice20= new Invoice(tenant7,"February rent",1500.00,false);
		Invoice invoice21= new Invoice(tenant7,"March rent",1500.00,false);

		Invoice invoice22= new Invoice(tenant8,"January rent",1500.00,false);
		Invoice invoice23= new Invoice(tenant8,"February rent",1500.00,false);
		Invoice invoice24= new Invoice(tenant8,"March rent",1500.00,false);

		Invoice invoice25= new Invoice(tenant9,"January rent",1500.00,false);
		Invoice invoice26= new Invoice(tenant9,"February rent",1500.00,false);
		Invoice invoice27= new Invoice(tenant9,"March rent",1500.00,false);

		Invoice invoice28= new Invoice(tenant10,"January rent",1500.00,false);
		Invoice invoice29= new Invoice(tenant10,"February rent",1500.00,false);
		Invoice invoice30= new Invoice(tenant10,"March rent",1500.00,false);
		
		return Arrays.asList(new Object[][] {
			{1,invoice1},
			{2,invoice2},
			{3,invoice3},
			{4,invoice4},
			{5,invoice5},
			{6,invoice6},
			{7,invoice7},
			{8,invoice8},
			{9,invoice9},
			{10,invoice10},
			{11,invoice11},
			{12,invoice12},
			{13,invoice13},
			{14,invoice14},
			{15,invoice15},
			{16,invoice16},
			{17,invoice17},
			{18,invoice18},
			{19,invoice19},
			{20,invoice20},
			{21,invoice21},
			{22,invoice22},
			{23,invoice23},
			{24,invoice24},
			{25,invoice25},
			{26,invoice26},
			{27,invoice27},
			{28,invoice28},
			{29,invoice29},
			{30,invoice30}
		});
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		buildingDao.addBuilding(building1);
		buildingDao.addBuilding(building2);
		buildingDao.addBuilding(building3);
		buildingDao.addBuilding(building4);
		buildingDao.addBuilding(building5);
		apartmentDao.addApartment(apartment1);
		apartmentDao.addApartment(apartment2);
		apartmentDao.addApartment(apartment3);
		apartmentDao.addApartment(apartment4);
		apartmentDao.addApartment(apartment5);
		apartmentDao.addApartment(apartment6);
		apartmentDao.addApartment(apartment7);
		apartmentDao.addApartment(apartment8);
		apartmentDao.addApartment(apartment9);
		apartmentDao.addApartment(apartment10);
		tenantDao.addTenant(tenant1);
		tenantDao.addTenant(tenant2);
		tenantDao.addTenant(tenant3);
		tenantDao.addTenant(tenant4);
		tenantDao.addTenant(tenant5);
		tenantDao.addTenant(tenant6);
		tenantDao.addTenant(tenant7);
		tenantDao.addTenant(tenant8);
		tenantDao.addTenant(tenant9);
		tenantDao.addTenant(tenant10);
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tenantDao.deleteTenant(tenant1.getTenantId());
		tenantDao.deleteTenant(tenant2.getTenantId());
		tenantDao.deleteTenant(tenant3.getTenantId());
		tenantDao.deleteTenant(tenant4.getTenantId());
		tenantDao.deleteTenant(tenant5.getTenantId());
		tenantDao.deleteTenant(tenant6.getTenantId());
		tenantDao.deleteTenant(tenant7.getTenantId());
		tenantDao.deleteTenant(tenant8.getTenantId());
		tenantDao.deleteTenant(tenant9.getTenantId());
		tenantDao.deleteTenant(tenant10.getTenantId());
		apartmentDao.deleteApartment(apartment1.getApartmentId());
		apartmentDao.deleteApartment(apartment2.getApartmentId());
		apartmentDao.deleteApartment(apartment3.getApartmentId());
		apartmentDao.deleteApartment(apartment4.getApartmentId());
		apartmentDao.deleteApartment(apartment5.getApartmentId());
		apartmentDao.deleteApartment(apartment6.getApartmentId());
		apartmentDao.deleteApartment(apartment7.getApartmentId());
		apartmentDao.deleteApartment(apartment8.getApartmentId());
		apartmentDao.deleteApartment(apartment9.getApartmentId());
		apartmentDao.deleteApartment(apartment10.getApartmentId());
		buildingDao.deleteBuilding(building1.getBuildingId());
		buildingDao.deleteBuilding(building2.getBuildingId());
		buildingDao.deleteBuilding(building3.getBuildingId());
		buildingDao.deleteBuilding(building4.getBuildingId());
		buildingDao.deleteBuilding(building5.getBuildingId());
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCase1AddInvoice() {
		//given
		int expected=1;
		//when
		int actual = invoiceDao.addInvoice(invoice);
		//then
		assertEquals(expected,actual);
	}

	@Test
	public void testCase6DeleteInvoice() {
		//given
		Invoice expectedInvoice = invoice;
		//when
		Invoice actualInvoice = invoiceDao.deleteInvoice(invoice.getInvoiceId());
	
		//then
			assertEquals(expectedInvoice, actualInvoice);
	}

	@Test
	public void testCase5UpdateInvoice() {
		//given
		 int expected = 1;
		//when

		 invoice.setDescription("Updated Desc");
		 int actual = invoiceDao.updateInvoice(invoice.getInvoiceId(), invoice);
		//then
		assertEquals(expected,actual);
	}

	@Test
	public void testCase4GetInvoiceById() {
		//given
		Invoice expectedInvoice= invoice;

		//when
		Invoice actualInvoice = invoiceDao.getInvoiceById(invoice.getInvoiceId());
		//then
		assertEquals(expectedInvoice,actualInvoice);
	}

	@Test
	public void testCase2ShowAllInvoices() {
		
		//given
		List<Invoice> expectedInvoice = new ArrayList<>();
		expectedInvoice.add(invoice);
		//when
		List<Invoice> actualInvoiceList = invoiceDao.showAllInvoices();
		
		//then
		assertEquals(expectedInvoice,actualInvoiceList);
	}

	@Test
	public void testCase3ShowAllInvoicesbyTenant() {
		//given
		List<Invoice> expectedInvoice = new ArrayList<>();
		expectedInvoice.add(invoice);
		//when
		List<Invoice> actualInvoiceList = invoiceDao.showAllInvoicesbyTenant(invoice.getTenant().getTenantId(), false);
				
		//then
		assertEquals(expectedInvoice,actualInvoiceList);
	}

	

}
