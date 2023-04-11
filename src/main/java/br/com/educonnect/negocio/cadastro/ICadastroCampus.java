package br.com.educonnect.negocio.cadastro;

import java.util.List;

import br.com.educonnect.negocio.basica.Campus;

public interface ICadastroCampus {

    Campus encontrarCampusPorId(long id) throws CampusNaoEncontradoException;

    List<Campus> listarCampus();

    void deletarCampusPorId(long id);

    Campus salvarCampus(Campus campus);

    Campus atualizarCampus(Campus campus, long id) throws CampusNaoEncontradoException;

}
