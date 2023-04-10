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

import br.com.educonnect.negocio.basica.Campus;
import br.com.educonnect.negocio.cadastro.CampusNaoEncontradoException;
import br.com.educonnect.negocio.fachada.Fachada;

@CrossOrigin(origins= "http://localhost:3000/")
@RestController
public class ControllerCampus {
	
	@Autowired
	private Fachada fachada;
	
	@PostMapping(value= "/campus")
	public ResponseEntity<Campus> salvarCampus(@RequestBody Campus campus){
		return ResponseEntity.ok(fachada.salvarCampus(campus));
	}
	
	@DeleteMapping(value = "/campus/{id}" )
	public ResponseEntity<Object> deleteCampus(@PathVariable("id") long id){
		try {
			fachada.deletarCampus(id);
			return ResponseEntity.ok("Deletado com sucesso");
		} catch (CampusNaoEncontradoException e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Campus não encontrado", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/campus/{id}")
	public ResponseEntity<Campus> procurarCampus(@PathVariable("id") long id){
		try {
			return ResponseEntity.ok(fachada.encontrarCampusId(id));
		} catch (CampusNaoEncontradoException e) {
			e.printStackTrace();
			return new ResponseEntity<Campus>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/campi")
	public ResponseEntity<List<Campus>> listCampus(){
		return ResponseEntity.ok(fachada.listarCampi());
	}
	
	@PatchMapping(value = "/campus/{id}")
	public ResponseEntity<Campus> atualizarCampus(@RequestBody Campus campus, @PathVariable long id){
		try {
			return ResponseEntity.ok(fachada.atualizarCampus(campus, id));
		} catch (CampusNaoEncontradoException e) {
			e.printStackTrace();
			return new ResponseEntity<Campus> (HttpStatus.NOT_FOUND);
		}
	}
}

