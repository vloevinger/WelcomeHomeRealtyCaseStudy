package com.welcomeHomeRealtyCaseStudy.entities;

import java.sql.Date;
import java.util.List;

import com.welcomeHomeRealtyCaseStudy.dao.BuildingDAO;
import com.welcomeHomeRealtyCaseStudy.services.ApartmentServices;
import com.welcomeHomeRealtyCaseStudy.services.BuildingServices;
import com.welcomeHomeRealtyCaseStudy.services.InvoiceServices;
import com.welcomeHomeRealtyCaseStudy.services.TenantServices;
import com.welcomeHomeRealtyCaseStudy.services.UserLoginServices;




public class testJPA {

	public static void main(String[] args) {
		Building building1 = new Building(1,"Mansfield Park","454 W 22nd Street","New York","NY","10011",12,1000000,Date.valueOf("2015-01-02"));
		Building building2 = new Building (2,"Northanger Abbey","39 W 37th Street","New York","NY","10018",18,2000000,Date.valueOf("2010-01-01"));
		Building building3 = new Building(3,"Norland Park","222 E 93rd Street","New York","NY","10128",10,1000000,Date.valueOf("2011-09-05"));
		Building building4 = new Building(4,"Pemberly","45 W 139tbuildingh Street","New York","NY","10037",12,3000000,Date.valueOf("2012-06-04"));
		Building building5 = new Building(5,"Churchill","480 Saint Nicholas Avenue","New York","NY","10030",8,1500000,Date.valueOf("2015-07-02"));	
		Building building6 = new Building(6,"Dashwood","500 E Houston Street","New York","NY","10002",6,7000000,Date.valueOf("2020-05-16"));
		Building building7 = new Building (7,"Barton","9 Saint James Place","Newark","NJ","07112",10,700000,Date.valueOf("2018-10-15"));	
		Building building8 = new Building(8,"Willoughby","206 Seymour Avenue","Newark","NJ","07108",10,500000,Date.valueOf("2010-11-11"));	
		Building building9 = new Building(9,"Wentworth","910 King Russ Road","Harrisburg","PA","17109",10,200000,Date.valueOf("2010-12-07"));	
		Building building10 = new Building(10,"Kellynch Hall","6985 New Oxford Rd","Harrisburg","PA","17112",2,150000,Date.valueOf("2019-3-05"));	
	
		BuildingServices services = new BuildingServices();
		
	services.addBuildingService(building1);
		services.addBuildingService(building2);
		services.addBuildingService(building3);
		services.addBuildingService(building4);
		services.addBuildingService(building5);
		services.addBuildingService(building6);
		services.addBuildingService(building7);
		services.addBuildingService(building8);
		services.addBuildingService(building9);
		services.addBuildingService(building10);
	
		
		ApartmentServices apartmentService = new ApartmentServices();
		Apartment apartment1 = new Apartment(1,building1,"1A",5,2,1.5,2500,true);
		Apartment apartment2 = new Apartment(2,building1,"1B",5,2,1.5,2500,true);
		Apartment apartment3 = new Apartment(3,building2,"1A",5,2,1.5,2500,true);
		Apartment apartment4 = new Apartment(4,building2,"1B",5,2,1.5,2500,true);
		Apartment apartment5 = new Apartment(5,building3,"1A",5,2,1.5,2500,true);
		Apartment apartment6 = new Apartment(6,building3,"1B",5,2,1.5,2500,true);
		Apartment apartment7 = new Apartment(7,building4,"1A",5,2,1.5,2500,true);
		Apartment apartment8 = new Apartment(8,building4,"1B",5,2,1.5,2500,true);
		Apartment apartment9 = new Apartment(9,building5,"1A",5,2,1.5,2500,true);
		Apartment apartment10 = new Apartment(10,building5,"1B",5,2,1.5,2500,true);
		
		//Apartment updateapartment1 = new Apartment(1,building1,"1A",6,3,2,3000,true);
		
		apartmentService.addApartmentService(apartment1);
		apartmentService.addApartmentService(apartment2);
		apartmentService.addApartmentService(apartment3);
		apartmentService.addApartmentService(apartment4);
		apartmentService.addApartmentService(apartment5);
		apartmentService.addApartmentService(apartment6);
		apartmentService.addApartmentService(apartment7);
		apartmentService.addApartmentService(apartment8);
		apartmentService.addApartmentService(apartment9);
		apartmentService.addApartmentService(apartment10);
	
		//apartmentService.deleteApartmentService(8);
		//apartmentService.getApartmentByIdServiceint(3);
		//apartmentService.showAllApartmentsByBuildingService(building3);
		//apartmentService.updateApartmentService(1, updateapartment1);

		
		Tenant tenant1 = new Tenant(1,apartment1,"Elinor","Dashwood","3238288840","e.dashwood@gmail.com",Date.valueOf("2020-01-01"),Date.valueOf("2020-12-31"));
		Tenant tenant2 = new Tenant(2,apartment2,"Colonel","Brandon","3238288841","c.Brandon@gmail.com",Date.valueOf("2020-01-02"),Date.valueOf("2020-12-31"));
		Tenant tenant3 = new Tenant(3,apartment3,"Edward","Ferars","3238288842","e.ferars@gmail.com",Date.valueOf("2020-01-03"),Date.valueOf("2020-12-31"));
		Tenant tenant4 = new Tenant(4,apartment4,"Eliza","Brandon","3238288843","e.brandon@gmail.com",Date.valueOf("2020-01-04"),Date.valueOf("2020-12-31"));
		Tenant tenant5 = new Tenant(5,apartment5,"Jane","Bennet","3238288844","j.bennet@gmail.com",Date.valueOf("2020-01-05"),Date.valueOf("2020-12-31"));
		Tenant tenant6 = new Tenant(6,apartment6,"Fitzwilliam","Darcy","3238288845","f.darcy@gmail.com",Date.valueOf("2020-01-06"),Date.valueOf("2020-12-31"));
		Tenant tenant7 = new Tenant(7,apartment7,"George","Wickham","3238288846","g.wickham@gmail.com",Date.valueOf("2020-01-07"),Date.valueOf("2020-12-31"));
		Tenant tenant8 = new Tenant(8,apartment8,"Fanny","Price","3238288847","f.price@gmail.com",Date.valueOf("2020-01-08"),Date.valueOf("2020-12-31"));
		Tenant tenant9 = new Tenant(9,apartment9,"Emma","Woodhouse","3238288848","e.woodhouse@gmail.com",Date.valueOf("2020-01-09"),Date.valueOf("2020-12-31"));
		Tenant tenant10 = new Tenant(10,apartment10,"Jane","Fairfax","3238288849","j.fairfax@gmail.com",Date.valueOf("2020-01-10"),Date.valueOf("2020-12-31"));
		
		
		
		
		
		
//		Tenant updatetenant1 = new Tenant(apartment1,"m","Lr","4238288840","b.loevinger@gmail.com",Date.valueOf("2021-01-01"),Date.valueOf("2022-12-31"));
		TenantServices tenantService = new TenantServices();
		tenantService.addTenantService(tenant1);
		tenantService.addTenantService(tenant2);
		tenantService.addTenantService(tenant3);
		tenantService.addTenantService(tenant4);
		tenantService.addTenantService(tenant5);
		tenantService.addTenantService(tenant6);
		tenantService.addTenantService(tenant7);
		tenantService.addTenantService(tenant8);
		tenantService.addTenantService(tenant9);
		tenantService.addTenantService(tenant10);
//		tenantService.deleteTenantService(tenant1.gettenantId());
//	tenantService.getTenantByIdService(3);
//	tenantService.showAllTenantsService();
		//tenantService.updateTenantService(4, updatetenant1);
	
		
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

		//		Invoice updateinvoice1 = new Invoice(tenant2,"Marches rent",1600.00,false);
		
		InvoiceServices invoiceService = new InvoiceServices();
		
		invoiceService.addInvoiceService(invoice1);
		invoiceService.addInvoiceService(invoice2);
		invoiceService.addInvoiceService(invoice3);
		invoiceService.addInvoiceService(invoice4);
		invoiceService.addInvoiceService(invoice5);
		invoiceService.addInvoiceService(invoice6);
		invoiceService.addInvoiceService(invoice7);
		invoiceService.addInvoiceService(invoice8);
		invoiceService.addInvoiceService(invoice9);
		invoiceService.addInvoiceService(invoice10);
		invoiceService.addInvoiceService(invoice11);
		invoiceService.addInvoiceService(invoice12);
		invoiceService.addInvoiceService(invoice13);
		invoiceService.addInvoiceService(invoice14);
		invoiceService.addInvoiceService(invoice15);
		invoiceService.addInvoiceService(invoice16);
		invoiceService.addInvoiceService(invoice17);
		invoiceService.addInvoiceService(invoice18);
		invoiceService.addInvoiceService(invoice19);
		invoiceService.addInvoiceService(invoice20);
		invoiceService.addInvoiceService(invoice21);
		invoiceService.addInvoiceService(invoice22);
		invoiceService.addInvoiceService(invoice23);
		invoiceService.addInvoiceService(invoice24);
		invoiceService.addInvoiceService(invoice25);
		invoiceService.addInvoiceService(invoice26);
		invoiceService.addInvoiceService(invoice27);
		invoiceService.addInvoiceService(invoice28);
		invoiceService.addInvoiceService(invoice29);
		invoiceService.addInvoiceService(invoice30);
	
		
		
//		invoiceService.deleteInvoiceService(1);
//	invoiceService.getInvoiceByIdService(5);
//	invoiceService.showAllInvoicesService();
		//invoiceService.updateInvoiceService(2, updateinvoice1);
		
		
		
		UserLogin userLogin1 = new UserLogin(tenant1,"valerieL","password",1);
		UserLogin userLogin2 = new UserLogin(tenant2,"valerieL1","password",1);
		UserLogin userLogin3 = new UserLogin(tenant3,"valerieL2","password",1);
		UserLogin userLogin4 = new UserLogin(tenant4,"valerieL3","password",1);
		UserLogin userLogin5 = new UserLogin(tenant5,"valerieL4","password",1);
		UserLogin userLogin6 = new UserLogin(null,"adminacct","adminacct",2);
	
		//UserLogin updateuserLogin1 = new UserLogin(tenant2,"Marches rent","hello",1);
		UserLoginServices userLoginService = new UserLoginServices();
		userLoginService.addUserLoginService(userLogin1);
		userLoginService.addUserLoginService(userLogin2);
		userLoginService.addUserLoginService(userLogin3);
		userLoginService.addUserLoginService(userLogin4);
		userLoginService.addUserLoginService(userLogin5);
		userLoginService.addUserLoginService(userLogin6);
//	userLoginService.deleteUserLoginService(1);
//	userLoginService.getUserLoginByIdService(5);
//	userLoginService.showAllUserLoginsService();
//		userLoginService.updateUserLoginService(5, updateuserLogin1);
	//userLoginService.validateUserSignUpService(tenant4, "hellofrom3", "password");
	//userLoginService.validateUserLoginService("Hellofrom3", "password");
		
		
	}
	
}
