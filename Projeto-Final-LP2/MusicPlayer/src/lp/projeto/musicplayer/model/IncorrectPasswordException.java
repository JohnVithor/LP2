package lp.projeto.musicplayer.model;

/**
 * Indica que a senha utilizada não condiz com a senha armazenada para esse usuario.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class IncorrectPasswordException extends Exception {

    /**
     * Gerado automaticamente.
     */
    private static final long serialVersionUID = -4248435664747695214L;

    /**
     * Construtor com a mensagem padrão.
     */
    public IncorrectPasswordException() {
        super("Senha Incorreta!");
    }

    /**
     * Construtor para uma mensagem personalizada.
     *
     * @param msg
     *            Mensagem a ser utilizada.
     */
    public IncorrectPasswordException(final String msg) {
        super(msg);
    }
}
