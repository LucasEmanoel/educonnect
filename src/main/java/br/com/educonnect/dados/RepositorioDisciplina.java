package br.com.educonnect.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educonnect.negocio.basica.Disciplina;
import br.com.educonnect.negocio.basica.Horario;

public interface RepositorioDisciplina extends JpaRepository<Disciplina, Long>{

	List<Disciplina> findByHorario(Horario horario);

}
