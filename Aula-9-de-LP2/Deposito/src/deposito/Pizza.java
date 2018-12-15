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
public class Pizza extends ProdutoNaoDuravel {
    /** sabor.
     *
     */
    private String sabor;
    /** tamanho.
     *
     */
    private Double tamanho;
    /** construtor vazio.
     *
     */
    public Pizza() {
    }
    /**
     *
     * @param paramSabor paramSabor
     * @param paramTamanho paramTamanho
     */
    public Pizza(final String paramSabor, final Double paramTamanho) {
        this.sabor = paramSabor;
        this.tamanho = paramTamanho;
    }
    /**
     *
     * @param paramSabor paramSabor
     * @param paramTamanho paramTamanho
     * @param paramDataDeValidade paramDataDeValidade
     * @param paramGenero paramGenero
     */
    public Pizza(final String paramSabor, final Double paramTamanho,
                 final String paramDataDeValidade, final String paramGenero) {
        super(paramDataDeValidade, paramGenero);
        this.sabor = paramSabor;
        this.tamanho = paramTamanho;
    }
    /**
     *
     * @param paramSabor paramSabor
     * @param paramTamanho paramTamanho
     * @param paramDataDeValidade paramDataDeValidade
     * @param paramGenero paramGenero
     * @param paramNovoNome paramNovoNome
     * @param paramNovoPreco paramNovoPreco
     * @param paramNovaMarca paramNovaMarca
     * @param paramNovaDescricao paramNovaDescricao
     * @param paramNovaDataDeFabricacao paramNovaDataDeFabricacao
     */
    public Pizza(final String paramSabor, final Double paramTamanho,
                 final String paramDataDeValidade, final String paramGenero,
                 final String paramNovoNome, final Double paramNovoPreco,
                 final String paramNovaMarca, final String paramNovaDescricao,
                 final String paramNovaDataDeFabricacao) {
        super(paramDataDeValidade, paramGenero, paramNovoNome, paramNovoPreco,
              paramNovaMarca, paramNovaDescricao, paramNovaDataDeFabricacao);
        this.sabor = paramSabor;
        this.tamanho = paramTamanho;
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

    /**
     * @return the tamanho
     */
    public final Double getTamanho() {
        return tamanho;
    }

    /**
     * @param paramTamanho the tamanho to set
     */
    public final void setTamanho(final Double paramTamanho) {
        this.tamanho = paramTamanho;
    }
}
