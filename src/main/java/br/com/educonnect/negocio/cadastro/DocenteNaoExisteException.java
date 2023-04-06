package br.com.educonnect.negocio.cadastro;

public class DocenteNaoExisteException extends Exception {

	private static final long serialVersionUID = 1L;
	public DocenteNaoExisteException() {
		super("Docente nao cadastrado!!");
	}
}
