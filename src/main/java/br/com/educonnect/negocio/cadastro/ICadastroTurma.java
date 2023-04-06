package br.com.educonnect.negocio.cadastro;

import java.util.List;

import br.com.educonnect.negocio.basica.Turma;

public interface ICadastroTurma {
	
	Turma procurarTurmaId(long id) throws TurmaNaoExisteException;

	List<Turma> listarTurmas();
	List<Turma> listarTurmasDocente(long id);
	
	void deletarTurmaId(Long id);

	Turma salvarTurma(Turma turma);

	void deletarTurma(Turma turma);
}
