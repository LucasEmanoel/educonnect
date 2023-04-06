package br.com.educonnect.negocio.cadastro;

public class DiscenteNaoExisteException extends Exception {

	private static final long serialVersionUID = 1L;
	public DiscenteNaoExisteException() {
		super("Discente nao cadastrado!!");
	}
}
