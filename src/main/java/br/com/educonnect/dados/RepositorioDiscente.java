package br.com.educonnect.dados;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educonnect.negocio.basica.Discente;

public interface RepositorioDiscente extends JpaRepository<Discente, Long>{
	public Discente findByEmail(String email);
}
