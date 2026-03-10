# UniManager — Projeto de Estudos em Java (POO)

> Aplicação de console criada para praticar os **principais conceitos de Programação Orientada a Objetos (POO)** em Java.  
> O projeto simula o gerenciamento de **pessoas (alunos e professores)**, **cursos** e **matrículas**, utilizando uma estrutura limpa e modular.

---

## Objetivos de aprendizado

- Dominar os **fundamentos da POO**: classes, objetos, construtores, encapsulamento, herança e polimorfismo.  
- Entender a importância de **interfaces**, **classes abstratas** e **enums**.  
- Praticar **coleções dinâmicas** com `ArrayList` e métodos como `add()`, `size()` e `indexOf()`.  
- Utilizar **tratamento de exceções (try/catch)** para garantir estabilidade.  
- Trabalhar com **arquitetura em camadas** (app → service → repo → model).

---

## Estrutura do projeto

```
src/
  app/            → Interface de linha de comando (Main)
  model/          → Entidades do domínio (regas + dados)
  repo/           → Repositórios em memória (ArrayList)
  service/        → Regras de negócio que combinam entidades
```

### Diagrama simplificado

```
  +-------------+
  |   app.Main  | ← menu e interação com usuário
  +------+------+
         |
         v
  +------+-------+
  | service.MatriculaService |
  +------+-------+
         |
         v
  +------+------+
  | repos (ArrayList) |
  +------+------+
         |
         v
  +-------------+
  |  models (POO) |
  +-------------+
```

---

## Como executar

### Compilar
Na raiz do projeto:
```bash
javac -d out src/app/Main.java src/model/*.java src/repo/*.java src/service/*.java
```

### Rodar
```bash
java -cp out app.Main
```

---

## Funcionalidades

| Função | Descrição |
|--------|------------|
| `Listar pessoas` | Mostra alunos e professores cadastrados |
| `Listar cursos` | Lista cursos disponíveis e seus níveis |
| `Matricular` | Cadastra um aluno em um curso com validações |
| `Buscar pessoa` | Pesquisa por nome (usa `indexOf`) |
| `Sair` | Encerra o programa |

---

## Conceitos aplicados

| Conceito | Onde aparece | Explicação |
|-----------|---------------|------------|
| **Classe/Objeto** | Todas as entidades | Base da POO |
| **Encapsulamento** | `private` + getters/setters | Protege dados |
| **Construtores** | Em todas as classes | Inicializam atributos |
| **Herança** | `Pessoa → Aluno/Professor` | Reuso e hierarquia |
| **Polimorfismo** | `resumo()` + `Imprimivel` | Mesmo método, diferentes comportamentos |
| **Sobrescrita (@Override)** | `resumo()` nas subclasses | Personaliza saída |
| **Interface** | `Imprimivel` | Contrato comum |
| **Classe abstrata** | `Pessoa` | Molde sem instância direta |
| **Enum** | `NivelCurso` | Conjunto fixo de constantes |
| **ArrayList** | Repositórios | Armazenamento dinâmico |
| **indexOf** | Busca por nome | Localiza substring |
| **instanceof** | Verificação de tipo | Garante segurança ao usar herança |
| **Exceptions** | `try/catch` | Lida com erros de forma controlada |
| **static/final** | IDs e repositórios únicos | Imutabilidade e controle global |

---

## Fluxo de matrícula

1. Usuário escolhe **“Matricular”**.  
2. Informa o **ID do aluno** e o **código do curso**.  
3. `MatriculaService` valida:
   - Se a pessoa existe (`porId`)
   - Se é um `Aluno` (`instanceof`)
   - Se o curso existe e tem vaga (`temVaga()`)
4. Cria uma nova `Matricula` e salva nos repositórios.

---

## Tecnologias utilizadas

- **Java 17+**
- **VS Code** ou qualquer IDE
- **Coleções e classes utilitárias (`ArrayList`, `Scanner`, `Exception`)**
