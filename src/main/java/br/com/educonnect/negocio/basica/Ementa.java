package src.main.java.br.com.educonnect.negocio.basica;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "ementa")
public class Ementa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private String id;
	
	@Column(name = "descricao")
    private String descricao;
    
	public Ementa() {}
	
    public Ementa( String descricao) {
        this.descricao = descricao;
    }
    
    public Long getId() {
    	return id;
    }
    
    public void setId(Long Id) {
    	this.id = id;
    }
    
    public String getDescricao() {
    	return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
/* Posteriormente usar
 * Metodo de acesso a descriao da ementa
 * System.out.println("Ementa: "+disciplina1.getEmeta().getDescricao()));
 */ 
}
