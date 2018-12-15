/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabancaria;

import java.util.ArrayList;

/**
 *
 * @author johnvithor
 */
public class Banco {
    /**
     * lista de Contas.
     */
    private final ArrayList<ContaBancaria> contas;
    /**
     *
     */
    public Banco() {
        contas = new ArrayList<>();
    }
    /**
     * @param conta conta ser adicionada
     */
    public final void criarContaPoupanca(final ContaPoupanca conta) {
        contas.add(conta);
    }
    /**
     * @param conta conta ser adicionada
     */
    public final void criarContaEspecial(final ContaEspecial conta) {
        contas.add(conta);
    }
    /**
     * imprime as contas cadastradas.
     */
    public final void imprimirContas() {
        for (ContaBancaria conta : contas) {
            System.out.println(conta);
            System.out.println();
        }
    }
}
