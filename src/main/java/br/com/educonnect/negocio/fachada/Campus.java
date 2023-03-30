package br.com.educonnect.negocio.basica;

import jakarta.persistence.Entity;

@Entity
@Table(name = "campi")
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @ManyToOne
    private Universidade universidade;

    public Campus() {
    }

    public Campus(String nome, Universidade universidade) {
        this.nome = nome;
        this.universidade = universidade;
    }

    // getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Universidade getUniversidade() {
        return universidade;
    }

    public void setUniversidade(Universidade universidade) {
        this.universidade = universidade;
    }
}
