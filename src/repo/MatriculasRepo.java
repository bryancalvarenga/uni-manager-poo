package repo;

import model.Matricula;

import java.util.ArrayList;

public class MatriculasRepo {
    private final ArrayList<Matricula> matriculas = new ArrayList<>();

    public void add(Matricula m) {
        matriculas.add(m);
    }

    public ArrayList<Matricula> todas() {
        return matriculas;
    }
}
