package br.com.educonnect.negocio.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educonnect.negocio.basica.Discente;
import br.com.educonnect.negocio.basica.Matricula;
import br.com.educonnect.negocio.cadastro.ICadastroDiscente;
import br.com.educonnect.negocio.cadastro.ICadastroMatricula;

@Service
public class Fachada {
	@Autowired
	private ICadastroDiscente cadastroDiscente;
	@Autowired
	private ICadastroMatricula cadastroMatricula;
	
	public Discente procurarDiscenteId(long id) {
		return this.cadastroDiscente.procurarDiscenteId(id);
	}
	public List<Discente> listarDiscentes(){
		return this.cadastroDiscente.listarDiscentes();
	}			
	public void deletarDiscenteId(Long id) {
		this.cadastroDiscente.deletarDiscenteId(id);
	}
	public Discente salvarDiscente(Discente discente) {
		return this.cadastroDiscente.salvarDiscente(discente);
	}
	public void deletarDiscente(Discente discente) {
		this.cadastroDiscente.deletarDiscente(discente);
	}	
	public Matricula procurarMatriculaId(long id) {
		return this.cadastroMatricula.procurarMatriculaId(id);
	}
	public List<Matricula> listarMatriculas(){
		return this.cadastroMatricula.listarMatriculas();
	}
	public void deletarMatriculaId(Long id) {
		this.cadastroMatricula.deletarMatriculaId(id);
	}
	public Matricula salvarMatricula(Matricula matricula) {
		return this.cadastroMatricula.salvarMatricula(matricula);
		}
	public void deletarMatricula(Matricula matricula) {
		this.cadastroMatricula.deletarMatricula(matricula);
	}
	
	
}
