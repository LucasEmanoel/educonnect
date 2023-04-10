package br.com.educonnect.comunicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.educonnect.negocio.basica.Universidade;
import br.com.educonnect.negocio.cadastro.CadastroUniversidade;
import br.com.educonnect.negocio.cadastro.UniversidadeJaExisteException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ControllerUniversidade {

    @Autowired
    private CadastroUniversidade cadastroUniversidade;

    @PostMapping("/universidade")
    public ResponseEntity<Universidade> salvarUniversidade(@RequestBody Universidade universidade) {
        try {
            Universidade uni = this.cadastroUniversidade.salvarUniversidade(universidade);
            return ResponseEntity.ok(uni);
        } catch (UniversidadeJaExisteException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/universidade")
    public ResponseEntity<Universidade> encontrarUniversidade() {
        Universidade uni = this.cadastroUniversidade.procurarUniversidade();
        if (uni != null) {
            return ResponseEntity.ok(uni);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
