package br.com.educonnect.negocio.basica;                                                                            
                                                                                                                     
import java.util.List;                                                                                               
                                                                                                                     
import jakarta.persistence.Entity;                                                                                   
import jakarta.persistence.GeneratedValue;                                                                           
import jakarta.persistence.GenerationType;                                                                           
import jakarta.persistence.Id;                                                                                       
import jakarta.persistence.OneToMany;                                                                                
import jakarta.persistence.Table;                                                                                    
                                                                                                                     
                                                                                                                     
@Entity                                                                                                              
@Table(name = "campi")                                                                                               
public class Campus {                                                                                                
	                                                                                                                 
	@Id                                                                                                              
	@GeneratedValue(strategy = GenerationType.IDENTITY)                                                              
	private long id;                                                                                                 
	                                                                                                                 
	private String nome;                                                                                             
	                                                                                                                 
	@OneToMany(mappedBy = "campus")                                                                                  
	private List<Curso> curso;                                                                                       
	                                                                                                                 
	public Campus() {}                                                                                               
	                                                                                                                 
	                                                                                                                 
	//getters e setters                                                                                              
	                                                                                                                 
	public long getId() {                                                                                            
		return id;                                                                                                   
	}                                                                                                                
                                                                                                                     
	public void setId(long id) {                                                                                     
		this.id = id;                                                                                                
	}                                                                                                                
	                                                                                                                 
	public String getNome() {                                                                                        
		return nome;                                                                                                 
	}                                                                                                                
	                                                                                                                 
	public void setNome(String nome) {                                                                               
		this.nome = nome;                                                                                            
	}                                                                                                                
	                                                                                                                 
		public List<Curso> getCurso(){                                                                               
			return curso;                                                                                            
	}                                                                                                                
    	                                                                                                             
    	public void setCurso(List<Curso> curso) {                                                                    
    		this.curso = curso;                                                                                      
    	}                                                                                                            
}                                                                                                                                                           