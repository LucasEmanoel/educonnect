package br.com.educonnect.negocio.cadastro;

import java.util.List;

import br.com.educonnect.dados.RepositorioDiscente;
import br.com.educonnect.negocio.basica.Discente;

public class CadastroDiscente {
	private RepositorioDiscente repositorioDiscente;

	public CadastroDiscente(RepositorioDiscente repositorioDiscente) {
		super();
		this.repositorioDiscente = repositorioDiscente;
	}
	
	public void createDiscente(Discente discente) {
		this.repositorioDiscente.createDiscente(discente);
	}
	public Discente searchByCod(String cod) {
		return this.searchByCod(cod);
	}
	public void removeDiscente(Discente discente) {
		this.repositorioDiscente.removeDiscente(discente);
	}
	public void updateDiscente(Discente discente) {
		this.repositorioDiscente.updateDiscente(discente);
	}
	public List<Discente> listDiscentes(){
		return this.repositorioDiscente.listDiscentes();
	}
	
	
}
