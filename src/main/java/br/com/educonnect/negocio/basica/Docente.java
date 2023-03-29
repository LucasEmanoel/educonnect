package br.com.educonnect.negocio.basica;

import java.util.List;

import br.com.educonnect.negocio.exception.MatriculaIgualException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Docente extends Pessoa{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private long id;
	
	@OneToMany
	private List<Matricula> matriculas;
	
	public Docente() {
		super();
	}
	

	public void solicitarMatricula(int semestre, Disciplina dis) throws MatriculaIgualException {
		Matricula mat = new Matricula(semestre, dis);
		
		if(!matriculas.contains(mat)) {
			this.matriculas.add(mat);
		} else {
			MatriculaIgualException ex = new MatriculaIgualException(semestre, dis);
			throw ex;
		}
	}
	
}
