package com.welcomeHomeRealty.dbConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnection {
	protected String persistenceUnitName = "CaseStudy";
	protected EntityManagerFactory emf =null;
	protected EntityManager em = null;
	
	public void connect() {
		try {
			emf = Persistence.createEntityManagerFactory(persistenceUnitName);
			em = emf.createEntityManager();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			em.close();
			emf.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
