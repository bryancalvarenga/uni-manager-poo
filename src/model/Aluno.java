package model;

// Aluno faz tudo que a classe mãe Pessoa faz
public class Aluno extends Pessoa {
    private String cursoPreferido;

    public Aluno(int id, String nome, String cursoPreferido) {
        // super: está sendo usado da classe mãe
        super(id, nome);
        // this: está sendo usado dessa mesma classe
        this.cursoPreferido = cursoPreferido;
    }

    // Gatter
    public String getCursoPreferido() {
        return cursoPreferido;
    }

    // Setter
    public void setCursoPreferido(String c) {
        this.cursoPreferido = c;
    }

    // Sobrescrevendo resumo da classe mãe Pessoa
    @Override
    public String resumo() {
        return "Aluno: " + super.resumo();
    }
}
