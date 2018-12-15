/**
 * 
 */
package polinomios;

/**
 * @author JohnVithor
 */
public class OverFlowException extends Exception {

    /**
     * Gerado Automáticamente.
     */
    private static final long serialVersionUID = 5275814549549741821L;

    /**
     * Construtor Padrão.
     */
    public OverFlowException() {
        super();
    }

    /**
     * Construtor com mensagem
     * 
     * @param message
     *            Mensagem a ser armazenada pela excessão.
     */
    public OverFlowException(String message) {
        super(message);
    }
}
