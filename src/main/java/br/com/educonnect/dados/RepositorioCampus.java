package br.com.educonnect.dados;

import br.com.educonnect.negocio.basica.Campus;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCampus extends JpaRepository<Campus, Long>{
	public Optional<Campus> findById(Long id);
}
