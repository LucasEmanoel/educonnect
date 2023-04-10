package br.com.educonnect.negocio.cadastro;

import br.com.educonnect.negocio.basica.Universidade;

public class CadastroUniversidade {

    private static Universidade universidade = null;

    public Universidade salvarUniversidade(Universidade universidade) throws UniversidadeJaExisteException {
        if (CadastroUniversidade.universidade == null) {
            CadastroUniversidade.universidade = universidade;
        } else {
            throw new UniversidadeJaExisteException(null);
        }
        return CadastroUniversidade.universidade;
    }

    public Universidade procurarUniversidade() {
        return CadastroUniversidade.universidade;
    }

}

