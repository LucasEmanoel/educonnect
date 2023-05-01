package br.com.educonnect.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.educonnect.negocio.basica.Docente;
import br.com.educonnect.negocio.cadastro.DocenteNaoExisteException;
import br.com.educonnect.negocio.fachada.Fachada;

@CrossOrigin(origins= "http://localhost:3000/")
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
	public ResponseEntity<Docente> encontrarDocente(@PathVariable("id") long id) {
		try {
			return ResponseEntity.ok(this.fachada.procurarDocenteId(id));
		} catch (DocenteNaoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Docente> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/docentes")
	public ResponseEntity<List<Docente>> listDocentes(){
		return ResponseEntity.ok(fachada.listarDocentes());
	}
	
	@PatchMapping(value = "/docente/{docenteId}")
	public ResponseEntity<Docente> atualizarDocente(@RequestBody Docente doc, @PathVariable long docenteId){
		try {
			return ResponseEntity.ok(fachada.atualizarDocente(doc, docenteId));
		} catch (DocenteNaoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Docente> (HttpStatus.BAD_REQUEST);
		}
	}
}
	

