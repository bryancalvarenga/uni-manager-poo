package app;

import model.Aluno;
import model.Curso;
import model.Professor;
import model.NivelCurso;
import repo.CursosRepo;
import repo.MatriculasRepo;
import repo.PessoasRepo;
import service.MatriculaService;

import java.util.Scanner;

public class Main {
    private static final PessoasRepo pessoas = new PessoasRepo();
    private static final CursosRepo cursos = new CursosRepo();
    private static final MatriculasRepo mats = new MatriculasRepo();
    private static final MatriculaService svc = new MatriculaService(pessoas, cursos, mats);

    public static void main(String[] args) {
        seed(); // cria dados iniciais (um Aluno #1, um Professor #2, dois cursos 101/102).
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1) Listar pessoas  2) Listar cursos  3) Matricular  4) Buscar pessoa  0) Sair");

            // Loop do menu com Scanner (escolha do usuário)
            switch (sc.nextLine()) {
                // "1" → lista pessoas
                // Usa p.resumo() (interface Imprimivel).
                // Demonstra polimorfismo + instanceof para imprimir detalhes específicos:
                // se Professor → salário
                // se Aluno → cursoPreferido
                case "1" -> pessoas.todas().forEach(p -> {
                    System.out.println(p.resumo());
                    if (p instanceof Professor prof) System.out.println("   (salário: " + prof.getSalario() + ")");
                    if (p instanceof Aluno a) System.out.println("   (pref: " + a.getCursoPreferido() + ")");
                });
                // "2" → lista cursos
                // Mostra resumo() e (opcional) ocupação: matriculados/limite
                case "2" -> cursos.todos().forEach(c -> System.out.println(c.resumo()));

                //"3" → matricular (lê ids e chama MatriculaService dentro de try/catch)
                case "3" -> {
                    try {
                        System.out.print("ID do aluno: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Código do curso: ");
                        int cod = Integer.parseInt(sc.nextLine());
                        svc.matricular(id, cod);
                        System.out.println("Matrícula realizada!");
                    } catch (Exception e) { System.out.println("Falha: " + e.getMessage()); }
                }
                // "4" → buscar pessoa por nome (usa PessoasRepo.buscarPorNome com indexOf)
                case "4" -> {
                    System.out.print("Buscar por nome: ");
                    pessoas.buscarPorNome(sc.nextLine())
                            .forEach(p -> System.out.println("→ " + p.resumo()));
                }

                case "0" -> { System.out.println("Até mais!"); return; }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void seed() {
        pessoas.add(new Aluno(1, "Bryan", "Java"));
        pessoas.add(new Professor(2, "Ana Prof", 8500));
        cursos.add(new Curso(101, "POO com Java", NivelCurso.INTERMEDIARIO, 2));
        cursos.add(new Curso(102, "Estruturas de Dados", NivelCurso.AVANCADO, 1));
    }
}
