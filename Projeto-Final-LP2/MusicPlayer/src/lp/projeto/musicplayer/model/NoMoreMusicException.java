package lp.projeto.musicplayer.model;

/**
 * Exceção para indicar que não há musica anterior ou que não há musica posterior a atual da
 * playlist.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class NoMoreMusicException extends Exception {

    /**
     * Gerado automaticamente.
     */
    private static final long serialVersionUID = -9018746654434114965L;

    /**
     * Construtor com a mensagem padrão.
     */
    public NoMoreMusicException() {
        super("Não existe mais musicas.");
    }

    /**
     * Construtor para uma mensagem personalizada.
     *
     * @param msg
     *            Mensagem a ser utilizada.
     */
    public NoMoreMusicException(final String msg) {
        super(msg);
    }
}
