
public class Professor extends Pessoa {
    private String departamento;
    private String especializacao;

    public Professor(String nome, String email, String departamento, String especializacao) {
        super(nome, email);
        this.departamento = departamento;
        this.especializacao = especializacao;
    }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    public String getEspecializacao() { return especializacao; }
    public void setEspecializacao(String especializacao) { this.especializacao = especializacao; }
}