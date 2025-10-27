package model;

import java.time.LocalDate;

public class Matricula implements Imprimivel {
    private final int alunoId;
    private final int cursoCodigo;
    private final LocalDate data = LocalDate.now(); // Pegar a data
    // Constructor
    public Matricula(int alunoId, int cursoCodigo) {
        this.alunoId = alunoId;
        this.cursoCodigo = cursoCodigo;
    }
    // Gatters
    public int getAlunoId() {
        return alunoId;
    }
    public int getCursoCodigo() {
        return cursoCodigo;
    }
    @Override
    public String resumo() {
        return "Matricula(aluno=" + alunoId + ", curso=" + cursoCodigo + ", data=" + data + ")";
    }
}
