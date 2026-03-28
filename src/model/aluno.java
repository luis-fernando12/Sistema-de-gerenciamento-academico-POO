// Aluno.java
package model;

public class Aluno extends Pessoa {
    private String curso;

    public Aluno(String nome, String matricula, String curso) {
        super(nome, matricula); // Chama o construtor da classe base (Pessoa)
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo(); // Chama o método exibirInfo() da classe base
        System.out.println("Curso: " + curso);
    }
}