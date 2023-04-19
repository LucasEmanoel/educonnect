package br.com.educonnect.negocio.cadastro;

import java.util.List;

import br.com.educonnect.negocio.basica.Matricula;

public interface ICadastroMatricula {
	Matricula procurarMatriculaId(long id);

	List<Matricula> listarMatriculas();

	void deletarMatriculaId(Long id);

	Matricula salvarMatricula(Matricula matricula);

	void deletarMatricula(Matricula matricula);

	// List<Matricula> listarMatriculasByIdDiscente(long idDis);
}
