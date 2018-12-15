/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora;

import java.util.HashSet;

/**
 *
 * @author johnvithor
 */
public class Locadora {

    /**
     * porcentagem da multa em relação ao preço do aluguel.
     *
     */
    private static final double TWOPERCENT = 2 / 100;
    /**
     * Conjunto de veiculos da locadora.
     *
     */
    private final HashSet<Veiculo> veiculos;
    /**
     * Conjunto de clientes com algum veiculo alugado.
     *
     */
    private final HashSet<Cliente> clientes;
    /**
     * Conjunto de recibos dos alugueis efetuados.
     *
     */
    private final HashSet<Recibo> recibos;

    /**
     * construtor padrão.
     *
     */
    public Locadora() {
        veiculos = new HashSet<>();
        clientes = new HashSet<>();
        recibos = new HashSet<>();
    }

    /**
     *
     * @param carro carro
     */
    public final void cadastrarCarro(final Carro carro) {
        veiculos.add(carro);
    }

    /**
     *
     * @param paramPotencia paramPotencia
     * @param paramPortas paramPortas
     * @param paramMarca paramMarca
     * @param paramModelo paramModelo
     * @param paramPlaca paramPlaca
     */
    public final void cadastrarCarro(final Double paramPotencia,
                                     final Integer paramPortas,
                                     final String paramMarca,
                                     final String paramModelo,
                                     final String paramPlaca) {
        veiculos.add(new Carro(paramPotencia, paramPortas,
                               paramMarca, paramModelo, paramPlaca, true));
    }

    /**
     *
     * @param moto moto
     */
    public final void cadastrarMoto(final Moto moto) {
        veiculos.add(moto);
    }

    /**
     *
     * @param paramPartida paramPartida
     * @param paramCilindradas paramCilindradas
     * @param paramMarca paramMarca
     * @param paramModelo paramModelo
     * @param paramPlaca paramPlaca
     */
    public final void cadastrarMoto(final String paramPartida,
                                    final Double paramCilindradas,
                                    final String paramMarca,
                                    final String paramModelo,
                                    final String paramPlaca) {
        veiculos.add(new Moto(paramPartida, paramCilindradas,
                              paramMarca, paramModelo, paramPlaca, true));
    }

    /**
     * mostra todos os veiculos cadastrados.
     *
     */
    public final void printVeiculos() {
        System.out.println("Todos os veiculos cadastrados: ");
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
            if (veiculo.isAlugavel()) {
                System.out.println("Alugável: Sim\n");
            } else {
                System.out.println("Alugável: Não\n");
            }
        }
    }

    /**
     * mostra os veiculos disponiveis para aluguel.
     *
     */
    public final void printAlugaveis() {
        System.out.println("Veiculos disponiveis para aluguel: ");
        for (Veiculo veiculo : veiculos) {
            if (veiculo.isAlugavel()) {
                System.out.println(veiculo + "\n");
            }
        }
    }

    /**
     * mostra os veiculos alugados.
     *
     */
    public final void printAlugados() {
        System.out.println("Veiculos atualmente alugados: ");
        for (Veiculo veiculo : veiculos) {
            if (!veiculo.isAlugavel()) {
                System.out.println(veiculo + "\n");
            }
        }
    }
    /** mostra os clientes com algum veiculo alugado.
     *
     */
    public final void printClientes() {
        System.out.println("Clientes que ainda não devolveram o veiculo: ");
        for (Cliente cliente : clientes) {
            System.out.println(cliente + "\n");
        }
    }
    /**
     *
     * @param nome nome do cliente
     * @param carteira carteira do cliente
     * @param veiculo veiculo a ser alugado
     */
    public final void alugarVeiculo(final String nome,
                                    final String carteira,
                                    final Veiculo veiculo) {
        if (!veiculo.isAlugavel()) {
            System.out.println("Veiculo não disponivel para aluguel.");
            return;
        }
        Recibo recibo = new Recibo(nome, veiculo);
        Cliente cliente = new Cliente(nome, carteira, veiculo, 0);
        clientes.add(cliente);
        recibos.add(recibo);
        veiculo.setAlugavel(false);
        System.out.println("Seu recibo caro: " + nome);
        System.out.println(recibo);
    }

    /**
     *
     * @param cliente cliente que está devolvendo o veiculo
     * @param recibo recibo comprovando a data do aluguel
     */
    public final void devolverVeiculo(final Cliente cliente,
                                      final Recibo recibo) {
        if (cliente.getTempoAluguel() > recibo.getDevolucao()) {
            System.out.println("Como teve um atraso na devolução"
                             + "será aplicada a seguinte multa: ");
            System.out.println("Multa: " + recibo.getCusto() * TWOPERCENT);
        }
        cliente.getVeiculo().setAlugavel(true);
        System.out.println("Obrigado por usar nossos serviços!");
        clientes.remove(cliente);
        recibos.remove(recibo);
    }

    /**
     * incrementa o aluguel de todos os clientes que ainda não devolveram o
     * veiculo.
     *
     */
    public final void novoDia() {
        for (Cliente cliente : clientes) {
            cliente.setTempoAluguel(cliente.getTempoAluguel() + 1);
        }
    }
}
