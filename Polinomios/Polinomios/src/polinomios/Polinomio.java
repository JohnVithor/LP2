/**
 *
 */
package polinomios;

import java.util.ArrayList;

/**
 * Esta Classe representa um Polinômio.
 * 
 * @author JohnVithor
 */
public class Polinomio {

    /**
     * Lista com os termos do polinômio.
     */
    ArrayList<Termo> termos;

    /**
     * @param t
     *            Termo inicial do polinômio.
     * @throws NullPointerException
     *             Se o Termo passado for null.
     */
    public Polinomio(final Termo t) throws NullPointerException {
        if (t == null) {
            throw new NullPointerException(
                            "Não é possível criar um polinômio a partir de um Termo null");
        }
        this.termos = new ArrayList<>();
        this.termos.add(t);
    }

    /**
     * @param t
     *            Insere o termo indicado no polinômio, somando seu coeficiente a um
     *            termo de grau equivalente, caso já exista um termo do mesmo grau.
     * @throws NullPointerException
     *             Se o Termo passado for null.
     * @throws OverFlowException
     */
    public void insere(final Termo t) throws NullPointerException, OverFlowException {
        if (t == null) {
            throw new NullPointerException("Não é possível inserir um Termo null");
        }
        final int grau = t.getExponent();
        for (final Termo termo : this.termos) {
            if (termo.getExponent() == grau) {
                termo.some(t.getCoeficient());
                return;
            }
        }
        this.termos.add(t);
    }

    /**
     * @param pos
     *            posição do termo a ser acessado.
     * @return Termo que ocupa a posiço indicada, ou null caso a posição indicada
     *         seja inválida.
     */
    public final Termo getTermo(int pos) {
        try {
            return termos.get(pos);
        } catch (IndexOutOfBoundsException iobe) {
            return null;
        }
    }

    /**
     * @return Um ArrayList com os termos atuais do polinômio.
     */
    public final ArrayList<Termo> getAllTermos() {
        return this.termos;
    }

    /**
     * Inclui o termo caso um termo com grau equivalente não exista neste Polinômio
     * e soma seus coeficientes caso existe um termo com grau equivalente.
     * 
     * @param p
     *            Polinômio a ser fundido com este Polinômio.
     * @throws NullPointerException
     *             Caso o Polinômio passado seja null.
     * @throws OverFlowException
     */
    public void calcula(final Polinomio p) throws NullPointerException, OverFlowException {
        if (p == null) {
            throw new NullPointerException("O polinomio a ser somado não pode ser null");
        }
        final ArrayList<Termo> fundir = p.getAllTermos();
        for (final Termo termo : this.termos) {
            for (final Termo termoFundir : fundir) {
                if (termo.getExponent() == termoFundir.getExponent()) {
                    termo.some(termoFundir.getCoeficient());
                    break;
                }
            }
        }
    }

    /**
     * @param x
     *            valor a ser calculado com os valores do termos do polinômio.
     * @return Resultado das operações de cada termo somadas.
     * @throws OverFlowException
     */
    public int resultado(final int x) throws OverFlowException {
        int resultado = 0;
        for (final Termo termo : this.termos) {
            resultado += (int) termo.calcula(x);
        }
        if (resultado > Integer.MAX_VALUE || resultado < Integer.MIN_VALUE) {
            throw new OverFlowException("Soma dos termos gera OverFlow");
        }
        return resultado;
    }

    @Override
    public String toString() {
        String polinomio = "";
        this.termos.sort((arg0, arg1) -> {
            if (arg0.getExponent() < arg1.getExponent()) {
                return -1;
            }
            if (arg0.getExponent() > arg1.getExponent()) {
                return 1;
            }
            return 0;
        });
        for (int i = 0; i < (this.termos.size() - 1); i++) {
            polinomio += this.termos.get(i) + " + ";
        }
        polinomio += this.termos.get(this.termos.size() - 1);
        return polinomio;
    }
}
