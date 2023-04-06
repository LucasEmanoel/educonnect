package br.com.educonnect.negocio.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coordenador extends Docente{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//@OneToOne
	//private Curso curso
	
	public Coordenador() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
