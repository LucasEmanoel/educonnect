package br.com.educonnect.comunicacao;

import java.util.List;

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

import br.com.educonnect.negocio.basica.Disciplina;
import br.com.educonnect.negocio.basica.Ementa;
import br.com.educonnect.negocio.cadastro.CadastroDisciplina;
import br.com.educonnect.negocio.cadastro.CadastroEmenta;
import br.com.educonnect.negocio.cadastro.DisciplinaNaoExisteException;
import br.com.educonnect.negocio.cadastro.EmentaNaoExisteException;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ControllerEmenta {

    @Autowired
    private CadastroEmenta cadastroEmenta;

    @Autowired
    private CadastroDisciplina cadastroDisciplina;

    @PostMapping(value = "/ementa/disciplina/{disciplinaId}")
    public ResponseEntity<Ementa> salvarEmenta(@RequestBody Ementa ementa, @PathVariable long disciplinaId) {
        try {
            Disciplina disciplina = cadastroDisciplina.procurarDisciplinaId(disciplinaId);

            //ementa.setDisciplina(disciplina);
            return ResponseEntity.ok(cadastroEmenta.salvarEmenta(ementa));
        } catch (DisciplinaNaoExisteException e) {
            e.printStackTrace();
            return new ResponseEntity<Ementa>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/ementa/{id}")
    public ResponseEntity<Object> deleteEmenta(@PathVariable("id") long id) {
        cadastroEmenta.deletarEmentaId(id);
		return ResponseEntity.ok("Deletado com sucesso");
    }

    @GetMapping(value = "/ementa/{id}")
    public ResponseEntity<Ementa> procurarEmenta(@PathVariable("id") long id) {
        try {
            return ResponseEntity.ok(cadastroEmenta.procurarEmentaId(id));
        } catch (EmentaNaoExisteException e) {
            e.printStackTrace();
            return new ResponseEntity<Ementa>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/ementas")
    public ResponseEntity<List<Ementa>> listEmentas() {
        return ResponseEntity.ok(cadastroEmenta.listarEmentas());
    }
}
