
public class Main {
    public static void main(String[] args) {
        Professor prof = new Professor(
            "Dr. Alan Turing",
            "alan.turing@bletchleypark.uk",
            "Ciência da Computação",
            "Inteligência Artificial"
        );

        Disciplina dspl = new Disciplina(
            "COMP-123", 60, prof
        );

        System.out.println("--- Detalhes da Disciplina ---");
        System.out.println("Código: " + dspl.getCodigo());
        System.out.println("Carga Horária: " + dspl.getCargaHoraria() + " horas");

        System.out.println("\n--- Professor da Disciplina ---");
        System.out.println("Nome: " + dspl.getProfessor().getNome());
        System.out.println("Especialização: " + dspl.getProfessor().getEspecializacao());
        System.out.println("Departamento: " + dspl.getProfessor().getDepartamento());
    }
}