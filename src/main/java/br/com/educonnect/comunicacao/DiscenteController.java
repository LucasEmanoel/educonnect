package br.com.educonnect.comunicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.educonnect.negocio.basica.Discente;
import br.com.educonnect.negocio.fachada.Fachada;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class DiscenteController {
	@Autowired
	private Fachada fachada;
	//salvar - atualizar - deletar - getall
	@PostMapping(value="/discente")
	public ResponseEntity<Discente> listarDiscentes(@RequestBody Discente d ){
		return ResponseEntity.ok(fachada.salvarDiscente(d));
		
	}

}
