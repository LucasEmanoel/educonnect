package src.main.java.br.com.educonnect.negocio.basica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "universidades")
public class Universidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nome;
    
    @OneToMany(mappedBy = "universidade")
    private List<Campus> campi;
    
    public Universidade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void adicionarCampus(Campus campus){
        this.campi.add(campus);
    }
    
}    

