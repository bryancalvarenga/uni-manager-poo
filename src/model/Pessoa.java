package model;

public abstract class Pessoa implements Imprimivel {
    private final int id;  // final: imutável
    private String nome;

    // Constructor com argumento
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Gatter do id
    public int getId() {
        return id;
    }

    // Gatter do nome
    public String getNome() {
        return nome;
    }

    // Setter do nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Sobrescrevendo equeleto da interface Imprimivel
    @Override
    public String resumo() {
        return id + " - " + nome;
    }
}
