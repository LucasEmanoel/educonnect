package br.com.educonnect.negocio.cadastro;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educonnect.dados.RepositorioDiscente;
import br.com.educonnect.negocio.basica.Discente;


@Service
public class CadastroDiscente implements ICadastroDiscente {
	
	@Autowired
	private RepositorioDiscente repositorioDiscente;

	public CadastroDiscente(RepositorioDiscente repositorioDiscente) {
		super();
		this.repositorioDiscente = repositorioDiscente;
	}

	@Override
	public Discente procurarDiscenteId(long id) {
		return this.repositorioDiscente.findById(id).orElse(null);
	}

	@Override
	public List<Discente> listarDiscentes() {
		return this.repositorioDiscente.findAll();
	}

	@Override
	public void deletarDiscenteId(Long id) {
		this.repositorioDiscente.deleteById(id);;
		
	}

	@Override
	public Discente salvarDiscente(Discente discente) {
		return this.repositorioDiscente.save(discente);
	}

	@Override
	public void deletarDiscente(Discente discente) {
		this.repositorioDiscente.delete(discente);
		
	}
	
	
}
