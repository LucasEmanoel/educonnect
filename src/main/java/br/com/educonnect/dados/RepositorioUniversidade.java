package br.com.educonnect.dados;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educonnect.negocio.basica.Universidade;


public interface RepositorioUniversidade extends JpaRepository<Universidade, Long> {
	public Optional<Universidade> findById(long id);

}
