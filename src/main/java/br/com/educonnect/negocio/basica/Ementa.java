package src.main.java.br.com.educonnect.negocio.basica;

public class Ementa {
    private String id;
    private String descricao;
    
    public Ementa(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
/* Posteriormente usar
 * M�todo de acesso a descri��o da ementa
 * System.out.println("Ementa: "+disciplina1.getEmeta().getDescricao()));
 */ 
}
