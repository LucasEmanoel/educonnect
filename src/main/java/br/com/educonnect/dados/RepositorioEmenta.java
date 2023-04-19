package br.com.educonnect.dados;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educonnect.negocio.basica.Ementa;

public interface RepositorioEmenta extends JpaRepository<Ementa, Long> {

}
