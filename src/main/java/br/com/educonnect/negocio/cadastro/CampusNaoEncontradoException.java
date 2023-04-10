package br.com.educonnect.negocio.cadastro;

public class CampusNaoEncontradoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CampusNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

}

