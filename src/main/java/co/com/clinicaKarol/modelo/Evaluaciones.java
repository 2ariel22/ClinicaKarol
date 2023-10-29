package co.com.clinicaKarol.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="evaluaciones")
public class Evaluaciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_DOC;
	private String DATOS;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Paciente paciente; // Debe coincidir con el nombre en la clase Paciente


	
	public Evaluaciones() {
		
	}
	public Evaluaciones(String datos, Paciente evaluacion) {
		this.DATOS = datos;
		this.paciente = evaluacion;
		
	}
	
	public String getDatos() {
		return DATOS;
	}
	public void setDatos(String datos) {
		this.DATOS = datos;
	}

	
	
	
}
