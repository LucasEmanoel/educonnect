package br.com.educonnect.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educonnect.dados.RepositorioDisciplina;
import br.com.educonnect.negocio.basica.Disciplina;


@Service
public abstract class CadastroDisciplina implements ICadastroDisciplina {

	@Autowired
	private RepositorioDisciplina repoDis;

	@Override
	public Disciplina cadastrarDisciplina(Disciplina disciplina) throws HorarioIndisponivelException {
		List<Disciplina> disciplinas = repoDis.findByHorario(disciplina.getHorario());
		if (!disciplinas.isEmpty()) {
			throw new HorarioIndisponivelException();
		}
		return repoDis.save(disciplina);
	}

	@Override
	public Disciplina procurarDisciplinaId(long id) throws DisciplinaNaoExisteException {
		Disciplina dis = repoDis.findById(id).orElse(null);
		if (dis != null) {
			return dis;
		} else {
			throw new DisciplinaNaoExisteException();
		}
	}

	@Override
	public List<Disciplina> listarDisciplinas() {
		return repoDis.findAll();
	}

	@Override
	public void deletarDisciplinaId(Long id) {
		repoDis.deleteById(id);

	}

	@Override
	public Disciplina salvarDisciplina(Disciplina disciplina) {
		return repoDis.save(disciplina);
	}

	@Override
	public void deletarDisciplina(Disciplina disciplina) {
		repoDis.delete(disciplina);

	}

}
