package br.com.educonnect.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educonnect.dados.RepositorioEmenta;
import br.com.educonnect.negocio.basica.Disciplina;
import br.com.educonnect.negocio.basica.Ementa;

@Service
public class CadastroEmenta implements ICadastroEmenta {

    @Autowired
    private RepositorioEmenta repoEmenta;

    public Ementa cadastrarEmenta(Ementa ementa, Disciplina disciplina) {
        ementa.setDisciplina(disciplina);
        return repoEmenta.save(ementa);
    }

    public Ementa procurarEmentaId(long id) throws EmentaNaoExisteException {
        Ementa ementa = repoEmenta.findById(id).orElse(null);
        if (ementa != null) {
            return ementa;
        } else {
            throw new EmentaNaoExisteException();
        }
    }

    @Override
    public List<Ementa> listarEmentas() {
        return repoEmenta.findAll();
    }

    @Override
    public void deletarEmentaId(Long id) {
        repoEmenta.deleteById(id);

    }

    @Override
    public Ementa salvarEmenta(Ementa ementa) {
        return repoEmenta.save(ementa);
    }

    @Override
    public void deletarEmenta(Ementa ementa) {
        repoEmenta.delete(ementa);

    }

	@Override
	public Ementa cadastrarEmenta(Ementa ementa) {
		// TODO Auto-generated method stub
		return null;
	}

}
