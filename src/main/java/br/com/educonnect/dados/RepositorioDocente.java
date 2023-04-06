package br.com.educonnect.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educonnect.negocio.basica.Docente;

public interface RepositorioDocente extends JpaRepository<Docente, Long>{

}