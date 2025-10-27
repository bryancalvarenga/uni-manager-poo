package service;

import model.Aluno;
import model.Curso;
import model.Matricula;
import model.Pessoa;
import repo.CursosRepo;
import repo.MatriculasRepo;
import repo.PessoasRepo;

// Responsável por toda a regra da matrícula
public class MatriculaService {
    private final PessoasRepo pessoas;
    private final CursosRepo cursos;
    private final MatriculasRepo mats;

    public MatriculaService(PessoasRepo p, CursosRepo c, MatriculasRepo m) {
        this.pessoas = p;
        this.cursos = c;
        this.mats = m;
    }

    public void matricular(int alunoId, int cursoCod) throws Exception {
        Pessoa p = pessoas.porId(alunoId);
        if (p == null) throw new Exception("Pessoa não encontrada");

        // Confere se é Aluno
        if (!(p instanceof Aluno)) throw new Exception("Apenas alunos podem se matricular");

        Curso c = cursos.porCodigo(cursoCod);
        if (c == null) throw new Exception("Curso não encontrado");
        if (!c.temVaga()) throw new Exception("Curso cheio");

        c.adicionarAluno(alunoId);
        mats.add(new Matricula(alunoId, cursoCod));
    }
}
