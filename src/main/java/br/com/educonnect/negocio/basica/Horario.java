package src.main.java.br.com.educonnect.negocio.basica;
import java.util.Timer;

public class Horario {
    private String id;
    private Timer horario;
    
    public Horario(){
    this.id = id;
    this.horario = horario;
    }
    
    public Timer getHorario(){
        return horario;
    }
    
    public void setHorario(Timer horario){
        this.horario = horario;
    }

}
