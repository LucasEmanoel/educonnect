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

import br.com.educonnect.negocio.basica.Discente;
import br.com.educonnect.negocio.cadastro.DiscenteEmailIgualException;
import br.com.educonnect.negocio.cadastro.DiscenteNaoExisteException;
import br.com.educonnect.negocio.fachada.Fachada;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class DiscenteController {
	@Autowired
	private Fachada fachada;

	@PostMapping(value = "/discente")
	public ResponseEntity<Discente> saveDiscente(@RequestBody Discente d) {
		try {
			return ResponseEntity.ok(this.fachada.salvarDiscente(d));
		} catch (DiscenteEmailIgualException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Discente>(HttpStatus.BAD_REQUEST);
		}
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
			return new ResponseEntity<Discente>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/discentes")
	public ResponseEntity<List<Discente>> listDiscentes() {
		return ResponseEntity.ok(fachada.listarDiscentes());
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PatchMapping(value = "/discente/{discenteId}")
	public ResponseEntity<Discente> atualizarDiscente(@RequestBody Discente dis, @PathVariable long discenteId) {
		try {
			return ResponseEntity.ok(fachada.atualizarDiscente(dis, discenteId));
		} catch (DiscenteNaoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Discente>(HttpStatus.BAD_REQUEST);
		}

	}
}
