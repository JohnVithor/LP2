/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabancaria;

/**
 *
 * @author johnvithor
 */
public class ContaEspecial extends ContaBancaria {
    /**
     * limite.
     */
    private final double limite;
    /**
     * @param paramLimite paramLimite
     * @param paramCliente paramCliente
     * @param paramNumConta paramNumConta
     * @param paramSaldo paramSaldo
     */
    public ContaEspecial(final double paramLimite, final String paramCliente,
                         final int paramNumConta, final double paramSaldo) {
        super(paramCliente, paramNumConta, paramSaldo);
        this.limite = paramLimite;
    }

    /**
     * @param valor valor a ser retirado.
     * @return novo valor do saldo.
     */
    @Override
    public final double sacar(final int valor) {
        if (valor < 0) {
            System.out.println("Não se pode sacar um valor negativo.");
        } else {
            setSaldo(getSaldo() - valor);
        }
        return getSaldo();
    }
    /**
     * @return dados da ContaEspecial
     */
    @Override
    public final String toString() {
        return super.toString() + "\nLimite: " + limite;
    }
}
