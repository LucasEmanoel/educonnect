package br.com.educonnect.negocio.cadastro;

public class UniversidadeJaExisteException extends Exception {
	private static final long serialVersionUID = 1L;

	public UniversidadeJaExisteException() {
		super("Universidade já existe");
	}

}
