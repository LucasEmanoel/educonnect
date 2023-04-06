package br.com.educonnect.negocio.fachada;

import br.com.educonnect.negocio.basica.Turma;

public class MatriculaIgualException extends Exception{
	//pesquisar o uso
	private static final long serialVersionUID = 1L;
	
	private Turma turma;
	//private Disciplina disciplina;
	

	public MatriculaIgualException(Turma turma) {
		super("Nao podemos matricular duas vezes na mesma disciplina");
		this.turma = turma;
		//this.disciplina = disciplina;
	}
}
