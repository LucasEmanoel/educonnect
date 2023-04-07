package br.com.educonnect.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.educonnect.negocio.basica.Ementa;
import br.com.educonnect.negocio.cadastro.DisciplinaNaoExisteException;
import br.com.educonnect.negocio.cadastro.EmentaNaoExisteException;
import br.com.educonnect.negocio.fachada.Fachada;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class EmentaController {
	@Autowired
	private Fachada fachada;

	@PostMapping(value = "/ementa")
	public ResponseEntity<Ementa> saveEmenta(@RequestBody Ementa e) {
	    try {
	        Ementa ementaSalva = fachada.salvarEmenta(e, 0);
	        return ResponseEntity.ok(ementaSalva);
	    } catch (DisciplinaNaoExisteException ex) {
	        return ResponseEntity.badRequest().build();
	    }
	}

	@DeleteMapping(value = "/ementa/{id}")
	public ResponseEntity<Object> deleteEmenta(@PathVariable("id") long id) {
	    this.fachada.deletarEmenta(id);
		return ResponseEntity.ok("Deletado com sucesso");
	}

	@GetMapping(value = "/ementa/{id}")
	public ResponseEntity<Ementa> procurarEmenta(@PathVariable("id") long id) {
	    try {
	        Ementa ementa = fachada.encontrarEmentaId(id);
	        return ResponseEntity.ok(ementa);
	    } catch (EmentaNaoExisteException ex) {
	        return ResponseEntity.notFound().build();
	    }
	}

	@GetMapping(value = "/ementas")
	public ResponseEntity<List<Ementa>> listEmentas() {
	    List<Ementa> ementas = fachada.listEmentas();
	    return ResponseEntity.ok(ementas);
	}

	@PatchMapping(value = "/ementa/{id}")
	public ResponseEntity<Ementa> atualizarEmenta(@RequestBody Ementa e, @PathVariable long id){
	    try {
	        Ementa ementaAtualizada = fachada.atualizarEmenta(e, id, id);
	        return ResponseEntity.ok(ementaAtualizada);
	    } catch (DisciplinaNaoExisteException ex) {
	        return ResponseEntity.badRequest().build();
	    } catch (EmentaNaoExisteException ex) {
	        return ResponseEntity.notFound().build();
	    }  
	}

}