package co.com.clinicaKarol.entityFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {
	private static EntityManagerFactory fact = Persistence.createEntityManagerFactory("clinicakarol");
		
	public static EntityManager crearCon() {
		return fact.createEntityManager();
	}
	
}
