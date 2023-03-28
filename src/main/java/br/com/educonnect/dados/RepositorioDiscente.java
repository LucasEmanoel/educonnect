package br.com.educonnect.dados;

import java.util.List;

import br.com.educonnect.negocio.basica.Discente;

public interface RepositorioDiscente {
	
	void createDiscente(Discente discente);
	Discente searchByCod(String cod);
	void removeDiscente(Discente discente);
	void updateDiscente(Discente discente);
	List<Discente> listDiscentes();
}
