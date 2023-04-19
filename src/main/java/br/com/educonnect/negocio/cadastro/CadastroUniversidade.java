package br.com.educonnect.negocio.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educonnect.dados.RepositorioUniversidade;
import br.com.educonnect.negocio.basica.Universidade;

@Service
public class CadastroUniversidade implements ICadastroUniversidade {

	@Autowired
	private RepositorioUniversidade repositorioUniversidade;
	
	public CadastroUniversidade(RepositorioUniversidade repositorioUniversidade) {
		super();
		
		this.repositorioUniversidade = repositorioUniversidade;
	}
	
	@Override
	public Universidade encontrarUniversidadeId(long id) throws UniversidadeNaoExisteException{
		Universidade universidade = this.repositorioUniversidade.findById(id).orElse(null);
		if(universidade != null) {
			return universidade;
		}else {
			throw new UniversidadeNaoExisteException();
		}
	}
	
	@Override
	public List<Universidade> listarUniversidade(){
		return this.repositorioUniversidade.findAll();
	} 
	
	@Override
	public void deletarUniversidadeId(long id) {
		this.repositorioUniversidade.deleteById(id);
	}
	
	@Override
	public Universidade salvarUniversidade(Universidade universidade) {
		return this.repositorioUniversidade.save(universidade);
	}
	
	@Override
	public Universidade atualizarUniversidade(Universidade universidade, long id) throws UniversidadeNaoExisteException{
		Universidade universidadeAntiga = this.encontrarUniversidadeId(id);
		universidadeAntiga.setNome(universidade.getNome());
		return this.repositorioUniversidade.save(universidadeAntiga);
	}

}
