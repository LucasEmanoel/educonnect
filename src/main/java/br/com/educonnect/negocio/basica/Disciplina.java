package src.main.java.br.com.educonnect.negocio.basica;

public class Disciplina {
    private String id;
    private String nome;
    private String nomeProfessor;
    private String codigo;
    private Ementa ementa;
    private Horario horario;
    
    public Disciplina(String id, String nome, String nomeProfessor, String codigo, Ementa ementa) {
        this.id = id;
        this.nome = nome;
        this.nomeProfessor = nomeProfessor;
        this.codigo = codigo;
        this.ementa = ementa;
    }
    
    public void adicionarDocente(String nome) {
        this.nomeProfessor = nome;
    }
    
    public void removerDocente() {
        this.nomeProfessor = null;
    }
    
    public void modificarHorario(String horario) {
        // c�digo para modificar o hor�rio da disciplina
        /* D�vidas qual hor�rio ideal? Restri��es de 22:00 horas
        * at� �s 6:00? Hor�rio noturno 18:30 � 21:30?
         * 
         */
    }
    
    // getters e setters
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
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


