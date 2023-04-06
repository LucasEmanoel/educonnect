package br.com.educonnect.negocio.fachada;

import br.com.educonnect.negocio.basica.Disciplina;

public class TurmaIgualException extends Exception{
	//pesquisar o uso
	private static final long serialVersionUID = 1L;
		
	private Disciplina disciplina;

	public TurmaIgualException(Disciplina disciplina) {
		super("Disciplina ja ofertada");
		this.disciplina = disciplina;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}
	
}
