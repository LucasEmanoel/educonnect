package br.com.educonnect.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.educonnect.negocio.basica.Matricula;
import br.com.educonnect.negocio.cadastro.DiscenteNaoExisteException;
import br.com.educonnect.negocio.cadastro.TurmaNaoExisteException;
import br.com.educonnect.negocio.fachada.Fachada;
import br.com.educonnect.negocio.fachada.MatriculaIgualException;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class MatriculaController {
	@Autowired
	private Fachada fachada;
	
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
	public ResponseEntity<Object> deleteDiscenteMatricula(@PathVariable("idDiscente") long idDiscente, @PathVariable("idMat") long idMat){
		try {
			this.fachada.deletarMatriculaDiscente(idDiscente, idMat);
			return ResponseEntity.ok("deletado com sucess!!");
		} catch (DiscenteNaoExisteException e) {
			e.printStackTrace();
			return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
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
	
	@GetMapping(value = "/matricula/{id}")
	public ResponseEntity<Object> encontrarMatricula(@PathVariable("id") long id) {
		return ResponseEntity.ok(this.fachada.procurarMatriculaId(id));
	}
	
	@GetMapping(value = "/matriculas")
	public ResponseEntity<List<Matricula>> listarMatriculas(){
		return ResponseEntity.ok(fachada.listarMatriculas());
	}
	
}
