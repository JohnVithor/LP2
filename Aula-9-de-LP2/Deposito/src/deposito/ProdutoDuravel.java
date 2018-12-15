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
public class ProdutoDuravel extends Produto {
    /** materialPredominante.
     *
     */
    private String materialPredominante;
    /** durabilidade.
     *
     */
    private String durabilidade;
    /** construtor ProdutoDuravel.
     *
     */
    public ProdutoDuravel() {
    }

    /**
     *
     * @param paramMaterialPredominante paramMaterialPredominante
     * @param paramDurabilidade paramDurabilidade
     */
    public ProdutoDuravel(final String paramMaterialPredominante,
                          final String paramDurabilidade) {
        this.materialPredominante = paramMaterialPredominante;
        this.durabilidade = paramDurabilidade;
    }

    /**
     *
     * @param paramMaterialPredominante paramMaterialPredominante
     * @param paramDurabilidade paramDurabilidade
     * @param paramNovoNome paramNovoNome
     * @param paramNovoPreco paramNovoPreco
     * @param paramNovaMarca paramNovaMarca
     * @param paramNovaDescricao paramNovaDescricao
     * @param paramNovaDataDeFabricacao paramNovaDataDeFabricacao
     */
    public ProdutoDuravel(final String paramMaterialPredominante,
                          final String paramDurabilidade,
                          final String paramNovoNome,
                          final Double paramNovoPreco,
                          final String paramNovaMarca,
                          final String paramNovaDescricao,
                          final String paramNovaDataDeFabricacao) {
        super(paramNovoNome, paramNovoPreco, paramNovaMarca, paramNovaDescricao,
              paramNovaDataDeFabricacao);
        this.materialPredominante = paramMaterialPredominante;
        this.durabilidade = paramDurabilidade;
    }

    /**
     * materialPredominante.
     * @return the materialPredominante
     */
    public final String getMaterialPredominante() {
        return materialPredominante;
    }

    /**
     * materialPredominante.
     * @param paramMaterialPredominante the materialPredominante to set
     */
    public final void setMaterialPredominante(final String paramMaterialPredominante) {
        this.materialPredominante = paramMaterialPredominante;
    }

    /**
     * durabilidade.
     * @return the durabilidade
     */
    public final String getDurabilidade() {
        return durabilidade;
    }

    /**
     * durabilidade.
     * @param paramDurabilidade the durabilidade to set
     */
    public final void setDurabilidade(final String paramDurabilidade) {
        this.durabilidade = paramDurabilidade;
    }
}
