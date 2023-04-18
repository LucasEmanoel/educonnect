package br.com.educonnect.negocio.cadastro;

public class UniversidadeNaoExisteException extends Exception {
	private static final long serialVersionUID = 1L;

	public UniversidadeNaoExisteException() {
		super("Universidade não já existe!");
	}

}
