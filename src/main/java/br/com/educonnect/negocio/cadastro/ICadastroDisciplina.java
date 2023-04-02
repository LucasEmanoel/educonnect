package br.com.educonnect.negocio.cadastro;

import java.util.List;

import br.com.educonnect.negocio.basica.Disciplina;

public interface ICadastroDisciplina {
	Disciplina procurarDisciplinaId(long id);

	List<Disciplina> listarDisciplinas();

	void deletarDisciplinaId(Long id);

	Disciplina salvarDisciplina(Disciplina disciplina);

	void deletarDisciplina(Disciplina disciplina);
}
