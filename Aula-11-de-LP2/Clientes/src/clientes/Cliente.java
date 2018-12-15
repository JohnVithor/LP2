/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

/**
 *
 * @author johnvithor
 */
public class Cliente {

    /**
     *
     */
    private final String nome;
    /**
     *
     */
    private String endereco;
    /**
     *
     */
    private String telefone;

    /**
     *
     * @param paramNome paramNome
     * @param paramEndereco paramEndereco
     * @param paramTelefone paramTelefone
     */
    public Cliente(final String paramNome, final String paramEndereco,
                   final String paramTelefone) {
        this.nome = paramNome;
        this.endereco = paramEndereco;
        this.telefone = paramTelefone;
    }

    /**
     * @return the nome
     */
    public final String getNome() {
        return nome;
    }

    /**
     * @return the endereco
     */
    public final String getEndereco() {
        return endereco;
    }

    /**
     * @return the telefone
     */
    public final String getTelefone() {
        return telefone;
    }

    /**
     *
     * @param paramEndereco paramEndereco
     */
    public final void setEndereco(final String paramEndereco) {
        this.endereco = paramEndereco;
    }

    /**
     *
     * @param paramTelefone paramTelefone
     */
    public final void setTelefone(final String paramTelefone) {
        this.telefone = paramTelefone;
    }

    /**
     * Imprime os dados do Cliente.
     */
    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Endereco: " + endereco);
        System.out.println("Telefone: " + telefone);
    }
}
