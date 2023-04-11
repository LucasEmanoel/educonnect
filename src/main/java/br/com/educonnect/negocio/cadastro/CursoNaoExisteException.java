package br.com.educonnect.negocio.cadastro;

public class CursoNaoExisteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CursoNaoExisteException() {
        super("Curso não Existe");
    }

}

