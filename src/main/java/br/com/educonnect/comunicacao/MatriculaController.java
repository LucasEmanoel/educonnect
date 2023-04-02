package br.com.educonnect.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.educonnect.negocio.basica.Matricula;
import br.com.educonnect.negocio.fachada.Fachada;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class MatriculaController {
	@Autowired
	private Fachada fachada;
	
	/*@PostMapping(value = "/Matricula")
	public ResponseEntity<Matricula> saveMatricula(@RequestBody Matricula d){
		return ResponseEntity.ok(this.fachada.salvarMatricula(d));
	}*/

	@DeleteMapping(value = "/matricula/{id}")
	public ResponseEntity<Object> deleteMatricula(@PathVariable("id") long id) {
		this.fachada.deletarMatriculaId(id);
		return ResponseEntity.ok("deletado com sucesso");
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
