package br.com.educonnect.negocio.basica;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Discente extends Pessoa{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToMany
	private List<Matricula> matriculas;
	
	
	public Discente() {
		super();
	}
	
	/*public void solicitarMatricula(int semestre, Disciplina dis) throws MatriculaIgualException {
		//Matricula mat = new Matricula(semestre, dis);
		
		if(!matriculas.contains(mat)) {
			this.matriculas.add(mat);
		} else {
			//MatriculaIgualException ex = new MatriculaIgualException(semestre, dis);
			//throw ex;
		}
	}*/
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
}
