package br.com.educonnect.negocio.fachada;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educonnect.negocio.basica.Campus;
import br.com.educonnect.negocio.basica.Curso;
import br.com.educonnect.negocio.basica.Discente;
import br.com.educonnect.negocio.basica.Disciplina;
import br.com.educonnect.negocio.basica.Docente;
import br.com.educonnect.negocio.basica.Ementa;
import br.com.educonnect.negocio.basica.Turma;
import br.com.educonnect.negocio.basica.Universidade;
import br.com.educonnect.negocio.basica.Matricula;
import br.com.educonnect.negocio.cadastro.UniversidadeJaExisteException;
import br.com.educonnect.negocio.cadastro.UniversidadeNaoExisteException;
import br.com.educonnect.negocio.cadastro.CampusNaoEncontradoException;
import br.com.educonnect.negocio.cadastro.CursoNaoExisteException;
import br.com.educonnect.negocio.cadastro.DiscenteEmailIgualException;
import br.com.educonnect.negocio.cadastro.DiscenteNaoExisteException;
import br.com.educonnect.negocio.cadastro.DisciplinaNaoExisteException;
import br.com.educonnect.negocio.cadastro.DocenteNaoExisteException;
import br.com.educonnect.negocio.cadastro.EmentaNaoExisteException;
import br.com.educonnect.negocio.cadastro.ICadastroCampus;
import br.com.educonnect.negocio.cadastro.ICadastroCurso;
import br.com.educonnect.negocio.cadastro.ICadastroDiscente;
import br.com.educonnect.negocio.cadastro.ICadastroDisciplina;
import br.com.educonnect.negocio.cadastro.ICadastroDocente;
import br.com.educonnect.negocio.cadastro.ICadastroEmenta;
import br.com.educonnect.negocio.cadastro.ICadastroTurma;
import br.com.educonnect.negocio.cadastro.ICadastroUniversidade;
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
	@Autowired
	private ICadastroUniversidade cadastroUniversidade;
	@Autowired
	private ICadastroCurso cadastroCurso;
	@Autowired
	private ICadastroCampus cadastroCampus;
	@Autowired
	private ICadastroEmenta cadastroEmenta;

	// MATRICULA

	public Matricula procurarMatriculaId(long id) {
		return this.cadastroMatricula.procurarMatriculaId(id);
	}

	public List<Matricula> listarMatriculas() {
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

	// UNIVERSIDADE
	public Universidade salvarUniversidade(Universidade universidade) throws UniversidadeJaExisteException {
		return cadastroUniversidade.salvarUniversidade(universidade);
	}

	public Universidade getUniversidade(Long id) {
		return this.getUniversidade(id);
	}

	public void deletarUniversidade(long id) {
		this.cadastroUniversidade.deletarUniversidadeId(id);
	}
	
	public List<Universidade> listarUniversidade() {
		return this.cadastroUniversidade.listarUniversidade();
	}

	public Universidade atualizarUniversidade(Universidade uni, long universidadeId) throws UniversidadeNaoExisteException {
		return this.cadastroUniversidade.atualizarUniversidade(uni, 0);
	}

	public Universidade encontrarUniversidadeId(long id) throws UniversidadeNaoExisteException {
		return this.cadastroUniversidade.encontrarUniversidadeId(id);
	}

	public void setUniversidade(Universidade uni) {
		this.setUniversidade(uni);
	}

	public void removerUniversidade(Long id) {
		this.removerUniversidade(id);
	}

	// CAMPUS
	public Campus salvarCampus(Campus campus) {
		return cadastroCampus.salvarCampus(campus);
	}

	public void deletarCampus(long id) throws CampusNaoEncontradoException {
		cadastroCampus.deletarCampusPorId(id);
	}

	public Campus encontrarCampusId(long id) throws CampusNaoEncontradoException {
		return cadastroCampus.encontrarCampusPorId(id);
	}

	public List<Campus> listarCampi() {
		return cadastroCampus.listarCampus();
	}

	public Campus atualizarCampus(Campus campus, long campusId) throws CampusNaoEncontradoException {
		return cadastroCampus.atualizarCampus(campus, campusId);
	}

	// CURSO
	public Curso salvarCurso(Curso c) {
		return this.cadastroCurso.salvarCurso(c);
	}

	public List<Curso> listarCursos() {
		return this.cadastroCurso.listarCursos();
	}

	public Curso atualizarCurso(Curso c, long cursoId) throws CursoNaoExisteException {
		return this.cadastroCurso.atualizarCurso(c, 0);
	}

	public void deletarCurso(long id) {
		this.cadastroCurso.deletarCursoId(id);
	}

	public Curso encontrarCursoId(long id) throws CursoNaoExisteException {
		return this.cadastroCurso.encontrarCursoId(id);
	}

	// EMENTA
	public Ementa salvarEmenta(Ementa ementa, long disciplinaId) throws DisciplinaNaoExisteException {
		Disciplina disciplina = cadastroDisciplina.procurarDisciplinaId(disciplinaId);
		ementa.setDisciplina(disciplina);
		return cadastroEmenta.salvarEmenta(ementa);
	}

	public void deletarEmenta(long id) {
		cadastroEmenta.deletarEmentaId(id);
	}

	public Ementa encontrarEmentaId(long id) throws EmentaNaoExisteException {
		return cadastroEmenta.procurarEmentaId(id);
	}

	public List<Ementa> listEmentas() {
		return cadastroEmenta.listarEmentas();
	}

	public Ementa atualizarEmenta(Ementa ementa, long ementaId, long disciplinaId)
			throws EmentaNaoExisteException, DisciplinaNaoExisteException {
		Ementa ementaEncontrada = cadastroEmenta.procurarEmentaId(ementaId);
		Disciplina disciplina = cadastroDisciplina.procurarDisciplinaId(disciplinaId);
		ementaEncontrada.setDescricao(ementa.getDescricao());
		ementaEncontrada.setDisciplina(disciplina);
		return cadastroEmenta.salvarEmenta(ementaEncontrada);
	}

	// DISCIPLINA

	public Disciplina salvarDisciplina(Disciplina d) {
		return this.cadastroDisciplina.salvarDisciplina(d);
	}

	public List<Disciplina> listDisciplinas() {
		return this.cadastroDisciplina.listarDisciplinas();
	}

	public void deletarDisciplina(long id) {
		this.cadastroDisciplina.deletarDisciplinaId(id);
	}

	public Disciplina encontrarDisciplinaId(long id) throws DisciplinaNaoExisteException {
		return this.cadastroDisciplina.procurarDisciplinaId(id);
	}

	// DISCENTE

	public Discente procurarDiscenteId(long id) throws DiscenteNaoExisteException {
		return this.cadastroDiscente.procurarDiscenteId(id);
	}

	public List<Discente> listarDiscentes() {
		return this.cadastroDiscente.listarDiscentes();
	}

	public void deletarDiscenteId(Long id) {
		this.cadastroDiscente.deletarDiscenteId(id);
	}

	public Discente salvarDiscente(Discente discente) throws DiscenteEmailIgualException {
		return this.cadastroDiscente.salvarDiscente(discente);
	}

	public void deletarDiscente(Discente discente) {
		this.cadastroDiscente.deletarDiscente(discente);
	}

	public Matricula adicionarMatricula(long idD, Matricula mat, long idT)
			throws DiscenteNaoExisteException, TurmaNaoExisteException, MatriculaIgualException {
		// exceção discente nao existe
		Discente dis = this.cadastroDiscente.procurarDiscenteId(idD);
		Turma turma = this.cadastroTurma.procurarTurmaId(idT);
		// ver se o discente ja tem essa matricula criada

		if (dis.getMatriculas() != null) {
			if (!dis.getMatriculas().contains(mat)) {
				dis.getMatriculas().add(mat);
				mat.setTurma(turma);
				cadastroMatricula.salvarMatricula(mat);
				cadastroDiscente.salvarDiscenteSemException(dis);
			} else {
				throw new MatriculaIgualException(turma);
			}
		} else {
			dis.setMatriculas(new ArrayList<Matricula>());
			dis.getMatriculas().add(mat);
			mat.setTurma(turma);
			cadastroMatricula.salvarMatricula(mat);
			cadastroDiscente.salvarDiscenteSemException(dis);
		}

		return mat;
	}

	public Matricula deletarMatriculaDiscente(long idMat, long idDiscente) throws DiscenteNaoExisteException {
		Discente dis = this.cadastroDiscente.procurarDiscenteId(idDiscente);
		Matricula mat = this.cadastroMatricula.procurarMatriculaId(idMat);

		dis.getMatriculas().remove(mat);
		cadastroDiscente.salvarDiscenteSemException(dis);
		cadastroMatricula.deletarMatriculaId(mat.getId());
		return mat;
	}

	public List<Matricula> listMatriculasDiscente(long idDiscente) throws DiscenteNaoExisteException {
		Discente dis = this.cadastroDiscente.procurarDiscenteId(idDiscente);
		return dis.getMatriculas();
	}

	public Discente procurarDiscenteEmail(String email) throws DiscenteNaoExisteException {
		return this.cadastroDiscente.procurarDiscenteEmail(email);

	}

	// DOCENTE

	public List<Docente> listarDocentes() {
		return this.cadastroDocente.listarDocentes();
	}

	public void deletarDocenteId(Long id) {
		this.cadastroDocente.deletarDocenteId(id);
	}

	public Docente salvarDocente(Docente docente) {
		return this.cadastroDocente.salvarDocente(docente);
	}

	public void deletarDocente(Docente docente) {
		this.cadastroDocente.deletarDocente(docente);
	}

	public Docente procurarDocenteId(long id) throws DocenteNaoExisteException {
		return this.cadastroDocente.procurarDocenteId(id);
	}

	// quero jogar uma exception aqui para nao ter duas turmas iguais do mesmo
	// docente.
	public Object ofertarDisciplina(long IDdocente, Turma t, long IDdisc)
			throws DisciplinaNaoExisteException, DocenteNaoExisteException, TurmaIgualException {
		Docente doc = this.cadastroDocente.procurarDocenteId(IDdocente);
		Disciplina disc = this.cadastroDisciplina.procurarDisciplinaId(IDdisc);

		if (doc != null && disc != null) {
			t.setDocente(doc);
			t.setDisciplina(disc);

			List<Turma> turmas = this.cadastroTurma.listarTurmasDocente(IDdocente);
			if (!turmas.contains(t)) {
				return this.cadastroTurma.salvarTurma(t);
			} else {
				throw new TurmaIgualException(disc);
			}

		}
		return null;
	}

	// Turma

	public List<Turma> listarTurmas() {
		return this.cadastroTurma.listarTurmas();
	}

	public void deletarTurmaId(Long id) {
		this.cadastroTurma.deletarTurmaId(id);
	}

	public Turma salvarTurma(Turma turma) {
		return this.cadastroTurma.salvarTurma(turma);
	}

	public void deletarTurma(Turma turma) {
		this.cadastroTurma.deletarTurma(turma);
	}

	public Turma procurarTurmaId(long id) throws TurmaNaoExisteException {
		return this.cadastroTurma.procurarTurmaId(id);
	}

	public Object procurarTurmasDoDocente(long id) {
		return this.cadastroTurma.listarTurmasDocente(id);
	}

	public Turma deletarTurmaPorDocente(long idDocente, long idT)
			throws DocenteNaoExisteException, TurmaNaoExisteException {
		this.cadastroTurma.deletarTurmaId(idT);
		return null;
	}

	public List<Turma> listarTurmasPorDocenteId(long idDocente) {
		List<Turma> turmas = this.cadastroTurma.listarTurmasDocente(idDocente);
		return turmas;
	}

	public Disciplina atualizarDisciplina(Disciplina d, long disciplinaId) throws DisciplinaNaoExisteException {
		Disciplina disciplina = this.cadastroDisciplina.procurarDisciplinaId(disciplinaId);
		d.setId(disciplina.getId());

		return this.cadastroDisciplina.salvarDisciplina(d);
	}

	public Discente atualizarDiscente(Discente dis, long discenteId) throws DiscenteNaoExisteException {
		Discente discente = this.cadastroDiscente.procurarDiscenteId(discenteId);
		dis.setId(discente.getId());

		return this.cadastroDiscente.salvarDiscenteSemException(dis);
	}

	public Docente atualizarDocente(Docente doc, long docenteId) throws DocenteNaoExisteException {
		Docente docente = this.cadastroDocente.procurarDocenteId(docenteId);
		doc.setId(docente.getId());

		return this.cadastroDocente.salvarDocente(doc);
	}

}
