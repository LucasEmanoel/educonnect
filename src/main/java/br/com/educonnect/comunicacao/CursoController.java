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

import br.com.educonnect.negocio.basica.Curso;
import br.com.educonnect.negocio.cadastro.CursoNaoExisteException;
import br.com.educonnect.negocio.fachada.Fachada;

@CrossOrigin(origins= "http://localhost:3000/")
@RestController
public class CursoController {
	@Autowired
	private Fachada fachada;
	
	@PostMapping(value= "/curso")
	public ResponseEntity<Curso> salvarCurso(@RequestBody Curso c){
		return ResponseEntity.ok(fachada.salvarCurso(c));
	}
	
	@DeleteMapping(value = "/curso/{id}" )
	public ResponseEntity<Object> deleteCurso(@PathVariable("id") long id){
		this.fachada.deletarCurso(id);
		return ResponseEntity.ok("deletado com sucesso");
	}
	
	@GetMapping(value = "/curso/{id}")
	public ResponseEntity<Curso> procurarCurso(@PathVariable("id") long id){
		try {
			return ResponseEntity.ok(fachada.encontrarCursoId(id));
		} catch (CursoNaoExisteException e) {
			e.printStackTrace();
			return new ResponseEntity<Curso> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/cursos")
	public ResponseEntity<List<Curso>> listCursos(){
		return ResponseEntity.ok(fachada.listarCursos());
	}
	
	@PatchMapping(value = "/curso/{id}")
	public ResponseEntity<Curso> atualizarCurso(@RequestBody Curso c, @PathVariable long id){
		try {
			return ResponseEntity.ok(fachada.atualizarCurso(c, id));
		} catch (CursoNaoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Curso> (HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
