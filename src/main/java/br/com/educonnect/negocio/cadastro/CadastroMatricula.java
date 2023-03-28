package br.com.educonnect.negocio.cadastro;

import java.util.List;

import br.com.educonnect.dados.RepositorioMatricula;
import br.com.educonnect.negocio.basica.Matricula;

public class CadastroMatricula {
	private RepositorioMatricula repositorioMatricula;
	
	public CadastroMatricula(RepositorioMatricula repositorioMatricula) {
		super();
		this.repositorioMatricula = repositorioMatricula;
	}

	public void createDiscente(Matricula mat) {
		this.repositorioMatricula.createDiscente(mat);
	}
	
	public Matricula searchByCod(String cod) {
		return this.repositorioMatricula.searchByCod(cod);
	}
	
	public void removeDiscente(Matricula mat) {
		this.repositorioMatricula.removeDiscente(mat);
	}
	
	public void updateDiscente(Matricula mat) {
		this.updateDiscente(mat);
	}
	
	public List<Matricula> listDiscentes(){
		return this.repositorioMatricula.listDiscentes();
	}
	
	
}
