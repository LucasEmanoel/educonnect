package br.com.educonnect.dados;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.educonnect.negocio.basica.Turma;

public interface RepositorioTurma extends JpaRepository<Turma, Long>{
	//findByDocente_id
	@Query("select t from Turma t where t.docente.id = :id")
	public List<Turma> listTurmasByDocenteId(@Param("id") Long idDis);
}
