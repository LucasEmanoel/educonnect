package br.com.educonnect.negocio.cadastro;

import java.util.List;

import br.com.educonnect.negocio.basica.Disciplina;

public interface ICadastroDisciplina {
	Disciplina cadastrarDisciplina(long id, String nome);
	Disciplina procurarDisciplinaId(long id) throws DisciplinaNaoExisteException;

	List<Disciplina> listarDisciplinas();

	void deletarDisciplinaId(Long id);

	Disciplina salvarDisciplina(Disciplina disciplina);

	void deletarDisciplina(Disciplina disciplina);

	Disciplina cadastrarDisciplina(Disciplina disciplina) throws HorarioIndisponivelException;
}
