package br.com.educonnect.negocio.cadastro;

import java.util.List;

import br.com.educonnect.negocio.basica.Curso;

public interface ICadastroCurso {

    Curso encontrarCursoId(long id) throws CursoNaoExisteException;

    List<Curso> listarCursos();

    void deletarCursoId(long id);

    Curso salvarCurso(Curso curso);

    Curso atualizarCurso(Curso curso, long id) throws CursoNaoExisteException;

}
