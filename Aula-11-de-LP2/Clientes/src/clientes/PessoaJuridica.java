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
public class PessoaJuridica extends Cliente {

    /**
     * cnpj.
     */
    private final String cnpj;
    /**
     * nomeFantasia.
     */
    private String nomeFantasia;

    /**
     * @param paramCnpj paramCnpj
     * @param paramNomeFantasia paramNomeFantasia
     * @param paramNome paramNome
     * @param paramEndereco paramEndereco
     * @param paramTelefone paramTelefone
     */
    public PessoaJuridica(final String paramCnpj, final String paramNomeFantasia,
                          final String paramNome, final String paramEndereco,
                          final String paramTelefone) {
        super(paramNome, paramEndereco, paramTelefone);
        this.cnpj = paramCnpj;
        this.nomeFantasia = paramNomeFantasia;
    }

    /**
     * @return the cnpj
     */
    public final String getCnpj() {
        return cnpj;
    }

    /**
     * @return the nomeFantasia
     */
    public final String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * @param paramNomeFantasia paramNomeFantasia
     */
    public final void setNomeFantasia(final String paramNomeFantasia) {
        this.nomeFantasia = paramNomeFantasia;
    }

    /**
     * Imprime os dados da Pessoa Juridica.
     */
    @Override
    public final void imprimirDados() {
        super.imprimirDados();
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Nome Fantasia: " + nomeFantasia);
    }
}
