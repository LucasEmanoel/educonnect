package src.main.java.br.com.educonnect.negocio.basica;
import java.util.List;
import java.util.ArrayList;

public class Cursos{
    private int id;
    private String nome;
    private List<Disciplina> disciplinas;
    private Coordenador coordenador;
    
    public Cursos() {
        this.id = id;
        this.nome = nome;
        this.disciplinas = new ArrayList<Disciplina>();
    }
    
    public void adicionarDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }
    
    public void mudarCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome(String nome) {
        this.nome = nome;
    }
    
    public List<Disciplina> getDisciplinas(){
        return disciplinas;
    }
    
    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    public Coordenador getCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }
    
    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

}
