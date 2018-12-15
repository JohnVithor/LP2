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
public class Carro extends Veiculo {

    /**
     * POTENCIA_MINIMA.
     *
     */
    private static final double POTENCIA_MIN = 1.0;
    /**
     * POTENCIA_MAXIMA.
     *
     */
    private static final double POTENCIA_MAX = 3.0;
    /**
     * potencia.
     *
     */
    private Double potencia;
    /**
     * portas.
     *
     */
    private Integer portas;

    /**
     * construtor padrão.
     *
     */
    public Carro() {
    }

    /**
     *
     * @param paramPotencia paramPotencia
     * @param paramPortas paramPortas
     */
    public Carro(final Double paramPotencia, final Integer paramPortas) {
        if (paramPotencia < POTENCIA_MIN || paramPotencia > POTENCIA_MAX) {
            System.out.println("Potencia não é válida.");
            return;
        }
        this.potencia = paramPotencia;
        this.portas = paramPortas;
    }

    /**
     *
     * @param paramPotencia paramPotencia
     * @param paramPortas paramPortas
     * @param paramMarca paramMarca
     * @param paramModelo paramModelo
     * @param paramPlaca paramPlaca
     * @param paramAlugavel paramAlugavel
     */
    public Carro(final Double paramPotencia, final Integer paramPortas,
                 final String paramMarca, final String paramModelo,
                 final String paramPlaca, final Boolean paramAlugavel) {
        super(paramMarca, paramModelo, paramPlaca, paramAlugavel);
        if (paramPotencia < POTENCIA_MIN || paramPotencia > POTENCIA_MAX) {
            System.out.println("Potencia não é válida.");
            return;
        }
        this.potencia = paramPotencia;
        this.portas = paramPortas;
    }

    /**
     * @return the potencia
     */
    public final Double getPotencia() {
        return potencia;
    }

    /**
     * @return the portas
     */
    public final Integer getPortas() {
        return portas;
    }

    /**
     *
     * @param paramPotencia paramPotencia
     */
    public final void setPotencia(final Double paramPotencia) {
        if (paramPotencia < POTENCIA_MIN || paramPotencia > POTENCIA_MAX) {
            System.out.println("Potencia não é válida.");
            return;
        }
        this.potencia = paramPotencia;
    }

    /**
     *
     * @param paramPortas paramPortas
     */
    public final void setPortas(final Integer paramPortas) {
        this.portas = paramPortas;
    }

    /**
     *
     * @return informações do carro
     */
    @Override
    public final String toString() {
        return super.toString()
                + "Potência: " + potencia + "\n"
                + "Número de Portas: " + portas;
    }

}
