public class ConflitoDeHorarioException extends Exception {
    public ConflitoDeHorarioException(String message) {
        super(message);
    }
}

public class Disciplina {
    private Horario horario;

    // construtor e métodos

    public void setHorario(Horario horario) throws ConflitoDeHorarioException {
        // Verifica se já existe uma disciplina agendada para o horário informado
        if (existeDisciplinaNoHorario(horario)) {
            throw new ConflitoDeHorarioException("Já existe uma disciplina agendada para o horário informado.");
        }

        this.horario = horario;
    }

    // outros métodos
}

public class Main {
    public static void main(String[] args) {
        Disciplina d1 = new Disciplina("Matemática");
        Disciplina d2 = new Disciplina("Português");

        try {
            // Tentativa de agendar duas disciplinas para o mesmo horário
            d1.setHorario(new Horario(8, 0));
            d2.setHorario(new Horario(8, 0));
        } catch (ConflitoDeHorarioException e) {
            System.out.println(e.getMessage());
        }
    }
}
