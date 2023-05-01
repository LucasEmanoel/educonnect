package br.com.educonnect.negocio.cadastro;

public class CursoNaoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;

	public CursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}

