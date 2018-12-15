/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import java.util.ArrayList;

/**
 *
 * @author johnvithor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new PessoaFisica("123456789-8", "Joaquim", "Rua das Peras",
                                      "9878-9134"));
        clientes.add(new PessoaJuridica("12348616", "Empresa da Pera", "PeraMaster",
                                        "Rua das Peras", "4567-1348"));
        clientes.add(new PessoaJuridica("18948616", "Mercadinho da Pera", "PeraNoob",
                                        "Rua das Peras", "4977-1388"));
        int numeroPessoaFisica = 0;
        int numeroPessoaJuridica = 0;
        for (Cliente cliente : clientes) {
            cliente.imprimirDados();
            System.out.println();
            if (cliente instanceof PessoaFisica) {
                ++numeroPessoaFisica;
            } else if (cliente instanceof PessoaJuridica) {
                ++numeroPessoaJuridica;
            }
        }
        System.out.println("Numero de Pessoas Fisicas: " + numeroPessoaFisica);
        System.out.println("Numero de Pessoas Juridicas: " + numeroPessoaJuridica);
        System.out.println("Numero total de Clientes: " + clientes.size());
    }
}
