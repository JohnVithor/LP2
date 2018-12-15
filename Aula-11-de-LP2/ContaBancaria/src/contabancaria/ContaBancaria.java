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
public class ContaBancaria {

    /**
     * cliente.
     */
    private final String cliente;
    /**
     * numero da conta.
     */
    private final int numConta;
    /**
     * saldo.
     */
    private double saldo;

    /**
     * @param paramCliente paramCliente
     * @param paramNumConta paramNumConta
     * @param paramSaldo paramSaldo
     */
    public ContaBancaria(final String paramCliente, final int paramNumConta,
                         final double paramSaldo) {
        this.cliente = paramCliente;
        this.numConta = paramNumConta;
        this.saldo = paramSaldo;
    }

    /**
     * @return the saldo
     */
    public final double getSaldo() {
        return saldo;
    }
    /**
     * @param paramSaldo novo saldo
     */
    protected final void setSaldo(final double paramSaldo) {
        this.saldo = paramSaldo;
    }


    /**
     * @param valor valor a ser retirado.
     * @return novo valor do saldo.
     */
    public double sacar(final int valor) {
        if (valor < 0) {
            System.out.println("Não se pode sacar um valor negativo.");
        } else if ((getSaldo() - valor) < 0) {
            System.out.println("Não se pode ter um saldo negativo.");
        } else {
            saldo -= valor;
        }
        return getSaldo();
    }

    /**
     * @param valor valor a ser adicionado.
     * @return novo valor do saldo.
     */
    public final double depositar(final int valor) {
        if (valor < 0) {
            System.out.println("Não se pode depositar um  valor negativo.");
        } else {
            saldo += valor;
        }
        return getSaldo();
    }

    /**
     * @return Dados da Conta
     */
    @Override
    public String toString() {
        return "Nome do Cliente: " + cliente + "\n"
                + "Numero da Conta:" + numConta + "\n"
                + "Saldo: " + saldo;
    }
}
