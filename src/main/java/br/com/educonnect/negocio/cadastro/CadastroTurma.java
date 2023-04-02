package br.com.educonnect.negocio.cadastro;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educonnect.dados.RepositorioTurma;
import br.com.educonnect.negocio.basica.Turma;


@Service
public class CadastroTurma implements ICadastroTurma{
	
	@Autowired
	private RepositorioTurma repositorioTurma;
	
	public CadastroTurma(RepositorioTurma repositorioTurma) {
		super();
		this.repositorioTurma = repositorioTurma;
	}

	@Override
	public Turma procurarTurmaId(long id) throws TurmaNaoExisteException {
		Turma turma = this.repositorioTurma.findById(id).orElse(null);
		if(turma != null) {
			return turma;
		}else {
			throw new TurmaNaoExisteException();
		}

	}

	@Override
	public List<Turma> listarTurmas() {
		return this.repositorioTurma.findAll();
	}

	@Override
	public void deletarTurmaId(Long id) {
		this.repositorioTurma.deleteById(id);
		
	}

	@Override
	public Turma salvarTurma(Turma Turma) {
		return this.repositorioTurma.save(Turma);
	}

	@Override
	public void deletarTurma(Turma Turma) {
		this.repositorioTurma.delete(Turma);
		
	}

	@Override
	public List<Turma> listarTurmasDocente(long id) {
		return null;
	}	
	
}
