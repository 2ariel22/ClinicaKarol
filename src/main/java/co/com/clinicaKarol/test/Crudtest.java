package co.com.clinicaKarol.test;

import java.util.List;

import javax.persistence.EntityManager;

import co.com.clinicaKarol.DAO.PacienteDao;
import co.com.clinicaKarol.entityFactory.Factory;
import co.com.clinicaKarol.modelo.Paciente;


public class Crudtest {

	public static void main(String[] args) {
		EntityManager em = Factory.crearCon();
		PacienteDao xd = new PacienteDao(em);
		Paciente ola = xd.BuscarId(""); 
		System.out.println(ola.getDOCUMENTO());
		
		List<Paciente> lista = xd.BuscarAll();
		
		//lista.forEach(produc -> System.out.println(produc.getDescripcion()));
		
		//List<Modelo> lista2 = xd.BuscarCategoria("monas chinas");
		
		//lista2.forEach(produc -> System.out.println(produc.getNombre()));
		
		//System.out.println(xd.BuscarPrecioPorNombre("jeanne"));
		
	}
}
