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

import br.com.educonnect.negocio.basica.Matricula;
import br.com.educonnect.negocio.basica.Turma;
import br.com.educonnect.negocio.cadastro.TurmaNaoExisteException;
import br.com.educonnect.negocio.fachada.Fachada;

@RestController
public class TurmaController {
	@Autowired
	private Fachada fachada;

	/*@PostMapping(value = "/turma")
	public ResponseEntity<Turma> saveturma(@RequestBody Turma d){
		return ResponseEntity.ok(this.fachada.salvarTurma(d));
	}*/

	@DeleteMapping(value = "/turma/{id}")
	public ResponseEntity<Object> deleteturma(@PathVariable("id") long id) {
		this.fachada.deletarTurmaId(id);
		return ResponseEntity.ok("deletado com sucesso");
	}
	
	@GetMapping(value = "/turma/{id}")
	public ResponseEntity<Turma> encontrarturma(@PathVariable("id") long id) {
		try {
			return ResponseEntity.ok(this.fachada.procurarTurmaId(id));
		} catch (TurmaNaoExisteException e) {
			e.printStackTrace();
			return new ResponseEntity<Turma> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/turmas")
	public ResponseEntity<List<Turma>> listarTurmas(){
		return ResponseEntity.ok(fachada.listarTurmas());
	}

}
