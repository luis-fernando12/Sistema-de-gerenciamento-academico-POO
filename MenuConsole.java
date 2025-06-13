package com.sistema.academico;

import java.util.InputMismatchException; 
import java.util.Scanner;

public class MenuConsole {
    private GerenciadorAcademico gerenciador;
    private Scanner scanner; 

    public MenuConsole() {
        this.gerenciador = new GerenciadorAcademico();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenuPrincipal(); 
            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    menuAlunos(); 
                    break;
                case 2:
                    menuProfessores(); 
                    break;
                case 3:
                    menuDisciplinas(); 
                    break;
                case 4:
                    menuMatriculas();
                    break;
                case 5:
                    menuConsultasAvancadas();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
        scanner.close(); 
    }

    private void exibirMenuPrincipal() {
        System.out.println("\n--- Menu Principal do Sistema Acadêmico ---");
        System.out.println("1. Gerenciar Alunos");
        System.out.println("2. Gerenciar Professores");
        System.out.println("3. Gerenciar Disciplinas");
        System.out.println("4. Gerenciar Matrículas");
        System.out.println("5. Consultas Avançadas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void menuAlunos() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Alunos ---");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Buscar Aluno por Matrícula");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    adicionarAluno();
                    break;
                case 2:
                    gerenciador.listarAlunos();
                    break;
                case 3:
                    buscarAluno();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarAluno() {
        System.out.print("Nome do Aluno: ");
        scanner.nextLine(); 
        String nome = scanner.nextLine();
        System.out.print("Email do Aluno: ");
        String email = scanner.nextLine();
        System.out.print("Matrícula do Aluno: ");
        int matricula = lerInteiro();
        System.out.print("Curso do Aluno: ");
        scanner.nextLine(); 
        String curso = scanner.nextLine();

        Aluno novoAluno = new Aluno(nome, email, matricula, curso);
        gerenciador.adicionarAluno(novoAluno);
    }

    private void buscarAluno() {
        System.out.print("Digite a matrícula do aluno a buscar: ");
        int matricula = lerInteiro();
        Aluno alunoEncontrado = gerenciador.buscarAlunoPorMatricula(matricula);
        if (alunoEncontrado != null) {
            System.out.println("Aluno encontrado:");
            alunoEncontrado.exibirInfo();
        } else {
            System.out.println("Aluno com matrícula " + matricula + " não encontrado.");
        }
    }

    private void menuProfessores() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Professores ---");
            System.out.println("1. Adicionar Professor");
            System.out.println("2. Listar Professores");
            System.out.println("3. Buscar Professor por Nome");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    adicionarProfessor();
                    break;
                case 2:
                    gerenciador.listarProfessores();
                    break;
                case 3:
                    buscarProfessor();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarProfessor() {
        System.out.print("Nome do Professor: ");
        scanner.nextLine(); 
        String nome = scanner.nextLine();
        System.out.print("Email do Professor: ");
        String email = scanner.nextLine();
        System.out.print("Departamento do Professor: ");
        String departamento = scanner.nextLine();
        System.out.print("Especialização do Professor: ");
        String especializacao = scanner.nextLine();

        Professor novoProfessor = new Professor(nome, email, departamento, especializacao);
        gerenciador.adicionarProfessor(novoProfessor);
    }

    private void buscarProfessor() {
        System.out.print("Digite o nome do professor a buscar: ");
        scanner.nextLine(); 
        String nome = scanner.nextLine();
        Professor professorEncontrado = gerenciador.buscarProfessorPorNome(nome);
        if (professorEncontrado != null) {
            System.out.println("Professor encontrado:");
            professorEncontrado.exibirInfo();
        } else {
            System.out.println("Professor '" + nome + "' não encontrado.");
        }
    }

    private void menuDisciplinas() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Disciplinas ---");
            System.out.println("1. Adicionar Disciplina");
            System.out.println("2. Listar Disciplinas");
            System.out.println("3. Buscar Disciplina por Código");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();

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
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarDisciplina() {
        System.out.print("Código da Disciplina: ");
        scanner.nextLine(); 
        String codigo = scanner.nextLine();
        System.out.print("Nome da Disciplina: ");
        String nome = scanner.nextLine();
        System.out.print("Carga Horária da Disciplina (em horas): ");
        int cargaHoraria = lerInteiro();

        System.out.print("Nome do Professor da Disciplina (deixe vazio se nenhum): ");
        scanner.nextLine(); 
        String nomeProfessor = scanner.nextLine();
        Professor professor = null;
        if (!nomeProfessor.isEmpty()) {
            professor = gerenciador.buscarProfessorPorNome(nomeProfessor);
            if (professor == null) {
                System.out.println("Professor '" + nomeProfessor + "' não encontrado. Disciplina será adicionada sem professor atribuído.");
            }
        }

        Disciplina novaDisciplina = new Disciplina(codigo, nome, cargaHoraria, professor);
        gerenciador.adicionarDisciplina(novaDisciplina);
    }

    private void buscarDisciplina() {
        System.out.print("Digite o código da disciplina a buscar: ");
        scanner.nextLine();
        String codigo = scanner.nextLine();
        Disciplina disciplinaEncontrada = gerenciador.buscarDisciplinaPorCodigo(codigo);
        if (disciplinaEncontrada != null) {
            System.out.println("Disciplina encontrada:");
            disciplinaEncontrada.exibirInfo();
        } else {
            System.out.println("Disciplina com código " + codigo + " não encontrada.");
        }
    }

    private void menuMatriculas() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Matrículas ---");
            System.out.println("1. Realizar Matrícula");
            System.out.println("2. Listar Matrículas");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    realizarMatricula();
                    break;
                case 2:
                    gerenciador.listarMatriculas();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void realizarMatricula() {
        System.out.print("Matrícula do Aluno: ");
        int matriculaAluno = lerInteiro();
        Aluno aluno = gerenciador.buscarAlunoPorMatricula(matriculaAluno);
        if (aluno == null) {
            System.out.println("Aluno com matrícula " + matriculaAluno + " não encontrado.");
            return;
        }

        System.out.print("Código da Disciplina: ");
        scanner.nextLine(); 
        String codigoDisciplina = scanner.nextLine();
        Disciplina disciplina = gerenciador.buscarDisciplinaPorCodigo(codigoDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina com código " + codigoDisciplina + " não encontrada.");
            return;
        }

        System.out.print("Turma da Matrícula: ");
        String turma = scanner.nextLine();

        Matricula novaMatricula = new Matricula(aluno, disciplina, turma);
        gerenciador.adicionarMatricula(novaMatricula);
    }

    private void menuConsultasAvancadas() {
        int opcao;
        do {
            System.out.println("\n--- Consultas Avançadas ---");
            System.out.println("1. Listar Disciplinas por Professor");
            System.out.println("2. Listar Alunos por Disciplina");
            System.out.println("3. Listar Disciplinas de um Aluno");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do professor: ");
                    scanner.nextLine();
                    String nomeProf = scanner.nextLine();
                    gerenciador.listarDisciplinasPorProfessor(nomeProf);
                    break;
                case 2:
                    System.out.print("Digite o código da disciplina: ");
                    scanner.nextLine();
                    String codDisc = scanner.nextLine();
                    gerenciador.listarAlunosPorDisciplina(codDisc);
                    break;
                case 3:
                    System.out.print("Digite a matrícula do aluno: ");
                    int matAluno = lerInteiro();
                    gerenciador.listarDisciplinasPorAluno(matAluno);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private int lerInteiro() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine(); 
                System.out.print("Escolha uma opção: ");
            }
        }
    }

    public static void main(String[] args) {
        MenuConsole sistemaAcademico = new MenuConsole();
        sistemaAcademico.iniciar();
    }
}
