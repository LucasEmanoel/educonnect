package br.com.educonnect.negocio.cadastro;

import java.util.List;

import br.com.educonnect.negocio.basica.Discente;
import br.com.educonnect.negocio.basica.Pessoa;

public interface ICadastroDiscente {

	Discente procurarDiscenteId(long id) throws DiscenteNaoExisteException;

	List<Discente> listarDiscentes();

	void deletarDiscenteId(Long id);

	Discente salvarDiscente(Discente discente) throws DiscenteEmailIgualException;
	
	void deletarDiscente(Discente discente);

	Discente procurarDiscenteEmail(String email) throws DiscenteNaoExisteException;

	Discente salvarDiscenteSemException(Discente discente);
	
	List<String> listarDiscentesPorIdTurma(long id);
}
