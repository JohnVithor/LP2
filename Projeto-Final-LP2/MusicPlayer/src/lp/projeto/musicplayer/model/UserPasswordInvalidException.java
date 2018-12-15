package lp.projeto.musicplayer.model;

/**
 * Classe que indica que a senha não condiz com a senha armazenada.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class UserPasswordInvalidException extends Exception {

    /**
     * Gerado automaticamente.
     */
    private static final long serialVersionUID = 7754896661424271041L;

    /**
     * Construtor com a mensagem padrão.
     */
    public UserPasswordInvalidException() {
        super("Usuario não encontrado.");
    }

    /**
     * Construtor para uma mensagem personalizada.
     *
     * @param msg
     *            Mensagem a ser utilizada.
     */
    public UserPasswordInvalidException(final String msg) {
        super(msg);
    }
}
