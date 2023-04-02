package br.com.educonnect.negocio.basica;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Matricula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date data;
	private int semestre;
	
	//nao deletar disciplina com cascade
	@OneToOne
	private Turma turma;
	
	
	public Matricula() {
		super();
	}
	
	public Matricula(Date data, int semestre, Horario horario, Turma turma) {
		super();
		this.data = data;
		this.semestre = semestre;
		this.turma = turma;
	}

	

	public Matricula(int semestre, Turma turma) {
		super();
		this.semestre = semestre;
		this.turma = turma;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(turma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		return Objects.equals(turma, other.turma);
	}
	
	
}
