package com.sistema.academico;

import java.util.ArrayList;
import java.util.List;

class GerenciadorAcademico {
    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Disciplina> disciplinas;
    private List<Matricula> matriculas;
    
    public GerenciadorAcademico() {
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.matriculas = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        if (!alunos.contains(aluno)) {
            this.alunos.add(aluno);
            System.out.println("Aluno " + aluno.getNome() + " adicionado com sucesso.");
        } else {
            System.out.println("Erro: Aluno com matrícula " + aluno.getMatricula() + " já existe.");
        }
    }

    public void adicionarProfessor(Professor professor) {
        if (!professores.contains(professor)) {
            this.professores.add(professor);
            System.out.println("Professor " + professor.getNome() + " adicionado com sucesso.");
        } else {
            System.out.println("Erro: Professor " + professor.getNome() + " já existe.");
        }
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (!disciplinas.contains(disciplina)) {
            this.disciplinas.add(disciplina);
            System.out.println("Disciplina " + disciplina.getNome() + " adicionada com sucesso.");
        } else {
            System.out.println("Erro: Disciplina com código " + disciplina.getCodigo() + " já existe.");
        }
    }

    public void adicionarMatricula(Matricula matricula) {
        boolean alunoExiste = alunos.contains(matricula.getAluno());
        boolean disciplinaExiste = disciplinas.contains(matricula.getDisciplina());

        if (alunoExiste && disciplinaExiste) {
            if (!matriculas.contains(matricula)) {
                this.matriculas.add(matricula);
                System.out.println("Matrícula realizada com sucesso para o aluno " + matricula.getAluno().getNome() + " na disciplina " + matricula.getDisciplina().getNome() + ".");
            } else {
                System.out.println("Erro: Matrícula para o aluno " + matricula.getAluno().getNome() + " na disciplina " + matricula.getDisciplina().getNome() + " e turma " + matricula.getTurma() + " já existe.");
            }
        } else {
            if (!alunoExiste) {
                System.out.println("Erro: Aluno " + matricula.getAluno().getNome() + " não encontrado para realizar a matrícula.");
            }
            if (!disciplinaExiste) {
                System.out.println("Erro: Disciplina " + matricula.getDisciplina().getNome() + " não encontrada para realizar a matrícula.");
            }
        }
    }

    public Aluno buscarAlunoPorMatricula(int matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula() == matricula) {
                return a;
            }
        }
        return null;
    }

    public Professor buscarProfessorPorNome(String nome) {
        for (Professor p : professores) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public Disciplina buscarDisciplinaPorCodigo(String codigo) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equalsIgnoreCase(codigo)) {
                return d;
            }
        }
        return null;
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        System.out.println("\n--- Lista de Alunos ---");
        for (Aluno a : alunos) {
            a.exibirInfo();
        }
    }

    public void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }
        System.out.println("\n--- Lista de Professores ---");
        for (Professor p : professores) {
            p.exibirInfo();
        }
    }

    public void listarDisciplinas() {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }
        System.out.println("\n--- Lista de Disciplinas ---");
        for (Disciplina d : disciplinas) {
            d.exibirInfo();
        }
    }

    public void listarMatriculas() {
        if (matriculas.isEmpty()) {
            System.out.println("Nenhuma matrícula realizada.");
            return;
        }
        System.out.println("\n--- Lista de Matrículas ---");
        for (Matricula m : matriculas) {
            m.exibirInfo();
        }
    }

    public void listarDisciplinasPorProfessor(String nomeProfessor) {
        Professor professor = buscarProfessorPorNome(nomeProfessor);
        if (professor == null) {
            System.out.println("Professor '" + nomeProfessor + "' não encontrado.");
            return;
        }

        System.out.println("\n--- Disciplinas ministradas por " + professor.getNome() + " ---");
        boolean encontrou = false;
        for (Disciplina d : disciplinas) {
            if (d.getProfessor() != null && d.getProfessor().equals(professor)) {
                d.exibirInfo();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma disciplina encontrada para este professor.");
        }
    }

    public void listarAlunosPorDisciplina(String codigoDisciplina) {
        Disciplina disciplina = buscarDisciplinaPorCodigo(codigoDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina com código '" + codigoDisciplina + "' não encontrada.");
            return;
        }

        System.out.println("\n--- Alunos matriculados em " + disciplina.getNome() + " ---");
        boolean encontrou = false;
        for (Matricula m : matriculas) {
            if (m.getDisciplina().equals(disciplina)) {
                m.getAluno().exibirInfo();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum aluno matriculado nesta disciplina.");
        }
    }

    public void listarDisciplinasPorAluno(int matriculaAluno) {
        Aluno aluno = buscarAlunoPorMatricula(matriculaAluno);
        if (aluno == null) {
            System.out.println("Aluno com matrícula '" + matriculaAluno + "' não encontrado.");
            return;
        }

        System.out.println("\n--- Disciplinas matriculadas pelo aluno " + aluno.getNome() + " ---");
        boolean encontrou = false;
        for (Matricula m : matriculas) {
            if (m.getAluno().equals(aluno)) {
                m.getDisciplina().exibirInfo();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma disciplina encontrada para este aluno.");
        }
    }
}
