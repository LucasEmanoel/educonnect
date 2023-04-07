package br.com.educonnect.negocio.fachada;

public class TurmaNaoExisteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TurmaNaoExisteException() {
		super("Turma nao cadastrada!!");
	}
}
