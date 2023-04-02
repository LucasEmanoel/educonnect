package br.com.educonnect.dados;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educonnect.negocio.basica.Matricula;

public interface RepositorioMatricula extends JpaRepository<Matricula, Long>{
	// usar query para pegar as matriculas de um determinado aluno  
		//@Query("SELECT r.name FROM RuleVo r where r.id = :id") 
		//
}
