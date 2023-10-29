package co.com.clinicaKarol.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import co.com.clinicaKarol.modelo.Paciente;



public class PacienteDao {

	private EntityManager em;

	public PacienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void Guardar(Paciente paciente) {
		em.persist(paciente);
	}
	
	public Paciente BuscarId(String documento) {
		return this.em.find(Paciente.class, documento);
	}
	public List<Paciente> BuscarAll(){
		String jqpl = "SELECT P FROM Paciente AS P";
		return this.em.createQuery(jqpl,Paciente.class).getResultList();
	}
	

	public List<Paciente> BuscarNombre(String nombre) {
	    String jpql = "SELECT P FROM Modelo AS P WHERE P.nombre = :nombre";
	    return em.createQuery(jpql, Paciente.class)
	             .setParameter("nombre", nombre)
	             .getResultList();
	}
	
}
