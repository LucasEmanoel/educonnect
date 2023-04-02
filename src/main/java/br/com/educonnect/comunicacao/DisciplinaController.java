package br.com.educonnect.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.educonnect.negocio.basica.Disciplina;
import br.com.educonnect.negocio.fachada.Fachada;

@CrossOrigin(origins= "http://localhost:3000/")
@RestController
public class DisciplinaController {
	@Autowired
	private Fachada fachada;
	
	@PostMapping(value= "/disciplina")
	public ResponseEntity<Disciplina> saveDisciplina(@RequestBody Disciplina d){
		return ResponseEntity.ok(fachada.salvarDisciplina(d));
	}
	
	@DeleteMapping(value = "/disciplina/{id}" )
	public ResponseEntity<Object> deleteDisciplina(@PathVariable("id") long id){
		this.fachada.deletarDisciplina(id);
		return ResponseEntity.ok("deletado com sucesso");
	}
	
	@GetMapping(value = "/disciplina/{id}")
	public ResponseEntity<Object> procurarDisciplina(@PathVariable("id") long id){
		return ResponseEntity.ok(fachada.encontrarDisciplinaId(id));
	}
	
	@GetMapping(value = "/disciplinas")
	public ResponseEntity<List<Disciplina>> listDisciplinas(){
		return ResponseEntity.ok(fachada.listDisciplinas());
	}
	
	
}
