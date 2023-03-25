package br.com.educonnect.negocio;

import br.com.educonnect.negocio.basica.Disciplina;

public class MatriculaIgualException extends Exception{
	//pesquisar o uso
	private static final long serialVersionUID = 1L;
	
	private int semestre;
	private Disciplina disciplina;
	

	public MatriculaIgualException(int semestre, Disciplina disciplina) {
		super("Nao podemos matricular duas vezes na mesma disciplina");
		this.semestre = semestre;
		this.disciplina = disciplina;
	}

	public int getSemestre() {
		return semestre;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

}
