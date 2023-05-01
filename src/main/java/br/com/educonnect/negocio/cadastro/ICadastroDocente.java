package br.com.educonnect.negocio.cadastro;

import java.util.List;

import br.com.educonnect.negocio.basica.Docente;

public interface ICadastroDocente {
	
	
	Docente procurarDocenteId(long id) throws DocenteNaoExisteException;

	List<Docente> listarDocentes();

	void deletarDocenteId(Long id);

	Docente salvarDocente(Docente Docente);

	void deletarDocente(Docente Docente);
}
