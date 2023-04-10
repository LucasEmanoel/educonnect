package br.com.educonnect.negocio.cadastro;

import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import br.com.educonnect.negocio.basica.Curso;

class CursoNaoEncontradoExceptionTest {


    private CadastroCurso cadastroCurso;
    private Curso curso;

    @Before(value = "")
    public void setup() {
        cadastroCurso = new CadastroCurso();
        curso = new Curso();
    }

    //@Test(expected = CursoNaoEncontradoException.class)
    public void testEncontrarCursoInexistente() throws CursoNaoEncontradoException {
        cadastroCurso.encontrarCursoId(1);
    }
}

