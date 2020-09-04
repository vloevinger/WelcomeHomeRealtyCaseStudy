package com.welcomeHomeRealtyCaseStudy.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ApartmentDAOTest.class, BuildingDAOTest.class, InvoiceDAOTest.class, TenantDAOTest.class,
		UserLoginDAOTest.class })
public class CaseStudyAllTests {
	public static void main(String[] args) {
		
	}

}
