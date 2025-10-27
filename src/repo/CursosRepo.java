package repo;

import model.Curso;

import java.util.ArrayList;

public class CursosRepo {
    private final ArrayList<Curso> cursos = new ArrayList<>();

    // Adiciona um curso
    public void add(Curso c) {
        cursos.add(c);
    }

    // Busca curso por código
    public Curso porCodigo(int codigo) {
        for (Curso c : cursos) if (c.getCodigo() == codigo) return c;
        return null;
    }

    // Tista todos os cursos
    public ArrayList<Curso> todos() {
        return cursos;
    }
}
