package br.com.educonnect.negocio.cadastro;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educonnect.dados.RepositorioMatricula;
import br.com.educonnect.negocio.basica.Discente;
import br.com.educonnect.negocio.basica.Matricula;


@Service
public class CadastroMatricula implements ICadastroMatricula{
	
	@Autowired
	private RepositorioMatricula repositorioMatricula;
	
	public CadastroMatricula(RepositorioMatricula repositorioMatricula) {
		super();
		this.repositorioMatricula = repositorioMatricula;
	}

	@Override
	public Matricula procurarMatriculaId(long id) {
		return this.repositorioMatricula.findById(id).orElse(null);
	}

	@Override
	public List<Matricula> listarMatriculas() {
		return this.repositorioMatricula.findAll();
	}

	@Override
	public void deletarMatriculaId(Long id) {
		this.repositorioMatricula.deleteById(id);
		
	}

	@Override
	public Matricula salvarMatricula(Matricula matricula) {
		return this.repositorioMatricula.save(matricula);
	}

	@Override
	public void deletarMatricula(Matricula matricula) {
		this.repositorioMatricula.delete(matricula);
		
	}

	/*@Override
	public List<Matricula> listarMatriculasByIdDiscente(long idDis) {
		return this.repositorioMatricula.findAllByDiscente(idDis);
	}*/	
	
}
