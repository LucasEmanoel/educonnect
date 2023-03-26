package src.main.java.br.com.educonnect.negocio.basica;
import java.util.ArrayList;

public class Campus {

        private int id;
        private String nome;
        private ArrayList<Cursos> curso;
        
        public Campus(int id, String nome) {
            this.id = id;
            this.nome = nome;
            this.curso = new ArrayList<Campus>();
        }
        
        public int getId() {
            return id;
        }
        
        public void setId(int id) {
            this.id = id;
        }
        public String getNome() {
            return nome;
        }
        
        public void adicionarCurso(Cursos cursos){
            this.curso.add(cursos);
        }
        
    Campus campus = new Campus(01, "UAG - Unidade Acadêmica de Garanhuns");  
    

}
