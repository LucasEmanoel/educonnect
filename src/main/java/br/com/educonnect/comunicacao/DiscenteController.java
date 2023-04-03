package br.com.educonnect.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.educonnect.negocio.basica.Discente;
import br.com.educonnect.negocio.basica.Matricula;
import br.com.educonnect.negocio.basica.Turma;
import br.com.educonnect.negocio.cadastro.DiscenteEmailIgualException;
import br.com.educonnect.negocio.cadastro.DiscenteNaoExisteException;
import br.com.educonnect.negocio.cadastro.TurmaNaoExisteException;
import br.com.educonnect.negocio.fachada.Fachada;
import br.com.educonnect.negocio.fachada.MatriculaIgualException;

@RestController
public class DiscenteController {
	@Autowired
	private Fachada fachada;

	@PostMapping(value = "/discente")
	public ResponseEntity<Discente> saveDiscente(@RequestBody Discente d) throws DiscenteEmailIgualException {
		return ResponseEntity.ok(this.fachada.salvarDiscente(d));
	}

	@DeleteMapping(value = "/discente/{id}")
	public ResponseEntity<Object> deleteDiscente(@PathVariable("id") long id) {
		this.fachada.deletarDiscenteId(id);
		return ResponseEntity.ok("deletado com sucesso");
	}
	
	@GetMapping(value = "/discente/{id}")
	public ResponseEntity<Discente> encontrarDiscente(@PathVariable("id") long id) {
		try {
			return ResponseEntity.ok(this.fachada.procurarDiscenteId(id));
		} catch (DiscenteNaoExisteException e) {
			return new ResponseEntity<Discente> (HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping(value = "/discentes")
	public ResponseEntity<List<Discente>> listDiscentes(){
		return ResponseEntity.ok(fachada.listarDiscentes());
	}
	
	//MATRICULA
	@PostMapping(value = "/discente/{idD}/matricula/{idT}")
	public ResponseEntity<Matricula> adicionarDisciplina(@RequestBody Matricula mat, @PathVariable("idD") long idD, @PathVariable("idT") long idT){
		try {
			return ResponseEntity.ok(fachada.adicionarMatricula(idD, mat, idT));
		} catch (DiscenteNaoExisteException e) {
			e.printStackTrace();
			return new ResponseEntity<Matricula> (HttpStatus.BAD_REQUEST);
		} catch (TurmaNaoExisteException e) {
			e.printStackTrace();
			return new ResponseEntity<Matricula> (HttpStatus.BAD_REQUEST);
		} catch (MatriculaIgualException e) {
			e.printStackTrace();
			return new ResponseEntity<Matricula> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value = "/discente/{idDiscente}/matricula/{idMat}")
	public ResponseEntity<Matricula> deleteDiscenteMatricula(@PathVariable("idDiscente") long idDiscente, @PathVariable("idMat") long idMat){
		try {
			return ResponseEntity.ok(fachada.deletarMatriculaDiscente(idDiscente, idMat));
		} catch (DiscenteNaoExisteException e) {
			e.printStackTrace();
			return new ResponseEntity<Matricula> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/discente/{idDiscente}/matriculas")
	public ResponseEntity<List<Matricula>> listMatriculasDiscente(@PathVariable("idDiscente") long idDiscente){
		try {
			return ResponseEntity.ok(fachada.listMatriculasDiscente(idDiscente));
		} catch (DiscenteNaoExisteException e) {
			
			e.printStackTrace();
			return new ResponseEntity<List<Matricula>> (HttpStatus.BAD_REQUEST);
		}
	}
}
