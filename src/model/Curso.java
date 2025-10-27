package model;

import java.util.ArrayList;

public class Curso implements Imprimivel{
    private final int codigo; // imutável: código do curso
    private String titulo;
    // Constantes do enum
    private NivelCurso nivel;
    private int capacidadeMax;
    // Lista dos Ids dos alunos matriculados
    private ArrayList<Integer> alunosMatriculadosIds = new ArrayList<>();

    // Constructor
    public Curso(int codigo, String titulo, NivelCurso nivel, int capacidadeMax) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.nivel = nivel;
        this.capacidadeMax = capacidadeMax;
    }
    // Gatter
    public int getCodigo() {
        return codigo;
    }
    // Gatter
    public String getTitulo() {
        return titulo;
    }
    // Setter
    public void setTitulo(String t) {
        this.titulo = t;
    }
    // Gatter
    public NivelCurso getNivel() {
        return nivel;
    }
    // Setter
    public void setNivel(NivelCurso n) {
        this.nivel = n;
    }
    // Gatter
    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    // Verifica se tem vaga
    public boolean temVaga() {
        return alunosMatriculadosIds.size() <  capacidadeMax;
    }

    // Adiciona aluno
    public void adicionarAluno(int alunoId) {
        alunosMatriculadosIds.add(alunoId);
    }

    public ArrayList<Integer> getAlunosMatriculadosIds() {
        return alunosMatriculadosIds;
    }

    public String resumo() {
        return codigo + " - " +  titulo + " ( " + nivel + ")";
    }
}
