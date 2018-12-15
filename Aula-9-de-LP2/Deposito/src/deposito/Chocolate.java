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
public class Chocolate extends ProdutoNaoDuravel {
    /** sabor.
     *
     */
    private String sabor;
    /** quantidade.
     *
     */
    private Double quantidade;
    /** construtor vazio.
     *
     */
    public Chocolate() {
    }
    /**
     *
     * @param paramSabor paramSabor
     * @param paramQuantidade paramQuantidade
     */
    public Chocolate(final String paramSabor, final Double paramQuantidade) {
        this.sabor = paramSabor;
        this.quantidade = paramQuantidade;
    }
    /**
     *
     * @param paramSabor paramSabor
     * @param paramQuantidade paramQuantidade
     * @param paramDataDeValidade paramDataDeValidade
     * @param paramGenero paramGenero
     */
    public Chocolate(final String paramSabor, final Double paramQuantidade,
                     final String paramDataDeValidade, final String paramGenero) {
        super(paramDataDeValidade, paramGenero);
        this.sabor = paramSabor;
        this.quantidade = paramQuantidade;
    }
    /**
     *
     * @param paramSabor paramSabor
     * @param paramQuantidade paramQuantidade
     * @param paramDataDeValidade paramDataDeValidade
     * @param paramGenero paramGenero
     * @param paramNovoNome paramNovoNome
     * @param paramNovoPreco paramNovoPreco
     * @param paramNovaMarca paramNovaMarca
     * @param paramNovaDescricao paramNovaDescricao
     * @param paramNovaDataDeFabricacao paramNovaDataDeFabricacao
     */
    public Chocolate(final String paramSabor, final Double paramQuantidade,
                     final String paramDataDeValidade, final String paramGenero,
                     final String paramNovoNome, final Double paramNovoPreco,
                     final String paramNovaMarca, final String paramNovaDescricao,
                     final String paramNovaDataDeFabricacao) {
        super(paramDataDeValidade, paramGenero, paramNovoNome, paramNovoPreco,
              paramNovaMarca, paramNovaDescricao, paramNovaDataDeFabricacao);
        this.sabor = paramSabor;
        this.quantidade = paramQuantidade;
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
     * @return the quantidade
     */
    public final double getQuantidade() {
        return quantidade;
    }

    /**
     * @param paramQuantidade the quantidade to set
     */
    public final void setQuantidade(final Double paramQuantidade) {
        this.quantidade = paramQuantidade;
    }

}
