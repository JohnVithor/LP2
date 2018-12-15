package lp.projeto.musicplayer.model;

/**
 * Classe que indica que o Usuario ja existe no sistema.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class UserExistException extends Exception {

    /**
     * Gerado automaticamente.
     */
    private static final long serialVersionUID = -3307347111462185901L;

    /**
     * Construtor com a mensagem padrão.
     */
    public UserExistException() {
        super("Este nome de usuario ja esta em uso");
    }

    /**
     * Construtor para uma mensagem personalizada.
     *
     * @param msg
     *            Mensagem a ser utilizada.
     */
    public UserExistException(final String msg) {
        super(msg);
    }
}
