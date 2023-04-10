package br.com.educonnect.negocio.cadastro;

import java.util.List;

import br.com.educonnect.negocio.basica.Disciplina;
import br.com.educonnect.negocio.basica.Matricula;

public interface ICadastroDisciplina {
	Disciplina procurarDisciplinaId(long id) throws DisciplinaNaoExisteException;

	List<Disciplina> listarDisciplinas();

	void deletarDisciplinaId(Long id);

	Disciplina salvarDisciplina(Disciplina disciplina);

	void deletarDisciplina(Disciplina disciplina);
}
