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
public class ProdutoNaoDuravel  extends Produto {
    /** dataDeValidade.
     *
     */
    private String dataDeValidade;
    /**genero.
     *
     */
    private String genero;
    /** ProdutoNaoDuravel.
     *
     */
    public ProdutoNaoDuravel() {
    }
    /**
     *
     * @param paramDataDeValidade paramDataDeValidade
     * @param paramGenero paramGenero
     */
    public ProdutoNaoDuravel(final String paramDataDeValidade,
                             final String paramGenero) {
        this.dataDeValidade = paramDataDeValidade;
        this.genero = paramGenero;
    }
    /**
     *
     * @param paramDataDeValidade paramDataDeValidade
     * @param paramGenero paramGenero
     * @param paramNovoNome paramNovoNome
     * @param paramNovoPreco paramNovoPreco
     * @param paramNovaMarca paramNovaMarca
     * @param paramNovaDescricao paramNovaDescricao
     * @param paramNovaDataDeFabricacao paramNovaDataDeFabricacao
     */
    public ProdutoNaoDuravel(final String paramDataDeValidade,
                             final String paramGenero,
                             final String paramNovoNome,
                             final Double paramNovoPreco,
                             final String paramNovaMarca,
                             final String paramNovaDescricao,
                             final String paramNovaDataDeFabricacao) {
        super(paramNovoNome, paramNovoPreco, paramNovaMarca, paramNovaDescricao,
              paramNovaDataDeFabricacao);
        this.dataDeValidade = paramDataDeValidade;
        this.genero = paramGenero;
    }

    /**
     * @return the dataDeValidade
     */
    public final String getDataDeValidade() {
        return dataDeValidade;
    }

    /**
     * @param paramDataDeValidade the dataDeValidade to set
     */
    public final void setDataDeValidade(final String paramDataDeValidade) {
        this.dataDeValidade = paramDataDeValidade;
    }

    /**
     * @return the genero
     */
    public final String getGenero() {
        return genero;
    }

    /**
     * @param paramGenero the genero to set
     */
    public final void setGenero(final String paramGenero) {
        this.genero = paramGenero;
    }
}