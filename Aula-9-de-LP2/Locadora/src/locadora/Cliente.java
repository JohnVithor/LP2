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
public class Cliente {
    /** nome.
     *
     */
    private String nome;
    /** carteira.
     *
     */
    private String carteira;
    /** veiculo.
     *
     */
    private Veiculo veiculo;
    /** tempoAluguel.
     *
     */
    private Integer tempoAluguel;
    /** construtor padrão.
     *
     */
    public Cliente() {
        veiculo = null;
    }
    /**
     *
     * @param paramNome paramNome
     * @param paramCarteira paramCarteira
     * @param paramVeiculo paramVeiculo
     * @param paramAluguel paramAluguel
     */
    public Cliente(final String paramNome, final String paramCarteira,
                   final Veiculo paramVeiculo, final Integer paramAluguel) {
        this.nome = paramNome;
        this.carteira = paramCarteira;
        this.veiculo = paramVeiculo;
        this.tempoAluguel = paramAluguel;
    }

    /**
     * @return the nome
     */
    public final String getNome() {
        return nome;
    }

    /**
     * @return the carteira
     */
    public final String getCarteira() {
        return carteira;
    }

    /**
     * @return the veiculo
     */
    public final Veiculo getVeiculo() {
        return veiculo;
    }

    /**
     * @return the tempoAluguel
     */
    public final Integer getTempoAluguel() {
        return tempoAluguel;
    }

    /**
     *
     * @param paramNome paramNome
     */
    public final void setNome(final String paramNome) {
        this.nome = paramNome;
    }
    /**
     *
     * @param paramCarteira paramCarteira
     */
    public final void setCarteira(final String paramCarteira) {
        this.carteira = paramCarteira;
    }
    /**
     *
     * @param paramVeiculo paramVeiculo
     */
    public final void setVeiculo(final Veiculo paramVeiculo) {
        this.veiculo = paramVeiculo;
    }
    /**
     *
     * @param paramTempoAluguel paramTempoAluguel
     */
    public final void setTempoAluguel(final Integer paramTempoAluguel) {
        this.tempoAluguel = paramTempoAluguel;
    }
    /**
     *
     * @return informações do cliente
     */
    @Override
    public final String toString() {
        return "Nome: " + nome + "\n"
             + "Carteira: " + carteira + "\n"
             + "Veiculo: " + veiculo.getModelo() + "\n"
             + "Tempo com o Veiculo: " + tempoAluguel;
    }
}
