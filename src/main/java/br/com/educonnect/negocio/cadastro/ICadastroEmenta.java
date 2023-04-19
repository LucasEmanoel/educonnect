package br.com.educonnect.negocio.cadastro;

import java.util.List;

import br.com.educonnect.negocio.basica.Ementa;

public interface ICadastroEmenta {

    Ementa cadastrarEmenta(Ementa ementa);

    Ementa procurarEmentaId(long id) throws EmentaNaoExisteException;

    List<Ementa> listarEmentas();

    void deletarEmentaId(Long id);

    Ementa salvarEmenta(Ementa ementa);

    void deletarEmenta(Ementa ementa);

}