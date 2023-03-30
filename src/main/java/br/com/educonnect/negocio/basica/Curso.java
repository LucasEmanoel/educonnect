package br.com.educonnect.negocio.basica;

import jakarta.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@OneToMany(mappedBy = "curso")
	private List<Disciplina> disciplinas = new ArrayList<>();
	
	@OneToOne
	private Coordenador coordenador;
	
	public Curso() {}
	
	public void adicionarDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
		disciplina.setCurso(this);
	}
	
	public void mudarCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
		coordenador.setCurso(this);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Disciplina> getDisciplinas(){
		return disciplinas;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public Coordenador getCoordenador() {
		return coordenador;
	}
	
	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}
}
