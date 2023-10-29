package co.com.clinicaKarol.modelo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pacientes")
public class Paciente {
	@Override
	public String toString() {
		return "Paciente [DOCUMENTO=" + DOCUMENTO + ", NOMBRE_APELLIDO=" + NOMBRE_APELLIDO + ", EDAD=" + EDAD
				+ ", TELEFONO=" + TELEFONO + ", date=" + date + ", FONOAUDIOLOGO=" + FONOAUDIOLOGO + ", DIAGNOSTICO="
				+ DIAGNOSTICO + "]";
	}


	@Id
	private String DOCUMENTO;
	private String NOMBRE_APELLIDO;
	private int EDAD;
	private String TELEFONO;
	private LocalDate date = LocalDate.now();
	private String FONOAUDIOLOGO;
	private String DIAGNOSTICO;
	@OneToMany
	@JoinTable(
		    name = "evaluaciones", // Nombre de la tabla existente en la base de datos
		    inverseJoinColumns = @JoinColumn(name = "ID_DOC") // Nombre de la columna en la tabla "evaluaciones" que se relaciona con "Evaluaciones"
		)
	private List<Evaluaciones> evaluaciones = new ArrayList<>();


	
	


	public Paciente() {
	
	}


	public Paciente(String dOCUMENTO, String nOMBRE_APELLIDO, int eDAD, String tELEFONO, String fONOAUDIOLOGO,
			String dIAGNOSTICO) {
		
		DOCUMENTO = dOCUMENTO;
		NOMBRE_APELLIDO = nOMBRE_APELLIDO;
		EDAD = eDAD;
		TELEFONO = tELEFONO;
		FONOAUDIOLOGO = fONOAUDIOLOGO;
		DIAGNOSTICO = dIAGNOSTICO;
	}


	public String getDOCUMENTO() {
		return DOCUMENTO;
	}


	public void setDOCUMENTO(String dOCUMENTO) {
		DOCUMENTO = dOCUMENTO;
	}


	public String getNOMBRE_APELLIDO() {
		return NOMBRE_APELLIDO;
	}


	public void setNOMBRE_APELLIDO(String nOMBRE_APELLIDO) {
		NOMBRE_APELLIDO = nOMBRE_APELLIDO;
	}


	public int getEDAD() {
		return EDAD;
	}


	public void setEDAD(int eDAD) {
		EDAD = eDAD;
	}


	public String getTELEFONO() {
		return TELEFONO;
	}


	public void setTELEFONO(String tELEFONO) {
		TELEFONO = tELEFONO;
	}


	public String getFONOAUDIOLOGO() {
		return FONOAUDIOLOGO;
	}


	public void setFONOAUDIOLOGO(String fONOAUDIOLOGO) {
		FONOAUDIOLOGO = fONOAUDIOLOGO;
	}


	public String getDIAGNOSTICO() {
		return DIAGNOSTICO;
	}


	public void setDIAGNOSTICO(String dIAGNOSTICO) {
		DIAGNOSTICO = dIAGNOSTICO;
	}


	public List<Evaluaciones> getEvaluaciones() {
		return evaluaciones;
	}


	public void setEvaluaciones(ArrayList<Evaluaciones> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}


	public LocalDate getDate() {
		return date;
	}



	
	
	
	
	
	

}
