// Matricula.java
package model;

public class Matricula {
    private Aluno aluno;       // Associação
    private Disciplina disciplina; // Associação
    private String turma;

    public Matricula(Aluno aluno, Disciplina disciplina, String turma) {
        if (aluno == null || disciplina == null) {
            throw new IllegalArgumentException("Aluno e Disciplina não podem ser nulos para uma matrícula.");
        }
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não pode ser nulo.");
        }
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina não pode ser nula.");
        }
        this.disciplina = disciplina;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        if (turma == null || turma.trim().isEmpty()) {
            throw new IllegalArgumentException("Turma não pode ser vazia.");
        }
        this.turma = turma;
    }

    public void exibirInfo() {
        System.out.println("--- Detalhes da Matrícula ---");
        System.out.println("Aluno:");
        aluno.exibirInfo();
        System.out.println("Disciplina:");
        disciplina.exibirInfo();
        System.out.println("Turma: " + turma);
        System.out.println("-----------------------------");
    }
}