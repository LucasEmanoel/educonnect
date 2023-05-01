package br.com.educonnect.dados;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.educonnect.negocio.basica.Discente;
import br.com.educonnect.negocio.basica.Pessoa;

public interface RepositorioDiscente extends JpaRepository<Discente, Long>{
	
	public Discente findByEmail(String email);
	
	@Query(value = "select d.nome from pessoa d, discente_matriculas dm, matricula mat where mat.id = matriculas_id and d.id = dm.discente_id;", nativeQuery = true)
	public List<String> findNomeByTurmaId(Long id);
}
