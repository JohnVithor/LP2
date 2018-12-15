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
public class Produto {
    /** nome do produto.
     *
     */
    private String nome;
    /** preço do produto.
     *
     */
    private Double preco;
    /** marca  do produto.
     *
     */
    private String marca;
    /** descrição do produto.
     *
     */
    private String descricao;
    /** data de fabricação do produto.
     *
     */
    private String dataDeFabricacao;
    /** Construtor vazio.
     *
     */
    public Produto() {
    }
    /**
     *
     * @param paramNome paramNome
     * @param paramPreco paramPreco
     * @param paramMarca paramMarca
     * @param paramDescricao paramDescricao
     * @param paramDataDeFabricacao paramDataDeFabricacao
     */
    public Produto(final String paramNome, final Double paramPreco,
                   final String paramMarca, final String paramDescricao,
                   final String paramDataDeFabricacao) {
        this.nome = paramNome;
        this.preco = paramPreco;
        this.marca = paramMarca;
        this.descricao = paramDescricao;
        this.dataDeFabricacao = paramDataDeFabricacao;
    }

    /**
     * @return the nome
     */
    public final String getNome() {
        return nome;
    }

    /**
     * @param paramNome the nome to set
     */
    public final void setNome(final String paramNome) {
        this.nome = paramNome;
    }

    /**
     * @return the preco
     */
    public final Double getPreco() {
        return preco;
    }

    /**
     * @param paramPreco the preco to set
     */
    public final void setPreco(final Double paramPreco) {
        this.preco = paramPreco;
    }

    /**
     * @return the marca
     */
    public final String getMarca() {
        return marca;
    }

    /**
     * @param paramMarca the marca to set
     */
    public final void setMarca(final String paramMarca) {
        this.marca = paramMarca;
    }

    /**
     * @return the descricao
     */
    public final String getDescricao() {
        return descricao;
    }

    /**
     * @param paramDescricao the descricao to set
     */
    public final void setDescricao(final String paramDescricao) {
        this.descricao = paramDescricao;
    }

    /**
     * @return the dataDeFabricacao
     */
    public final String getDataDeFabricacao() {
        return dataDeFabricacao;
    }

    /**
     * @param paramDataDeFabricacao the dataDeFabricacao to set
     */
    public final void setDataDeFabricacao(final String paramDataDeFabricacao) {
        this.dataDeFabricacao = paramDataDeFabricacao;
    }
}