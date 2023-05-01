package br.com.educonnect.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educonnect.negocio.basica.Disciplina;

public interface RepositorioDisciplina extends JpaRepository<Disciplina, Long>{

}
