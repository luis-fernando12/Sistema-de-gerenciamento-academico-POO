// Professor.java
package model;

public class Professor extends Pessoa {
    private String departamento;

    public Professor(String nome, String matricula, String departamento) {
        super(nome, matricula); // Chama o construtor da classe base (Pessoa)
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo(); // Chama o método exibirInfo() da classe base
        System.out.println("Departamento: " + departamento);
    }
}