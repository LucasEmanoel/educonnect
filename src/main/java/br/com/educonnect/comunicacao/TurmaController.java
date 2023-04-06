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

import br.com.educonnect.negocio.basica.Turma;
import br.com.educonnect.negocio.cadastro.DisciplinaNaoExisteException;
import br.com.educonnect.negocio.cadastro.DocenteNaoExisteException;
import br.com.educonnect.negocio.cadastro.TurmaNaoExisteException;
import br.com.educonnect.negocio.fachada.Fachada;
import br.com.educonnect.negocio.fachada.TurmaIgualException;

@RestController
public class TurmaController {
	@Autowired
	private Fachada fachada;

	@PostMapping(value = "/docente/{idDocente}/turma/{idD}")
	public ResponseEntity<Object> ofertarDisciplina(@RequestBody Turma t, @PathVariable("idDocente") long idDocente, @PathVariable("idD") long idD){
		try {
			return ResponseEntity.ok(this.fachada.ofertarDisciplina(idDocente, t, idD));
		} catch (DisciplinaNaoExisteException | DocenteNaoExisteException | TurmaIgualException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value = "/docente/{idDocente}/turma/{idT}")
	public ResponseEntity<Object> deletarTurmaDocente(@PathVariable("idDocente") long idDocente, @PathVariable("idT") long idT){
		
		try {
			this.fachada.deletarTurmaPorDocente(idDocente, idT);
			return ResponseEntity.ok("deletado com sucesso");
		} catch (DocenteNaoExisteException | TurmaNaoExisteException e) {
			e.printStackTrace();
			return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/docente/{idDocente}/turmas")
	public ResponseEntity<List<Turma>> listarTurmasDocente(@PathVariable("idDocente") long idDocente){
		return ResponseEntity.ok(this.fachada.listarTurmasPorDocenteId(idDocente));
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
