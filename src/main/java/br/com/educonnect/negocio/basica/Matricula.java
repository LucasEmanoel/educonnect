package br.com.educonnect.negocio.basica;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.CascadeType;
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
	@Column(unique = true, nullable = false)
	private long id;
	
	private Date data;
	private int semestre;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Horario horario;
	
	//nao deletar disciplina com cascade
	@OneToOne
	private Disciplina disciplina;
	
	public Matricula() {
		super();
	}
	
	public Matricula(Date data, int semestre, Horario horario, Disciplina disciplina) {
		super();
		this.data = data;
		this.semestre = semestre;
		this.horario = horario;
		this.disciplina = disciplina;
	}

	

	public Matricula(int semestre, Disciplina disciplina) {
		super();
		this.semestre = semestre;
		this.disciplina = disciplina;
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
	public Horario getHorario() {
		return horario;
	}
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(disciplina, semestre);
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
		return Objects.equals(disciplina, other.disciplina) && semestre == other.semestre;
	}
	
	
}
