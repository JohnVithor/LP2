/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora;

/**
 *
 * @author johnvithor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        Locadora locadora = new Locadora();
        Moto batation = new Moto("Eletrica", 200.0, "Batation",
                                 "Inglesa", "123456-8", true);
        locadora.cadastrarMoto(batation);
        locadora.cadastrarCarro(2.7, 4, "Jerimunion", "Papaya",
                                "789456-1");
        locadora.printVeiculos();
        locadora.alugarVeiculo("JV", "456654", batation);
        locadora.printAlugados();
        locadora.novoDia();
        locadora.printClientes();
    }
}
