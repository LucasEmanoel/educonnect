package br.com.educonnect.negocio.cadastro;

import br.com.educonnect.negocio.basica.Universidade;

public interface ICadastroUniversidade {
    Universidade cadastrarUniversidade(Universidade universidade) throws UniversidadeJaExisteException;
    Universidade getUniversidade();
    void setUniversidade(Universidade universidade);
}