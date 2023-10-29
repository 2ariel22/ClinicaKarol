package co.com.clinicaKarol.test;

import java.util.List;

import javax.persistence.EntityManager;

import co.com.clinicaKarol.DAO.PacienteDao;
import co.com.clinicaKarol.entityFactory.Factory;
import co.com.clinicaKarol.modelo.Paciente;



public class Busquedatest {
	public static void main(String[] args) {
		EntityManager em = Factory.crearCon();
		PacienteDao xd = new PacienteDao(em);
		
		//Paciente ola = xd.BuscarId("1193585434"); 
		//List<Paciente> pacientes1 = xd.BuscarAll();
		//System.out.println(ola.getNOMBRE_APELLIDO());
		
		List<Paciente> lista = xd.BuscarAll();
		
		lista.forEach(pacient -> System.out.println(pacient.getNOMBRE_APELLIDO()));
		
		
	}
	
	
	
	

}
