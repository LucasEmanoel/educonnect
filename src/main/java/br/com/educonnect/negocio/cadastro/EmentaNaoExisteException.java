package br.com.educonnect.negocio.cadastro;

public class EmentaNaoExisteException extends Exception {

    private static final long serialVersionUID = 1L;

    public EmentaNaoExisteException() {
        super("Ementa não existe.");
    }

    public EmentaNaoExisteException(String mensagem) {
        super(mensagem);
    }

}

