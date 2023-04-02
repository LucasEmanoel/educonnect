package br.com.educonnect.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educonnect.dados.RepositorioDisciplina;
import br.com.educonnect.negocio.basica.Disciplina;


@Service
public class CadastroDisciplina implements ICadastroDisciplina{

	@Autowired
	private RepositorioDisciplina repoDis;
	
	@Override
	public Disciplina procurarDisciplinaId(long id) {
		// TODO Auto-generated method stub
		return repoDis.findById(id).orElse(null);
	}

	@Override
	public List<Disciplina> listarDisciplinas() {
		// TODO Auto-generated method stub
		return repoDis.findAll();
	}

	@Override
	public void deletarDisciplinaId(Long id) {
		repoDis.deleteById(id);
		
	}

	@Override
	public Disciplina salvarDisciplina(Disciplina disciplina) {
		// TODO Auto-generated method stub
		return repoDis.save(disciplina);
	}

	@Override
	public void deletarDisciplina(Disciplina disciplina) {
		repoDis.delete(disciplina);
		
	}

}
