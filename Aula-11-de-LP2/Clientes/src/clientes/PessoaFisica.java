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
public class PessoaFisica extends Cliente {

    /**
     * cpf.
     */
    private final String cpf;

    /**
     * @param paramCpf paramCpf
     * @param paramNome paramNome
     * @param paramEndereco paramEndereco
     * @param paramTelefone paramTelefone
     */
    public PessoaFisica(final String paramCpf, final String paramNome,
                        final String paramEndereco,
                        final String paramTelefone) {
        super(paramNome, paramEndereco, paramTelefone);
        this.cpf = paramCpf;
    }

    /**
     * @return the cpf
     */
    public final String getCpf() {
        return cpf;
    }

    /**
     * Imprime os dados da Pessoa Fisica.
     */
    @Override
    public final void imprimirDados() {
        super.imprimirDados();
        System.out.println("CPF: " + cpf);
    }
}
