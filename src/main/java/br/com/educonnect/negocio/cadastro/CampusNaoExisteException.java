package br.com.educonnect.negocio.cadastro;

public class CampusNaoExisteException extends Exception {

    private static final long serialVersionUID = 1L;

	public CampusNaoExisteException() {
        super("Campus não existe");
    }

}
