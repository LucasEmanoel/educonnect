package br.com.educonnect.comunicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.educonnect.negocio.basica.Universidade;
import br.com.educonnect.negocio.cadastro.ICadastroUniversidade;
import br.com.educonnect.negocio.cadastro.UniversidadeJaExisteException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UniversidadeController {

    @Autowired
    private ICadastroUniversidade cadastroUniversidade;

    @PostMapping("/universidade")
    public ResponseEntity<Universidade> salvarUniversidade(@RequestBody Universidade universidade) {
        try {
            Universidade uni = this.cadastroUniversidade.cadastrarUniversidade(universidade);
            return ResponseEntity.ok(uni);
        } catch (UniversidadeJaExisteException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/universidade")
    public ResponseEntity<Universidade> encontrarUniversidade(Long id) {
        Universidade uni = this.cadastroUniversidade.getUniversidade(id);
        if (uni != null) {
            return ResponseEntity.ok(uni);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/universidade/{id}")
    public ResponseEntity<Void> removerUniversidade(@PathVariable Long id) {
        this.cadastroUniversidade.removerUniversidade(id);
		return ResponseEntity.ok().build();
    }
}
