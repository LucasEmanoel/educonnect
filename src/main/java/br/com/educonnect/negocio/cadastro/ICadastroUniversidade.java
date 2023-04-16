package br.com.educonnect.negocio.cadastro;

import java.util.List;

import br.com.educonnect.negocio.basica.Universidade;

public interface ICadastroUniversidade {
	
	Universidade encontrarUniversidadeId(long id) throws UniversidadeNaoExisteException;
	
    Universidade salvarUniversidade(Universidade universidade);
    
    List<Universidade> listarUniversidade();
    
    void deletarUniversidadeId(long id);
    
    Universidade atualizarUniversidade(Universidade universidade, long id) throws UniversidadeNaoExisteException;
    
}