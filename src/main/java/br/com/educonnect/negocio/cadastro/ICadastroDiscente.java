package br.com.educonnect.negocio.cadastro;

import java.util.List;

import br.com.educonnect.negocio.basica.Discente;

public interface ICadastroDiscente {

	Discente procurarDiscenteId(long id);

	List<Discente> listarDiscentes();

	void deletarDiscenteId(Long id);

	Discente salvarDiscente(Discente discente) throws DiscenteEmailIgualException;

	void deletarDiscente(Discente discente);

	Discente procurarDiscenteEmail(String email);
}
