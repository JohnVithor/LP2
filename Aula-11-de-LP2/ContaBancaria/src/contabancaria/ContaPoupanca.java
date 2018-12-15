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
public class ContaPoupanca extends ContaBancaria {
    /**
     * 
     */
    private int DiaDeRendimento;
    /**
     * @param paramDiaDeRendimento paramDiaDeRendimento
     * @param paramCliente paramCliente
     * @param paramNumConta paramNumConta
     * @param paramSaldo paramSaldo
     */
    public ContaPoupanca(final int paramDiaDeRendimento, final String paramCliente,
                         final int paramNumConta, final double paramSaldo) {
        super(paramCliente, paramNumConta, paramSaldo);
        this.DiaDeRendimento = paramDiaDeRendimento;
    }
    /**
     * @param taxa taxa de rendimento da poupança.
     * @return novo saldo.
     */
    public final double calcularNovoSaldo(final double taxa) {
        setSaldo(getSaldo() * taxa);
        return getSaldo();
    }
    /**
     * @return dados da ContaPoupanca.
     */
    @Override
    public final String toString() {
        return super.toString() + "\nDia de Rendimento: " + DiaDeRendimento;
    }
}
