package br.com.educonnect.dados;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educonnect.negocio.basica.Turma;

public interface RepositorioTurma extends JpaRepository<Turma, Long>{
		
}
