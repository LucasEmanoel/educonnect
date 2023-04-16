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

import br.com.educonnect.negocio.basica.Universidade;
import br.com.educonnect.negocio.cadastro.UniversidadeJaExisteException;
import br.com.educonnect.negocio.cadastro.UniversidadeNaoExisteException;
import br.com.educonnect.negocio.fachada.Fachada;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class UniversidadeController {
	@Autowired
	private Fachada fachada;

	@PostMapping("/universidade")
	public ResponseEntity<Universidade> salvarUniversidade(@RequestBody Universidade universidade) throws UniversidadeJaExisteException{
		return ResponseEntity.ok(fachada.salvarUniversidade(universidade));
	}
	
	@DeleteMapping(value = "/universidade/{id}")
	public ResponseEntity<Object> deleteUniversidade0(@PathVariable("id") long id){
		this.fachada.deletarUniversidade(id);
		return ResponseEntity.ok("Deletado com sucesso");
	}
	
	@GetMapping(value = "/universidade/{id}")
	public ResponseEntity<Universidade> procurarUniversidade(@PathVariable("id") long id){
		try {
			return ResponseEntity.ok(fachada.encontrarUniversidadeId(id));
		} catch (UniversidadeNaoExisteException e) {
			e.printStackTrace();
			return new ResponseEntity<Universidade> (HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/universidades")
	public ResponseEntity<List<Universidade>> listUniversidade(){
		return ResponseEntity.ok(fachada.listarUniversidade());
	}
	
	@PatchMapping(value = "/universidade/{id}")
	public ResponseEntity<Universidade> atualizarUniversidade(@RequestBody Universidade uni, @PathVariable long id){
		try {
			return ResponseEntity.ok(fachada.atualizarUniversidade(uni, id));
		} catch(UniversidadeNaoExisteException e) {
			e.printStackTrace();
			return new ResponseEntity<Universidade> (HttpStatus.BAD_REQUEST);	
		}

	}

}

