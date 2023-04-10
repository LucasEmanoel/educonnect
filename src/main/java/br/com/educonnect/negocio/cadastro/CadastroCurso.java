package br.com.educonnect.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.educonnect.negocio.basica.Curso;
import br.com.educonnect.negocio.fachada.Fachada;

@Component
public class CadastroCurso {

    @Autowired
    private Fachada fachada;

    public Curso salvarCurso(Curso curso) {
        return fachada.salvarCurso(curso);
    }

    public void deletarCurso(long id) throws CursoNaoEncontradoException {
        fachada.deletarCurso(id);
    }

    public Curso encontrarCursoId(long id) throws CursoNaoEncontradoException {
        return fachada.encontrarCursoId(id);
    }

    public List<Curso> listCursos() {
        return fachada.listarCursos();
    }

    public Curso atualizarCurso(Curso curso, long cursoId) throws CursoNaoEncontradoException {
        return fachada.atualizarCurso(curso, cursoId);
    }
}
