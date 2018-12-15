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
public class Moto extends Veiculo {

    /**
     * partida.
     *
     */
    private String partida;
    /**
     * cilindradas.
     *
     */
    private Double cilindradas;

    /**
     * construtor padrão.
     *
     */
    public Moto() {
    }

    /**
     *
     * @param paramPartida paramPartida
     * @param paramCilindradas paramCilindradas
     */
    public Moto(final String paramPartida, final Double paramCilindradas) {
        this.partida = paramPartida;
        this.cilindradas = paramCilindradas;
    }

    /**
     *
     * @param paramPartida paramPartida
     * @param paramCilindradas paramCilindradas
     * @param paramMarca paramMarca
     * @param paramModelo paramModelo
     * @param paramPlaca paramPlaca
     * @param paramAlugavel paramAlugavel
     */
    public Moto(final String paramPartida, final Double paramCilindradas,
                final String paramMarca, final String paramModelo,
                final String paramPlaca, final Boolean paramAlugavel) {
        super(paramMarca, paramModelo, paramPlaca, paramAlugavel);
        this.partida = paramPartida;
        this.cilindradas = paramCilindradas;
    }

    /**
     * @return the partida
     */
    public final String getPartida() {
        return partida;
    }

    /**
     * @return the cilindradas
     */
    public final Double getCilindradas() {
        return cilindradas;
    }

    /**
     *
     * @param paramPartida paramPartida
     */
    public final void setPartida(final String paramPartida) {
        this.partida = paramPartida;
    }

    /**
     *
     * @param paramCilindradas paramCilindradas
     */
    public final void setCilindradas(final Double paramCilindradas) {
        this.cilindradas = paramCilindradas;
    }

    /**
     *
     * @return informações da moto
     */
    @Override
    public final String toString() {
        return super.toString()
                + "Tipo de partida: " + partida + "\n"
                + "Cilindradas: " + cilindradas;
    }

}
