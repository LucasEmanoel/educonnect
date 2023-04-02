package br.com.educonnect.negocio.cadastro;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educonnect.dados.RepositorioDiscente;
import br.com.educonnect.negocio.basica.Discente;
import br.com.educonnect.negocio.basica.Matricula;


@Service
public class CadastroDiscente implements ICadastroDiscente {
	
	@Autowired
	private RepositorioDiscente repositorioDiscente;

	public CadastroDiscente(RepositorioDiscente repositorioDiscente) {
		super();
		
		this.repositorioDiscente = repositorioDiscente;
	}

	@Override
	public Discente procurarDiscenteId(long id) throws DiscenteNaoExisteException {
		Discente dis = this.repositorioDiscente.findById(id).orElse(null);
		if(dis != null) {
			return dis;
		}else {
			throw new DiscenteNaoExisteException();
		}
		
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
	public Discente salvarDiscente(Discente discente) throws DiscenteEmailIgualException {
		Discente dis = this.repositorioDiscente.findByEmail(discente.getEmail());
		//Discente dis = this.procurarDiscenteEmail(discente.getEmail());
		
		if(dis == null) {
			return this.repositorioDiscente.save(discente);
		}
		DiscenteEmailIgualException ex = new DiscenteEmailIgualException(discente.getEmail());
		throw ex;
		
	}
	//when i need update discente
	@Override
	public Discente salvarDiscenteSemException(Discente discente) {
		return this.repositorioDiscente.save(discente);
	}
	
	@Override
	public void deletarDiscente(Discente discente) {
		this.repositorioDiscente.delete(discente);
		
	}

	@Override
	public Discente procurarDiscenteEmail(String email) throws DiscenteNaoExisteException {
		Discente dis = this.repositorioDiscente.findByEmail(email);
		if(dis != null) {
			return dis;
		}else {
			throw new DiscenteNaoExisteException();
		}
	}


	
	
}
