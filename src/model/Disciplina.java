// Disciplina.java
package model;

public class Disciplina {
    private String codigo;
    private String nomeDisciplina;
    private Professor professor; // Composição: Disciplina tem um Professor

    public Disciplina(String codigo, String nomeDisciplina, Professor professor) {
        this.codigo = codigo;
        this.nomeDisciplina = nomeDisciplina;
        this.professor = professor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void exibirInfo() {
        System.out.println("Código da Disciplina: " + codigo);
        System.out.println("Nome da Disciplina: " + nomeDisciplina);
        System.out.println("Professor Responsável:");
        if (professor != null) {
            professor.exibirInfo();
        } else {
            System.out.println("  Nenhum professor atribuído.");
        }
    }
}