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
public class Carro extends ProdutoDuravel {
    /** cor do carro.
     *
     */
    private String cor;
    /** quantidade de passageiros.
     *
     */
    private int passageiros;
    /** Construtor vazio.
     *
     */
    public Carro() {
    }
    /**
     *
     * @param paramCor paramCor
     * @param paramPassageiros paramPassageiros
     */
    public Carro(final String paramCor, final int paramPassageiros) {
        this.cor = paramCor;
        this.passageiros = paramPassageiros;
    }
    /**
     *
     * @param paramCor paramCor
     * @param paramPassageiros paramPassageiros
     * @param paramMaterialPredominante paramMaterialPredominante
     * @param paramDurabilidade paramDurabilidade
     */
    public Carro(final String paramCor, final int paramPassageiros,
                 final String paramMaterialPredominante,
                 final String paramDurabilidade) {
        super(paramMaterialPredominante, paramDurabilidade);
        this.cor = paramCor;
        this.passageiros = paramPassageiros;
    }
    /**
     *
     * @param paramCor paramCor
     * @param paramPassageiros paramPassageiros
     * @param paramMaterialPredominante paramMaterialPredominante
     * @param paramDurabilidade paramDurabilidade
     * @param paramNovoNome paramNovoNome
     * @param paramNovoPreco paramNovoPreco
     * @param paramNovaMarca paramNovaMarca
     * @param paramNovaDescricao paramNovaDescricao
     * @param paramNovaDataDeFabricacao paramNovaDataDeFabricacao
     */
    public Carro(final String paramCor, final int paramPassageiros,
                 final String paramMaterialPredominante,
                 final String paramDurabilidade,
                 final String paramNovoNome, final Double paramNovoPreco,
                 final String paramNovaMarca, final String paramNovaDescricao,
                 final String paramNovaDataDeFabricacao) {
        super(paramMaterialPredominante, paramDurabilidade, paramNovoNome,
              paramNovoPreco, paramNovaMarca, paramNovaDescricao,
              paramNovaDataDeFabricacao);
        this.cor = paramCor;
        this.passageiros = paramPassageiros;
    }

    /**
     * @return the cor
     */
    public final String getCor() {
        return cor;
    }

    /**
     * @param paramCor the cor to set
     */
    public final void setCor(final String paramCor) {
        this.cor = paramCor;
    }

    /**
     * @return the passageiros
     */
    public final int getPassageiros() {
        return passageiros;
    }

    /**
     * @param paramPassageiros the passageiros to set
     */
    public final void setPassageiros(final int paramPassageiros) {
        this.passageiros = paramPassageiros;
    }
}
