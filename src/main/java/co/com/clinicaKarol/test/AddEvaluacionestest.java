package co.com.clinicaKarol.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import co.com.clinicaKarol.DAO.EvaluacionesDao;
import co.com.clinicaKarol.DAO.PacienteDao;
import co.com.clinicaKarol.entityFactory.Factory;
import co.com.clinicaKarol.modelo.Evaluaciones;
import co.com.clinicaKarol.modelo.Paciente;

public class AddEvaluacionestest {
	public static void main(String[] args) {
		EntityManager em = Factory.crearCon();
		 
		PacienteDao xd = new PacienteDao(em);
		
		Paciente ola = xd.BuscarId("123456789"); 
		
		 String[] elementosEvaluaciones = ola.getEvaluaciones().get(0).getDatos().split(",");
         List<String> listaDeDatosEvaluaciones = new ArrayList<>(Arrays.asList(elementosEvaluaciones));

		//System.out.println(ola.getEvaluaciones())
		System.out.println(listaDeDatosEvaluaciones);
	
		//Evaluaciones evaluaciones = new Evaluaciones("1,2,3,4,5,6,10,1",ola);
		 //EvaluacionesDao evaluacionesDao = new EvaluacionesDao(em);
		 
		 //em.getTransaction().begin();	
		 //evaluacionesDao.Guardar(evaluaciones);
		 
		 //em.getTransaction().commit();// cambios permanentes
		 //em.close();// cierra la conexion
	}
}
