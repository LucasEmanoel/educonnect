package br.com.educonnect.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.educonnect.negocio.basica.Docente;
import br.com.educonnect.negocio.basica.Turma;
import br.com.educonnect.negocio.fachada.Fachada;

@RestController
public class DocenteController {
	@Autowired
	private Fachada fachada;

	@PostMapping(value = "/docente")
	public ResponseEntity<Docente> saveDocente(@RequestBody Docente d){
		return ResponseEntity.ok(this.fachada.salvarDocente(d));
	}

	@DeleteMapping(value = "/docente/{id}")
	public ResponseEntity<Object> deleteDocente(@PathVariable("id") long id) {
		this.fachada.deletarDocenteId(id);
		return ResponseEntity.ok("deletado com sucesso");
	}
	
	@GetMapping(value = "/docente/{id}")
	public ResponseEntity<Object> encontrarDocente(@PathVariable("id") long id) {
		return ResponseEntity.ok(this.fachada.procurarDocenteId(id));
	}
	
	@GetMapping(value = "/docentes")
	public ResponseEntity<List<Docente>> listDocentes(){
		return ResponseEntity.ok(fachada.listarDocentes());
	}
	
	@PostMapping(value = "/docente/{idDocente}/turma/{idD}")
	public ResponseEntity<Object> ofertarDisciplina(@RequestBody Turma t, @PathVariable("idDocente") long idDocente, @PathVariable("idD") long idD){
		return ResponseEntity.ok(this.fachada.ofertarDisciplina(idDocente, t, idD));
	}
}

