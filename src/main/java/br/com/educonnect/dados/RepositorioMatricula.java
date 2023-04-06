package br.com.educonnect.dados;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educonnect.negocio.basica.Matricula;

public interface RepositorioMatricula extends JpaRepository<Matricula, Long>{
	
	//Matricula findByIdAndDiscenteId(Long idMat, Long idDis);
	
	//@Query("select m from Matricula m where m.discente.id = :idDis") 
	//List<Matricula> findAllByDiscente(@Param("idDis") long idDis);
	
	// usar query para pegar as matriculas de um determinado aluno  
		//@Query("SELECT r.name FROM RuleVo r where r.id = :id") 
		//
}
