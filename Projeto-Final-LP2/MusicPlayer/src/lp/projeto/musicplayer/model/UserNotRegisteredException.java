package lp.projeto.musicplayer.model;

/**
 * Classe que indica que o Usuario não foi registrado.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class UserNotRegisteredException extends Exception {

    /**
     * Gerado automaticamente.
     */
    private static final long serialVersionUID = 2938355472406115549L;

    /**
     * Construtor com a mensagem padrão.
     */
    public UserNotRegisteredException() {
        super("Usuario não encontrado.");
    }

    /**
     * Construtor para uma mensagem personalizada.
     *
     * @param msg
     *            Mensagem a ser utilizada.
     */
    public UserNotRegisteredException(final String msg) {
        super(msg);
    }
}
