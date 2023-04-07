package br.com.educonnect.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.educonnect.negocio.basica.Campus;
import br.com.educonnect.negocio.fachada.Fachada;

@Component
public class CadastroCampus {

    @Autowired
    private Fachada fachada;

    public Campus salvarCampus(Campus campus) {
        return fachada.salvarCampus(campus);
    }

    public void deletarCampus(long id) throws CampusNaoEncontradoException {
        fachada.deletarCampus(id);
    }

    public Campus encontrarCampusId(long id) throws CampusNaoEncontradoException {
        return fachada.encontrarCampusId(id);
    }

    public List<Campus> listarCampus() {
        return fachada.listarCampi();
    }

    public Campus atualizarCampus(Campus campus, long campusId) throws CampusNaoEncontradoException {
        return fachada.atualizarCampus(campus, campusId);
    }
}
