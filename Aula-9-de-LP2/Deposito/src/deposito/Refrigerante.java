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
public class Refrigerante extends ProdutoNaoDuravel {
    /** volume.
     *
     */
    private Double volume;
    /** sabor.
     *
     */
    private String sabor;
    /** construtor vazio.
     *
     */
    public Refrigerante() {
    }
    /**
     *
     * @param paramVolume paramVolume
     * @param paramSabor paramSabor
     */
    public Refrigerante(final Double paramVolume, final String paramSabor) {
        this.volume = paramVolume;
        this.sabor = paramSabor;
    }
    /**
     *
     * @param paramVolume paramVolume
     * @param paramSabor paramSabor
     * @param paramDataDeValidade paramDataDeValidade
     * @param paramGenero paramGenero
     */
    public Refrigerante(final Double paramVolume, final String paramSabor,
                        final String paramDataDeValidade,
                        final String paramGenero) {
        super(paramDataDeValidade, paramGenero);
        this.volume = paramVolume;
        this.sabor = paramSabor;
    }
    /**
     *
     * @param paramVolume paramVolume
     * @param paramSabor paramSabor
     * @param paramDataDeValidade paramDataDeValidade
     * @param paramGenero paramGenero
     * @param paramNovoNome paramNovoNome
     * @param paramNovoPreco paramNovoPreco
     * @param paramNovaMarca paramNovaMarca
     * @param paramNovaDescricao paramNovaDescricao
     * @param paramNovaDataDeFabricacao paramNovaDataDeFabricacao
     */
    public Refrigerante(final Double paramVolume,final  String paramSabor,
                        final String paramDataDeValidade,
                        final String paramGenero, final String paramNovoNome,
                        final Double paramNovoPreco, final String paramNovaMarca,
                        final String paramNovaDescricao,
                        final String paramNovaDataDeFabricacao) {
        super(paramDataDeValidade, paramGenero, paramNovoNome, paramNovoPreco,
              paramNovaMarca, paramNovaDescricao, paramNovaDataDeFabricacao);
        this.volume = paramVolume;
        this.sabor = paramSabor;
    }

    /**
     * @return the volume
     */
    public final Double getVolume() {
        return volume;
    }

    /**
     * @param paramVolume the volume to set
     */
    public final void setVolume(final Double paramVolume) {
        this.volume = paramVolume;
    }

    /**
     * @return the sabor
     */
    public final String getSabor() {
        return sabor;
    }

    /**
     * @param paramSabor the sabor to set
     */
    public final void setSabor(final String paramSabor) {
        this.sabor = paramSabor;
    }
}
