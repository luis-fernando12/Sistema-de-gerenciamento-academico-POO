
public class Disciplina {
    private String codigo;
    private int cargaHoraria;
    private Professor professor;

    public Disciplina(String codigo, int cargaHoraria, Professor professor) {
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public int getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }
    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }
}