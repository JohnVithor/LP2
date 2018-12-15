/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

/**
 *
 * @author johnvithor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        Deposito deposito = new Deposito();
        Carro carro = new Carro("Preto", 5, "Metal",
                                "10 anos", "C3",
                                300000.0, "Flyer",
                                "Modelo economico", "23/03/2088");
        deposito.adicionarProduto(carro);
        Chocolate chocolate = new Chocolate("Amargo", 300.0,
                                            "23/03/2089", "Comida",
                                            "Chocolate", 17.50,
                                            "ChocoChock", "O chocolate chocante",
                                            "23/03/2088");
        deposito.adicionarProduto(chocolate);
        deposito.produtoMaisCaro();
    }
}
