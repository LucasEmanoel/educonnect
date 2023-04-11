package br.com.educonnect.negocio.cadastro;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educonnect.dados.RepositorioUniversidade;
import br.com.educonnect.negocio.basica.Universidade;

@Service
public class CadastroUniversidade implements ICadastroUniversidade {

	@Autowired
	private RepositorioUniversidade repositorioUniversidade;

	@Override
	public Universidade cadastrarUniversidade(Universidade universidade) throws UniversidadeJaExisteException {
		Optional<Universidade> uni = this.repositorioUniversidade.findById(null);
		if (uni != null) {
			throw new UniversidadeJaExisteException();
		} else {
			return this.repositorioUniversidade.save(universidade);
		}
	}

	@Override
	public Universidade getUniversidade(Long id) {
		return this.repositorioUniversidade.findById(id).orElse(null);
	}

	@Override
	public void setUniversidade(Universidade universidade) {
		this.repositorioUniversidade.save(universidade);
	}

	@Override
	public void removerUniversidade(Long id) {
		this.repositorioUniversidade.deleteById(id);
	}

}
