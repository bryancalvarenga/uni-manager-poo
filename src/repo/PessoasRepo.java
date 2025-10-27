package repo;

import model.Pessoa;

import java.util.ArrayList;

public class PessoasRepo {
    private final ArrayList<Pessoa> pessoas = new ArrayList<>();
    // Adicionar pessoas a lista
    public void add(Pessoa p) {
        pessoas.add(p);
    }

    // Retorna a pessoa se o Id for igual
    public Pessoa porId(int id) {
        for (Pessoa p : pessoas) if (p.getId() == id) return p;
        return null;
    }

    // Busca por parte do nome usando indexOf em String
    public ArrayList<Pessoa> buscarPorNome(String termo) {

        ArrayList<Pessoa> out = new ArrayList<>();
        for (Pessoa p : pessoas) {
            if (p.getNome().toLowerCase().indexOf(termo.toLowerCase()) >= 0) out.add(p);
        }
        return out;

    }

    // Lista todas
    public ArrayList<Pessoa> todas() {
        return pessoas;
    }

}
