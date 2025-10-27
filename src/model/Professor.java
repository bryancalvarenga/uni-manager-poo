package model;

// Professor também faz tudo que a classe mãe Pessoa faz
public class Professor extends Pessoa {
    private double salario;

    // Segue a mesma ideia do aluno, porém o professor tem o salário
    public Professor(int id, String nome, double salario) {
        super(id, nome);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double s) {
        this.salario = s;
    }

    // Sobrescrevendo resumo da classe mãe Pessoa
    @Override
    public String resumo() {
        return "Professor: " + super.resumo();
    }
}
