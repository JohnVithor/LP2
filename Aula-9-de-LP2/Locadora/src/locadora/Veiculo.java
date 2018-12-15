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
public class Veiculo {

    /**
     * marca.
     *
     */
    private String marca;
    /**
     * modelo.
     *
     */
    private String modelo;
    /**
     * placa.
     *
     */
    private String placa;
    /**
     * alugavel.
     *
     */
    private Boolean alugavel;

    /**
     * construtor padrão.
     *
     */
    public Veiculo() {
    }

    /**
     *
     * @param paramMarca paramMarca
     * @param paramModelo paramModelo
     * @param paramPlaca paramPlaca
     * @param paramAlugavel paramAlugavel
     */
    public Veiculo(final String paramMarca, final String paramModelo,
                   final String paramPlaca, final Boolean paramAlugavel) {
        this.marca = paramMarca;
        this.modelo = paramModelo;
        this.placa = paramPlaca;
        this.alugavel = paramAlugavel;
    }

    /**
     * @return the marca
     */
    public final String getMarca() {
        return marca;
    }

    /**
     * @return the modelo
     */
    public final String getModelo() {
        return modelo;
    }

    /**
     * @return the placa
     */
    public final String getPlaca() {
        return placa;
    }

    /**
     * @return the alugavel
     */
    public final Boolean isAlugavel() {
        return alugavel;
    }

    /**
     *
     * @param paramMarca paramMarca
     */
    public final void setMarca(final String paramMarca) {
        this.marca = paramMarca;
    }

    /**
     *
     * @param paramModelo paramModelo
     */
    public final void setModelo(final String paramModelo) {
        this.modelo = paramModelo;
    }

    /**
     *
     * @param paramPlaca paramPlaca
     */
    public final void setPlaca(final String paramPlaca) {
        this.placa = paramPlaca;
    }

    /**
     *
     * @param paramAlugavel paramAlugavel
     */
    public final void setAlugavel(final Boolean paramAlugavel) {
        this.alugavel = paramAlugavel;
    }

    /**
     *
     * @param paramObj objeto a ser comparado
     * @return true se forem iguais
     */
    @Override
    public boolean equals(final Object paramObj) {
        if (paramObj == this) {
            return true;
        }
        if (paramObj == null) {
            return false;
        }
        if (getClass() != paramObj.getClass()) {
            return false;
        }
        final Veiculo other = (Veiculo) paramObj;
        boolean eMarca = marca.equals(other.marca);
        boolean eModelo = modelo.equals(other.modelo);
        boolean ePlaca = placa.equals(other.placa);
        return (eMarca && eModelo && ePlaca);
    }

    /**
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        final int multi = 31;
        int result = 17;
        result = multi * result + marca.hashCode();
        result = multi * result + modelo.hashCode();
        result = multi * result + placa.hashCode();
        return result;
    }

    /**
     *
     * @return informações do veiculo em string
     */
    @Override
    public String toString() {
        return "Marca: " + marca + "\n"
                + "Modelo: " + modelo + "\n"
                + "Placa: " + placa + "\n";
    }
}
