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
public class Celular extends ProdutoDuravel {
    /** tamanho do celular.
     *
     */
    private double tamanho;
    /** tamanho da tela do celular.
     *
     */
    private double tamanhoTela;
    /** construtor cvazio.
     *
     */
    public Celular() {
    }
    /**
     * @param paramTamanho paramTamanho
     * @param paramTamanhoTela paramTamanhoTela
     */
    public Celular(final double paramTamanho, final double paramTamanhoTela) {
        tamanho = paramTamanho;
        tamanhoTela = paramTamanhoTela;
    }
    /**
     *
     * @param paramTamanho paramTamanho
     * @param paramTamanhoTela paramTamanhoTela
     * @param paramMaterialPredominante paramMaterialPredominante
     * @param paramDurabilidade paramDurabilidade
     */
    public Celular(final double paramTamanho, final double paramTamanhoTela,
                   final String paramMaterialPredominante,
                   final String paramDurabilidade) {
        super(paramMaterialPredominante, paramDurabilidade);
        this.tamanho = paramTamanho;
        this.tamanhoTela = paramTamanhoTela;
    }
    /**
     *
     * @param paramTamanho paramTamanho
     * @param paramTamanhoTela paramTamanhoTela
     * @param paramMaterialPredominante paramMaterialPredominante
     * @param paramDurabilidade paramDurabilidade
     * @param paramNovoNome paramNovoNome
     * @param paramNovoPreco paramNovoPreco
     * @param paramNovaMarca paramNovaMarca
     * @param paramNovaDescricao paramNovaDescricao
     * @param paramNovaDataDeFabricacao paramNovaDataDeFabricacao
     */
    public Celular(final double paramTamanho, final double paramTamanhoTela,
                   final String paramMaterialPredominante,
                   final String paramDurabilidade,
                   final String paramNovoNome, final Double paramNovoPreco,
                   final String paramNovaMarca, final String paramNovaDescricao,
                   final String paramNovaDataDeFabricacao) {
        super(paramMaterialPredominante, paramDurabilidade, paramNovoNome,
              paramNovoPreco, paramNovaMarca, paramNovaDescricao,
              paramNovaDataDeFabricacao);
        this.tamanho = paramTamanho;
        this.tamanhoTela = paramTamanhoTela;
    }

    /**
     * @return the tamanho
     */
     public final double getTamanho() {
        return tamanho;
    }

    /**
     * @param paramTamanho the tamanho to set
     */
    public final void setTamanho(final double paramTamanho) {
        this.tamanho = paramTamanho;
    }

    /**
     * @return the tamanhoTela
     */
    public final double getTamanhoTela() {
        return tamanhoTela;
    }

    /**
     * @param paramTamanhoTela the novoTamanhoTela to set
     */
    public final void setTamanhoTela(final double paramTamanhoTela) {
        this.tamanhoTela = paramTamanhoTela;
    }
}
