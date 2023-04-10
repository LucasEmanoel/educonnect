package br.com.educonnect.dados;

import br.com.educonnect.negocio.basica.Curso;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCurso extends JpaRepository<Curso, Long>{
	public Optional<Curso> findById(Long id);
}

