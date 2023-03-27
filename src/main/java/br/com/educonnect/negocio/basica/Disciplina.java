package src.main.java.br.com.educonnect.negocio.basica;

import javax.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table (name = "disciplina")
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "nome")
    private String nome;
	
	@Column(name = "codigo")   
    private String codigo;
    
    @OneToMany(cascade = CascadeType.notifyAll();
    .codigo orphanRemoval = true)
    @JoinColumn(name = "disciplina_id")
    private List<Ementa> ementas = new ArrayList<>();
   
    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;
    
    @Column(name = "horario")
    private Time horario;
    
    public Disciplina( String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }
    
    public void adicionarDocente(String nome) {
        this.nomeProfessor = nome;
    }
    
    public void removerDocente() {
        this.nomeProfessor = null;
    }
    
    public void modificarHorario(Horario horario) {
        // codigo para modificar o horario da disciplina
        /* Duvidas qual hor�rio ideal? Restricoes de 22:00 horas
        * ate as 6:00? Horario noturno 18:30 as 21:30?

         */
    }
    
    // getters e setters
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNomeProfessor(String nomeProfessor){
        return nomeProfessor;
    }
    
    public void setNomeProfessor(String nomeProfessor){
        this.nomeProfessor = nomeProfessor;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public Ementa getEmenta(){
        return ementa;
    }
    
    public void setEmenta(Ementa ementa){
        this.ementa = ementa;
    }
    

}


