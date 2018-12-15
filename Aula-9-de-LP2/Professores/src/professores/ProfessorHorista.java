/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package professores;

/**
 *
 * @author johnvithor
 */
public class ProfessorHorista extends Professor {

    private int totalHoras;
    private String salarioHora;
    
    public ProfessorHorista() {
    }

    public ProfessorHorista(int totalHoras, String salarioHora) {
        this.totalHoras = totalHoras;
        this.salarioHora = salarioHora;
    }

    public ProfessorHorista(int totalHoras, String salarioHora, String nome, String matricula, int idade) {
        super(nome, matricula, idade);
        this.totalHoras = totalHoras;
        this.salarioHora = salarioHora;
    }

    /**
     * @return the totalHoras
     */
    public int getTotalHoras() {
        return totalHoras;
    }

    /**
     * @param totalHoras the totalHoras to set
     */
    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }

    /**
     * @return the salarioHora
     */
    public String getSalarioHora() {
        return salarioHora;
    }

    /**
     * @param salarioHora the salarioHora to set
     */
    public void setSalarioHora(String salarioHora) {
        this.salarioHora = salarioHora;
    }
    
    public double salario() {
        return Double.parseDouble(salarioHora) * totalHoras;   
    }
    
    public void printData() {
        System.out.println("nome: " + getNome());
        System.out.println("matricula: " + getMatricula());
        System.out.println("idade: " + getIdade());
        System.out.println("totalHoras: " + totalHoras);
        System.out.println("salarioHora: " + salarioHora);
    }
}
