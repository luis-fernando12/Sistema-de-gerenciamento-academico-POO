// Pessoa.java
package model;

public class Pessoa {
    private String nome;
    private String matricula;

    public Pessoa(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // Polimorfismo: Método a ser sobrescrito
    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
    }
}