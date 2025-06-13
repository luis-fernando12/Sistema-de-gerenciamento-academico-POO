// MenuConsole.java
package ui;

import service.GerenciadorAcademico;
import model.Disciplina;
import model.Aluno;
import model.Professor;
import model.Matricula;
import model.Pessoa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsole {
    private GerenciadorAcademico gerenciador;
    private Scanner scanner;

    public MenuConsole() {
        this.gerenciador = new GerenciadorAcademico();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Sistema Acadêmico ---");
            System.out.println("1. Gerenciar Pessoas (Alunos/Professores)");
            System.out.println("2. Gerenciar Disciplinas");
            System.out.println("3. Gerenciar Matrículas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha
                switch (opcao) {
                    case 1:
                        menuPessoas();
                        break;
                    case 2:
                        menuDisciplinas();
                        break;
                    case 3:
                        menuMatriculas();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpar o buffer do scanner
                opcao = -1; // Para manter o loop
            }

        } while (opcao != 0);
    }

    private void menuPessoas() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Pessoas ---");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Adicionar Professor");
            System.out.println("3. Listar Todas as Pessoas");
            System.out.println("4. Buscar Pessoa por Matrícula");
            System.out.println("5. Remover Pessoa");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        adicionarAluno();
                        break;
                    case 2:
                        adicionarProfessor();
                        break;
                    case 3:
                        gerenciador.listarPessoas();
                        break;
                    case 4:
                        buscarPessoa();
                        break;
                    case 5:
                        removerPessoa();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                opcao = -1;
            }
        } while (opcao != 0);
    }

    private void adicionarAluno() {
        System.out.print("Nome do Aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula do Aluno: ");
        String matricula = scanner.nextLine();
        System.out.print("Curso do Aluno: ");
        String curso = scanner.nextLine();
        gerenciador.adicionarPessoa(new Aluno(nome, matricula, curso));
    }

    private void adicionarProfessor() {
        System.out.print("Nome do Professor: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula do Professor: ");
        String matricula = scanner.nextLine();
        System.out.print("Departamento do Professor: ");
        String departamento = scanner.nextLine();
        gerenciador.adicionarPessoa(new Professor(nome, matricula, departamento));
    }

    private void buscarPessoa() {
        System.out.print("Digite a matrícula da pessoa para buscar: ");
        String matricula = scanner.nextLine();
        Pessoa p = gerenciador.buscarPessoaPorMatricula(matricula);
        if (p != null) {
            System.out.println("\n--- Informações da Pessoa ---");
            p.exibirInfo();
            System.out.println("----------------------------");
        } else {
            System.out.println("Pessoa com matrícula " + matricula + " não encontrada.");
        }
    }

    private void removerPessoa() {
        System.out.print("Digite a matrícula da pessoa para remover: ");
        String matricula = scanner.nextLine();
        gerenciador.removerPessoa(matricula);
    }

    private void menuDisciplinas() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Disciplinas ---");
            System.out.println("1. Adicionar Disciplina");
            System.out.println("2. Listar Disciplinas");
            System.out.println("3. Buscar Disciplina por Código");
            System.out.println("4. Remover Disciplina");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        adicionarDisciplina();
                        break;
                    case 2:
                        gerenciador.listarDisciplinas();
                        break;
                    case 3:
                        buscarDisciplina();
                        break;
                    case 4:
                        removerDisciplina();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                opcao = -1;
            }
        } while (opcao != 0);
    }

    private void adicionarDisciplina() {
        System.out.print("Código da Disciplina: ");
        String codigo = scanner.nextLine();
        System.out.print("Nome da Disciplina: ");
        String nomeDisciplina = scanner.nextLine();
        System.out.print("Matrícula do Professor (deixe em branco se não houver): ");
        String matriculaProfessor = scanner.nextLine();

        Professor professor = null;
        if (!matriculaProfessor.isEmpty()) {
            Pessoa p = gerenciador.buscarPessoaPorMatricula(matriculaProfessor);
            if (p instanceof Professor) {
                professor = (Professor) p;
            } else if (p == null) {
                System.out.println("Professor com matrícula " + matriculaProfessor + " não encontrado. Disciplina será criada sem professor.");
            } else {
                System.out.println("A matrícula " + matriculaProfessor + " pertence a um Aluno, não a um Professor. Disciplina será criada sem professor.");
            }
        }
        gerenciador.adicionarDisciplina(new Disciplina(codigo, nomeDisciplina, professor));
    }

    private void buscarDisciplina() {
        System.out.print("Digite o código da disciplina para buscar: ");
        String codigo = scanner.nextLine();
        Disciplina d = gerenciador.buscarDisciplinaPorCodigo(codigo);
        if (d != null) {
            System.out.println("\n--- Informações da Disciplina ---");
            d.exibirInfo();
            System.out.println("---------------------------------");
        } else {
            System.out.println("Disciplina com código " + codigo + " não encontrada.");
        }
    }

    private void removerDisciplina() {
        System.out.print("Digite o código da disciplina para remover: ");
        String codigo = scanner.nextLine();
        gerenciador.removerDisciplina(codigo);
    }

    private void menuMatriculas() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Matrículas ---");
            System.out.println("1. Realizar Nova Matrícula");
            System.out.println("2. Listar Todas as Matrículas");
            System.out.println("3. Remover Matrícula");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        realizarMatricula();
                        break;
                    case 2:
                        gerenciador.listarMatriculas();
                        break;
                    case 3:
                        removerMatricula();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                opcao = -1;
            }
        } while (opcao != 0);
    }

    private void realizarMatricula() {
        System.out.print("Matrícula do Aluno: ");
        String matriculaAluno = scanner.nextLine();
        Aluno aluno = null;
        Pessoa p = gerenciador.buscarPessoaPorMatricula(matriculaAluno);
        if (p instanceof Aluno) {
            aluno = (Aluno) p;
        } else {
            System.out.println("Aluno com matrícula " + matriculaAluno + " não encontrado ou não é um aluno.");
            return;
        }

        System.out.print("Código da Disciplina: ");
        String codigoDisciplina = scanner.nextLine();
        Disciplina disciplina = gerenciador.buscarDisciplinaPorCodigo(codigoDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina com código " + codigoDisciplina + " não encontrada.");
            return;
        }

        System.out.print("Turma: ");
        String turma = scanner.nextLine();

        try {
            gerenciador.adicionarMatricula(new Matricula(aluno, disciplina, turma));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao realizar matrícula: " + e.getMessage());
        }
    }

    private void removerMatricula() {
        System.out.print("Matrícula do Aluno da matrícula a ser removida: ");
        String matriculaAluno = scanner.nextLine();
        System.out.print("Código da Disciplina da matrícula a ser removida: ");
        String codigoDisciplina = scanner.nextLine();
        gerenciador.removerMatricula(matriculaAluno, codigoDisciplina);
    }

    public static void main(String[] args) {
        MenuConsole sistema = new MenuConsole();
        sistema.exibirMenu();
    }
}