package src.main.java.br.com.educonnect.negocio.basica;
import java.util.ArrayList;

import javax.persistence.Entityl;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "campi")
public class Campus {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
		
        private String nome;
        
        @ManyToOne
        private Universidade universidade;
        
        public Campus() {}
        
        public Campus(String nome, Universidade universidade) {
            this.nome = nome;
            this.universidade = universidade;
        }
        
        public String getNome() {
            return nome;
        }
        
        public void adicionarCurso(Cursos cursos){
            this.curso.add(cursos);
        }
        
    Campus campus = new Campus(01, "UAG - Unidade Acadêmica de Garanhuns");  
    

}
