package br.com.educonnect.negocio.fachada;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educonnect.negocio.basica.Discente;
import br.com.educonnect.negocio.basica.Disciplina;
import br.com.educonnect.negocio.basica.Docente;
import br.com.educonnect.negocio.basica.Turma;
import br.com.educonnect.negocio.basica.Matricula;
import br.com.educonnect.negocio.cadastro.DiscenteEmailIgualException;
import br.com.educonnect.negocio.cadastro.DiscenteNaoExisteException;
import br.com.educonnect.negocio.cadastro.DisciplinaNaoExisteException;
import br.com.educonnect.negocio.cadastro.DocenteNaoExisteException;
import br.com.educonnect.negocio.cadastro.ICadastroDiscente;
import br.com.educonnect.negocio.cadastro.ICadastroDisciplina;
import br.com.educonnect.negocio.cadastro.ICadastroDocente;
import br.com.educonnect.negocio.cadastro.ICadastroTurma;
import br.com.educonnect.negocio.cadastro.TurmaNaoExisteException;
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
	@Autowired
	private ICadastroTurma cadastroTurma;
	
	//MATRICULA
	
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
	
	//DISCIPLINA
	
	public Disciplina salvarDisciplina(Disciplina d) {
		return this.cadastroDisciplina.salvarDisciplina(d);
	}
	public List<Disciplina> listDisciplinas() {
		return this.cadastroDisciplina.listarDisciplinas();
	}
	public void deletarDisciplina(long id) {
		this.cadastroDisciplina.deletarDisciplinaId(id);
	}
	public Object encontrarDisciplinaId(long id) throws DisciplinaNaoExisteException {
		return this.cadastroDisciplina.procurarDisciplinaId(id);
	}
	
	//DISCENTE
	
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
	
	public Matricula adicionarMatricula(long idD, Matricula mat, long idT) throws DiscenteNaoExisteException, TurmaNaoExisteException, MatriculaIgualException {
		//exceção discente nao existe
		Discente dis = this.cadastroDiscente.procurarDiscenteId(idD);
		Turma turma = this.cadastroTurma.procurarTurmaId(idT);
		//ver se o discente ja tem essa matricula criada
		mat.setTurma(turma);
		
		if(dis.getMatriculas() != null) {
			cadastroMatricula.salvarMatricula(mat);
		} else if(!dis.getMatriculas().contains(mat)){
			cadastroMatricula.salvarMatricula(mat);
		}else {
			throw new MatriculaIgualException(turma);
		}
		
		dis.getMatriculas().add(mat);
		//atualizar
		cadastroDiscente.salvarDiscenteSemException(dis);
		return mat;	
	}
	
	public Discente procurarDiscenteId(long id) throws DiscenteNaoExisteException {
		return this.cadastroDiscente.procurarDiscenteId(id);
	}
	
	public Discente procurarDiscenteEmail(String email) throws DiscenteNaoExisteException {
		return this.cadastroDiscente.procurarDiscenteEmail(email);
		
	}
	
	//DOCENTE
	
	public List<Docente> listarDocentes(){
		return this.cadastroDocente.listarDocentes();
	}			
	public void deletarDocenteId(Long id) {
		this.cadastroDocente.deletarDocenteId(id);
	}
	public Docente salvarDocente(Docente docente){
		return this.cadastroDocente.salvarDocente(docente);
	}
	public void deletarDocente(Docente docente) {
		this.cadastroDocente.deletarDocente(docente);
	}
	public Object procurarDocenteId(long id) throws DocenteNaoExisteException {
		return this.cadastroDocente.procurarDocenteId(id);
	}	
	
	//quero jogar uma exception aqui para nao ter duas turmas iguais do mesmo docente.
	public Object ofertarDisciplina(long IDdocente, Turma t, long IDdisc) throws DisciplinaNaoExisteException, DocenteNaoExisteException {
		//exceptions de existir
		Docente doc = this.cadastroDocente.procurarDocenteId(IDdocente);
		Disciplina disc = this.cadastroDisciplina.procurarDisciplinaId(IDdisc);
		
		if(doc != null && disc != null) {
			t.setDocente(doc);
			//ta feio, olhar outra solucao
			if(t.getDisciplina() == null) {
				List<Disciplina> list = new ArrayList<Disciplina>();
				list.add(disc);
				t.setDisciplina(list);
			}else {
				t.getDisciplina().add(disc);
			}
			return this.cadastroTurma.salvarTurma(t);
		}
		return null;
	}
	
	//Turma
	
	public List<Turma> listarTurmas(){
		return this.cadastroTurma.listarTurmas();
	}			
	public void deletarTurmaId(Long id) {
		this.cadastroTurma.deletarTurmaId(id);
	}
	public Turma salvarTurma(Turma turma){
		return this.cadastroTurma.salvarTurma(turma);
	}
	public void deletarTurma(Turma turma) {
		this.cadastroTurma.deletarTurma(turma);
	}
	public Object procurarTurmaId(long id) throws TurmaNaoExisteException {
		return this.cadastroTurma.procurarTurmaId(id);
	}
	public Object procurarTurmasDoDocente(long id) {
		return this.cadastroTurma.listarTurmasDocente(id);
	}
	
}
