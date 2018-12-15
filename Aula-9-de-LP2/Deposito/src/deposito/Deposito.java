/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

import java.util.ArrayList;

/**
 *
 * @author johnvithor
 */
public class Deposito {
    /** listaProdutos.
     *
     */
    private final ArrayList<Produto> listaProdutos;
    /**
     *
     */
    public Deposito() {
        listaProdutos = new ArrayList(1);
    }
    /**
     *
     * @param paramListaProdutos paramListaProdutos
     */
    public Deposito(final ArrayList<Produto> paramListaProdutos) {
        this.listaProdutos = paramListaProdutos;
    }
    /**
     *
     * @param paramProduto paramProduto
     */
    public final void adicionarProduto(final Produto paramProduto) {
        listaProdutos.add(paramProduto);
    }
    /**
     *
     * @param indice indice
     */
    public final void removerProduto(final int indice) {
        listaProdutos.remove(indice);
    }
    /**
     *
     * @return quantidadeProdutos
     */
    public final int quantidadeProdutos() {
        return listaProdutos.size();
    }
    /**
     *
     * @return true se estiver vazio, false caso contrario
     */
    public final boolean depositoVazio() {
        return listaProdutos.isEmpty();
    }
    /**
     *
     * @return produtoMaisCaro
     */
    public final Produto produtoMaisCaro() {
        Produto maisCaro = listaProdutos.get(0);
        for (Produto produto : listaProdutos) {
            if (maisCaro.getPreco() < produto.getPreco()) {
                maisCaro = produto;
            }
        }
        return maisCaro;
    }
}
