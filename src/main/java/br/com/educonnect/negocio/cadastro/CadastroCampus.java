package br.com.educonnect.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.educonnect.dados.RepositorioCampus;
import br.com.educonnect.negocio.basica.Campus;

@Component
public class CadastroCampus implements ICadastroCampus {

    @Autowired
    private RepositorioCampus repositorioCampus;

    public CadastroCampus(RepositorioCampus repositorioCampus) {
        super();
        this.repositorioCampus = repositorioCampus;
    }

    @Override
    public Campus encontrarCampusPorId(long id) throws CampusNaoEncontradoException {
        Campus cam = this.repositorioCampus.findById(id).orElse(null);
        if (cam != null) {
            return cam;
        } else {
            throw new CampusNaoEncontradoException();
        }
    }

    @Override
    public List<Campus> listarCampus() {
        return this.repositorioCampus.findAll();
    }

    @Override
    public void deletarCampusPorId(long id) {
        this.repositorioCampus.deleteById(id);
    }

    @Override
    public Campus salvarCampus(Campus campus) {
        return this.repositorioCampus.save(campus);
    }

    @Override
    public Campus atualizarCampus(Campus campus, long id) throws CampusNaoEncontradoException {
        Campus cam = this.encontrarCampusPorId(id);
        cam.setNome(campus.getNome());
		return this.repositorioCampus.save(cam);
    }
}
