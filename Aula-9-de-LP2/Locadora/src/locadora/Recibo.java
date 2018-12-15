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
public class Recibo {

    /**
     * PRECO_CILINDRADAS.
     *
     */
    private static final double CILINDRADAS = 2.0;
    /**
     * PRECO_POTENCIA.
     *
     */
    private static final double POTENCIA = 100.0;
    /**
     * DEVOLUCAO_CARRO.
     *
     */
    private static final int DEVOLUCAO_CARRO = 2;
    /**
     * DEVOLUCAO_MOTO.
     *
     */
    private static final int DEVOLUCAO_MOTO = 3;
    /**
     * nome.
     *
     */
    private String nome;
    /**
     * modelo.
     *
     */
    private String modelo;
    /**
     * custo.
     *
     */
    private Double custo;
    /**
     * devolução.
     *
     */
    private Integer devolucao;

    /**
     * construtor padrão.
     *
     */
    public Recibo() {
    }

    /**
     *
     * @param paramCliente paramCliente
     * @param paramVeiculo paramVeiculo
     */
    public Recibo(final String paramCliente, final Veiculo paramVeiculo) {
        this.nome = paramCliente;
        this.modelo = paramVeiculo.getModelo();
        Double paramCusto;
        Integer paramDevolucao;
        try {
            paramCusto = ((Carro) paramVeiculo).getPotencia() * POTENCIA;
            paramDevolucao = DEVOLUCAO_CARRO;
        } catch (ClassCastException e) {
            paramCusto = ((Moto) paramVeiculo).getCilindradas() * CILINDRADAS;
            paramDevolucao = DEVOLUCAO_MOTO;
        }
        this.custo = paramCusto;
        this.devolucao = paramDevolucao;
    }

    /**
     * @return the nome
     */
    public final String getNome() {
        return nome;
    }

    /**
     * @return the modelo
     */
    public final String getModelo() {
        return modelo;
    }

    /**
     * @return the custo
     */
    public final Double getCusto() {
        return custo;
    }

    /**
     * @return the devolucao
     */
    public final Integer getDevolucao() {
        return devolucao;
    }

    /**
     *
     * @return dados do Recibo
     */
    @Override
    public final String toString() {
        return "Cliente: " + nome + "\n"
                + "Modelo: " + modelo + "\n"
                + "Custo do aluguel: " + custo + "\n"
                + "Dias de aluguel: " + devolucao + "\n";
    }
}
