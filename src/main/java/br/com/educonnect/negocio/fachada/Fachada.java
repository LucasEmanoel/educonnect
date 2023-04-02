package br.com.educonnect.negocio.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educonnect.negocio.basica.Discente;
import br.com.educonnect.negocio.basica.Disciplina;
import br.com.educonnect.negocio.basica.Docente;
import br.com.educonnect.negocio.basica.Matricula;
import br.com.educonnect.negocio.cadastro.DiscenteEmailIgualException;
import br.com.educonnect.negocio.cadastro.ICadastroDiscente;
import br.com.educonnect.negocio.cadastro.ICadastroDisciplina;
import br.com.educonnect.negocio.cadastro.ICadastroDocente;
import br.com.educonnect.negocio.cadastro.ICadastroMatricula;

@Service
public class Fachada {
	@Autowired
	private ICadastroDiscente cadastroDiscente;
	@Autowired
	private ICadastroMatricula cadastroMatricula;
	@Autowired
	private ICadastroDisciplina cadastroDisciplina;
	@Autowired
	private ICadastroDocente cadastroDocente;
	//matricula
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
	//disciplina
	public Disciplina salvarDisciplina(Disciplina d) {
		return this.cadastroDisciplina.salvarDisciplina(d);
	}
	public List<Disciplina> listDisciplinas() {
		return this.cadastroDisciplina.listarDisciplinas();
	}
	public void deletarDisciplina(long id) {
		this.cadastroDisciplina.deletarDisciplinaId(id);
	}
	public Object encontrarDisciplinaId(long id) {
		return this.cadastroDisciplina.procurarDisciplinaId(id);
	}
	//Discente
	public List<Discente> listarDiscentes(){
		return this.cadastroDiscente.listarDiscentes();
	}			
	public void deletarDiscenteId(Long id) {
		this.cadastroDiscente.deletarDiscenteId(id);
	}
	public Discente salvarDiscente(Discente discente) throws DiscenteEmailIgualException  {
		return this.cadastroDiscente.salvarDiscente(discente);
	}
	public void deletarDiscente(Discente discente) {
		this.cadastroDiscente.deletarDiscente(discente);
	}	
	public void adicionarMatricula(long id, Matricula mat) throws DiscenteEmailIgualException {
		//exceção discente nao existe
		Discente dis = this.cadastroDiscente.procurarDiscenteId(id);
		cadastroMatricula.salvarMatricula(mat);
		dis.getMatriculas().add(mat);
		//atualizar
		cadastroDiscente.salvarDiscente(dis);	
	}
	public Discente procurarDiscenteId(long id) {
		return this.cadastroDiscente.procurarDiscenteId(id);
	}
	/*(public Discente procurarDiscenteEmail(String email) {
		return this.cadastroDiscente.procurarDiscenteEmail(email);
		
	}*/
	
	//Docente
	public List<Docente> listarDocentes(){
		return this.cadastroDocente.listarDocentes();
	}			
	public void deletarDocenteId(Long id) {
		this.cadastroDocente.deletarDocenteId(id);
	}
	public Docente salvarDocente(Docente Docente){
		return this.cadastroDocente.salvarDocente(Docente);
	}
	public void deletarDocente(Docente Docente) {
		this.cadastroDocente.deletarDocente(Docente);
	}
	public Object procurarDocenteId(long id) {
		// TODO Auto-generated method stub
		return this.cadastroDocente.procurarDocenteId(id);
	}	

}
