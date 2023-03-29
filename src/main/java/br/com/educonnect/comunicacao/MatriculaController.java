package br.com.educonnect.comunicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import br.com.educonnect.negocio.fachada.Fachada;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class MatriculaController {
	@Autowired
	private Fachada fachada;
	
	
}
