package co.com.clinicaKarol.test;


import javax.persistence.EntityManager;

import co.com.clinicaKarol.DAO.PacienteDao;
import co.com.clinicaKarol.entityFactory.Factory;
import co.com.clinicaKarol.modelo.Paciente;


public class Addtest {
	public static void main(String[] args) {
		
		 Paciente paciente = new Paciente("1193585434","Ariel Yance",19,"3146928950","Ariel Yance",
				 "le duele la panza");
		 
		 EntityManager em = Factory.crearCon();
		 
		 PacienteDao pacienteDao = new PacienteDao(em);
		 
		 em.getTransaction().begin();	 
		 pacienteDao.Guardar(paciente);
		 
		 em.getTransaction().commit();// cambios permanentes
		 em.close();// cierra la conexion
	}
}
