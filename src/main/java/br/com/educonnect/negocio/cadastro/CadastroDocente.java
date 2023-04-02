package br.com.educonnect.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educonnect.dados.RepositorioDocente;
import br.com.educonnect.negocio.basica.Docente;


@Service
public class CadastroDocente implements ICadastroDocente{

	@Autowired
	private RepositorioDocente repoDis;
	
	@Override
	public Docente procurarDocenteId(long id) throws DocenteNaoExisteException {
		Docente doc = this.repoDis.findById(id).orElse(null);
		
		if(doc != null) {
			return doc;
		} else {
			throw new DocenteNaoExisteException();
		}
	}

	@Override
	public List<Docente> listarDocentes() {
		// TODO Auto-generated method stub
		return repoDis.findAll();
	}

	@Override
	public void deletarDocenteId(Long id) {
		repoDis.deleteById(id);
		
	}

	@Override
	public Docente salvarDocente(Docente docente) {
		// TODO Auto-generated method stub
		return repoDis.save(docente);
	}

	@Override
	public void deletarDocente(Docente docente) {
		repoDis.delete(docente);
		
	}
	
	
	

}
