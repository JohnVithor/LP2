package lp.projeto.musicplayer.model;

/**
 * Exceção para indicar que não há musica selecionada.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class NoMusicSelectedException extends Exception {

    /**
     * Gerado automaticamente.
     */
    private static final long serialVersionUID = 6035383430996990409L;

    /**
     * Construtor com a mensagem padrão.
     */
    public NoMusicSelectedException() {
        super("Nenhuma música selecionada");
    }

    /**
     * Construtor para uma mensagem personalizada.
     *
     * @param msg
     *            Mensagem a ser utilizada.
     */
    public NoMusicSelectedException(final String msg) {
        super(msg);
    }
}
