package br.com.educonnect.negocio.cadastro;

public class DiscenteEmailIgualException extends Exception{

	private static final long serialVersionUID = 1L;
	private String email;
	
	
	public DiscenteEmailIgualException(String email) {
		super("Este email ja esta cadastrado!!");
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}
