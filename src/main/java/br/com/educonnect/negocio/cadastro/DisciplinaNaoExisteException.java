package br.com.educonnect.negocio.cadastro;

public class DisciplinaNaoExisteException extends Exception {

	private static final long serialVersionUID = 1L;
	public DisciplinaNaoExisteException() {
		super("Disciplina nao cadastrada!!");
	}
}
