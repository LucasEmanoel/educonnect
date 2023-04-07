package br.com.educonnect.dados;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.educonnect.negocio.basica.Ementa;

@Repository
public interface RepositorioEmenta extends JpaRepository<Ementa, Long> {

}
