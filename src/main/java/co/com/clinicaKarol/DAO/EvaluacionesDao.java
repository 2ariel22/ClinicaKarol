package co.com.clinicaKarol.DAO;

import javax.persistence.EntityManager;

import co.com.clinicaKarol.modelo.Evaluaciones;
import co.com.clinicaKarol.modelo.Paciente;

public class EvaluacionesDao {
	
	private EntityManager em;
	
	
	public EvaluacionesDao(EntityManager em) {
		this.em = em;
	}


	public void Guardar(Evaluaciones paciente) {
		em.persist(paciente);
	}
}
