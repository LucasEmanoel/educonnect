package br.com.educonnect.dados;

import java.util.List;

import br.com.educonnect.negocio.basica.Matricula;

public interface RepositorioMatricula {
	
	void createDiscente(Matricula mat);
	Matricula searchByCod(String cod);
	void removeDiscente(Matricula mat);
	void updateDiscente(Matricula mat);
	List<Matricula> listDiscentes();
}
