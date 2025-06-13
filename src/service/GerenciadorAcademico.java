// GerenciadorAcademico.java
package service;

import model.Disciplina;
import model.Aluno;
import model.Professor;
import model.Matricula;
import model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorAcademico {
    private List<Pessoa> pessoas; // Polimorfismo: Pode conter Alunos e Professores
    private List<Disciplina> disciplinas;
    private List<Matricula> matriculas;

    public GerenciadorAcademico() {
        this.pessoas = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.matriculas = new ArrayList<>();
    }

    // --- Métodos para Pessoas (Alunos e Professores) ---

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        System.out.println(pessoa.getNome() + " adicionado(a) com sucesso!");
    }

    public Pessoa buscarPessoaPorMatricula(String matricula) {
        for (Pessoa p : pessoas) {
            if (p.getMatricula().equals(matricula)) {
                return p;
            }
        }
        return null; // Não encontrou
    }

    public void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }
        System.out.println("\n--- Lista de Pessoas ---");
        for (Pessoa p : pessoas) {
            p.exibirInfo(); // Polimorfismo em ação!
            System.out.println("-----------------------");
        }
    }

    public void removerPessoa(String matricula) {
        Pessoa pessoaParaRemover = buscarPessoaPorMatricula(matricula);
        if (pessoaParaRemover != null) {
            pessoas.remove(pessoaParaRemover);
            System.out.println(pessoaParaRemover.getNome() + " removido(a) com sucesso!");
        } else {
            System.out.println("Pessoa com matrícula " + matricula + " não encontrada.");
        }
    }

    // --- Métodos para Disciplinas ---

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
        System.out.println("Disciplina " + disciplina.getNomeDisciplina() + " adicionada com sucesso!");
    }

    public Disciplina buscarDisciplinaPorCodigo(String codigo) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(codigo)) {
                return d;
            }
        }
        return null; // Não encontrou
    }

    public void listarDisciplinas() {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }
        System.out.println("\n--- Lista de Disciplinas ---");
        for (Disciplina d : disciplinas) {
            d.exibirInfo();
            System.out.println("----------------------------");
        }
    }

    public void removerDisciplina(String codigo) {
        Disciplina disciplinaParaRemover = buscarDisciplinaPorCodigo(codigo);
        if (disciplinaParaRemover != null) {
            disciplinas.remove(disciplinaParaRemover);
            System.out.println("Disciplina " + disciplinaParaRemover.getNomeDisciplina() + " removida com sucesso!");
        } else {
            System.out.println("Disciplina com código " + codigo + " não encontrada.");
        }
    }

    // --- Métodos para Matrículas ---

    public void adicionarMatricula(Matricula matricula) {
        matriculas.add(matricula);
        System.out.println("Matrícula realizada com sucesso para " + matricula.getAluno().getNome() + " na disciplina " + matricula.getDisciplina().getNomeDisciplina() + "!");
    }

    public Matricula buscarMatricula(String matriculaAluno, String codigoDisciplina) {
        for (Matricula m : matriculas) {
            if (m.getAluno().getMatricula().equals(matriculaAluno) && m.getDisciplina().getCodigo().equals(codigoDisciplina)) {
                return m;
            }
        }
        return null;
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
        System.out.println("---------------------------");
    }

    public void removerMatricula(String matriculaAluno, String codigoDisciplina) {
        Matricula matriculaParaRemover = buscarMatricula(matriculaAluno, codigoDisciplina);
        if (matriculaParaRemover != null) {
            matriculas.remove(matriculaParaRemover);
            System.out.println("Matrícula de " + matriculaParaRemover.getAluno().getNome() + " na disciplina " + matriculaParaRemover.getDisciplina().getNomeDisciplina() + " removida com sucesso!");
        } else {
            System.out.println("Matrícula não encontrada.");
        }
    }
}