package br.com.educonnect.negocio.basica;


import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Horario {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private Time horario;
	
	
	public Horario() {
		super();
	}
	public Horario(Time horario) {
		super();
		this.horario = horario;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Time getHorario() {
		return horario;
	}
	public void setHorario(Time horario) {
		this.horario = horario;
	}
}
