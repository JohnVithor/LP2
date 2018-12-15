/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabancaria;

/**
 *
 * @author johnvithor
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.criarContaEspecial(new ContaEspecial(2000.0, "Jose", 12324, 120.5));
        banco.criarContaPoupanca(new ContaPoupanca(15, "Maria", 18737, 30.0));
        banco.imprimirContas();
    }
    
}
