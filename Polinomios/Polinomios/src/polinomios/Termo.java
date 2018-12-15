/**
 *
 */
package polinomios;

/**
 * Esta classe representa um Termo de um Polinômio.
 * 
 * @author JohnVithor
 */
public class Termo {

    /**
     * Valor do coeficiente do termo.
     */
    int coefficient;

    /**
     * Valor do expoente do termo, também informa o grau do termo.
     */
    int exponent;

    /**
     * @param coefficient
     *            Coeficiente inicial do termo.
     * @param exponent
     *            Expoente inicial do termo.
     */
    public Termo(final int coefficient, final int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    /**
     * Recebe um objeto da classe Termo e substitui os valores ai xi do termo
     * corrente por aqueles do termo recebido como parâmetro.
     * 
     * @param t
     *            Termo com os novos valores de coeficiente e expoente.
     */
    public void insere(final Termo t) {
        this.coefficient = t.getCoeficient();
        this.exponent = t.getExponent();
    }

    /**
     * Soma o valor do coeficiente atual com o valor passado.
     * 
     * @param coefficient
     *            valor a ser somado ao coeficiente.
     * @throws OverFlowException
     */
    public void some(final int coefficient) throws OverFlowException {
        double coefficientToSum = coefficient;
        double originalCoefficient = this.coefficient;
        double result = originalCoefficient + coefficientToSum;
        if (coefficientToSum != 0 && result == originalCoefficient) {
            throw new OverFlowException("Erro durante a operação");
        }
        if (result > Integer.MAX_VALUE) {
            throw new OverFlowException("Adicionar " + coefficient + " a " + this.coefficient
                            + " gera um overflow / underflow.");

        } else if (result < Integer.MIN_VALUE) {
            throw new OverFlowException("Subtrair " + -coefficient + " de " + this.coefficient
                            + " gera um overflow / underflow.");
        }
        this.coefficient = this.coefficient + coefficient;
    }

    /**
     * Recebe um valor de x como parâmetro e retorna o valor do termo calculado.
     * 
     * @param x
     *            valor a ser calculado com os valores do termo.
     * @return Resultado das operações do termo.
     * @throws OverFlowException
     */
    public int calcula(final int x) throws OverFlowException {
        double expResult = Math.pow(x, this.exponent);
        if (expResult > Integer.MAX_VALUE || expResult < Integer.MIN_VALUE) {
            throw new OverFlowException("Elevar " + x + " a " + this.exponent
                            + " gera um overflow / underflow.");
        }
        double result = this.coefficient * expResult;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new OverFlowException("Multiplicar " + this.coefficient + " por " + expResult
                            + " gera um overflow / underflow.");
        }
        return (int) result;
    }

    /**
     * @return O coeficiente atual do termo.
     */
    public final int getCoeficient() {
        return this.coefficient;
    }

    /**
     * @param coefficient
     *            O novo valor do coeficiente.
     */
    public final void setCoeficient(final int coefficient) {
        this.coefficient = coefficient;
    }

    /**
     * @return O expoente atual do termo.
     */
    public final int getExponent() {
        return this.exponent;
    }

    /**
     * @param exponent
     *            O novo valor do expoente.
     */
    public final void setExponent(final int exponent) {
        this.exponent = exponent;
    }

    @Override
    public String toString() {
        return "(" + this.coefficient + ")^" + this.exponent;
    }

}
