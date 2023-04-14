package br.com.educonnect.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.educonnect.dados.RepositorioCurso;
import br.com.educonnect.negocio.basica.Curso;

@Component
public class CadastroCurso implements ICadastroCurso {

    @Autowired
    private RepositorioCurso repositorioCurso;

    public CadastroCurso(RepositorioCurso repositorioCurso) {
        super();

        this.repositorioCurso = repositorioCurso;
    }

    @Override
    public Curso encontrarCursoId(long id) throws CursoNaoExisteException {
        Curso curso = this.repositorioCurso.findById(id).orElse(null);
        if (curso != null) {
            return curso;
        } else {
            throw new CursoNaoExisteException();
        }
    }

    @Override
    public List<Curso> listarCursos() {
        return this.repositorioCurso.findAll();
    }

    @Override
    public void deletarCursoId(long id) {
        this.repositorioCurso.deleteById(id);
    }

    @Override
    public Curso salvarCurso(Curso curso) {
        return this.repositorioCurso.save(curso);
    }

    @Override
    public Curso atualizarCurso(Curso curso, long id) throws CursoNaoExisteException {
        Curso cursoAntigo = this.encontrarCursoId(id);
        cursoAntigo.setNome(curso.getNome());
        return this.repositorioCurso.save(cursoAntigo);
    }

}
