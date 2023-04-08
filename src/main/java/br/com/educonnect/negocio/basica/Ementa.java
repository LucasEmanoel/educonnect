package br.com.educonnect.nogocio.basica;

<<<<<<< HEAD
import java.util.Objects;

=======
import jakarta.persistence.Column;
>>>>>>> d86ecae9faef454e508f6803bbc2f906719672b2
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.OneToOne;

@Entity
=======
import jakarta.persistence.Table;

@Entity
@Table(name = "ementa")
>>>>>>> d86ecae9faef454e508f6803bbc2f906719672b2
public class Ementa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

<<<<<<< HEAD
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String descricao;
    
    @OneToOne(mappedBy = "ementa")
    private Disciplina disciplina;
    
    public Ementa() {
        super();
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ementa other = (Ementa) obj;
        return Objects.equals(descricao, other.descricao);
    }
=======
    @Column(name = "descricao")
    private String descricao;

    public Ementa() {
    }

    public Ementa(String descricao) {
        this.descricao = descricao;
    }

    // getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
>>>>>>> d86ecae9faef454e508f6803bbc2f906719672b2
}

