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

import br.com.educonnect.negocio.basica.Discente;
import br.com.educonnect.negocio.cadastro.DiscenteEmailIgualException;
import br.com.educonnect.negocio.fachada.Fachada;

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
	public ResponseEntity<Object> encontrarDiscente(@PathVariable("id") long id) {
		return ResponseEntity.ok(this.fachada.procurarDiscenteId(id));
	}
	
	
	@GetMapping(value = "/discentes")
	public ResponseEntity<List<Discente>> listDiscentes(){
		return ResponseEntity.ok(fachada.listarDiscentes());
	}
	// discente/matriculas
	// 
}
