package src.main.java.br.com.educonnect.negocio.basica;

import javax.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Coordenador extends Docente{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private long id;
	
	public Coordenador() {
	}
	
	
}
