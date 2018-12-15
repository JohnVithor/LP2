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
public class ProfessorIntegral extends Professor {
    
    private double salario;
    
    public ProfessorIntegral() {
    }

    public ProfessorIntegral(double salario) {
        this.salario = salario;
    }

    public ProfessorIntegral(double salario, String nome, String matricula, int idade) {
        super(nome, matricula, idade);
        this.salario = salario;
    }
    
    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public void printData() {
        System.out.println("nome: " + getNome());
        System.out.println("matricula: " + getMatricula());
        System.out.println("idade: " + getIdade());
        System.out.println("salario: " + salario);
    }
}
