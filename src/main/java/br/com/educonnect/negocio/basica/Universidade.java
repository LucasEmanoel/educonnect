package src.main.java.br.com.educonnect.negocio.basica;
import java.util.ArrayList;

public class Universidade {

    private int id;
    private String nome;
    private ArrayList<Campus> campi;
    
    public Universidade(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.campi = new ArrayList<Campus>();
    }
    
    public int getId() {
        return id;
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
    
    Universidade universidade = new Universidade(01, "Universidade Federal de Pernambuco");
        
}    

