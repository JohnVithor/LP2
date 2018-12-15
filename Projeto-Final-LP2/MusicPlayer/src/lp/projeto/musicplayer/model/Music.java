package lp.projeto.musicplayer.model;

import java.net.URI;
import java.net.URISyntaxException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.util.Duration;

import lp.projeto.musicplayer.MainApp;

/**
 * Classe que modela uma musica a partir de um caminho para o arquivo de audio e/ou um titulo.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class Music {

    private final String path;

    private final StringProperty title;

    /**
     * Construtor padrão de uma musica.
     */
    public Music() {
        path = "";
        title = new SimpleStringProperty("");
    }

    /**
     * Construtor a partir do caminho indicado.
     *
     * @param path
     *            Caminho indicado
     * @throws URISyntaxException
     *             Caso exista um erro no caminho informado.
     * @throws MediaException
     *             Caso não seja possivel utilizar o arquivo indicado.
     */
    public Music(final String path) throws URISyntaxException, MediaException {
        this.path = path;
        final Media media = new Media(path);
        title = new SimpleStringProperty(getTitle(media));
    }

    /**
     * Construtor parametrizado para uma Music.
     *
     * @param path
     *            Caminho para o arquivo de audio.
     * @param title
     *            Titulo da Music.
     * @throws URISyntaxException
     *             Caso exista um erro no caminho informado.
     * @throws MediaException
     *             Caso não seja possivel utilizar o arquivo indicado.
     */
    public Music(final String path, final String title) throws URISyntaxException, MediaException {
        this.path = path;
        new Media(path); // para testar se é possivel criar uma Media.
        this.title = new SimpleStringProperty(title);

    }

    /**
     * Informa a Duração da Media.
     *
     * @return
     */
    public Duration getDuration() {
        return new Media(path).getDuration();
    }

    /**
     * Recupera a Media a partir do caminho armazenado na Music.
     *
     * @return Media associada ao caminho armazenado na Music.
     */
    public Media getMedia() {
        try {
            if (!new URI(path).isAbsolute()) {
                return new Media(MainApp.class.getResource(path).toString());
            }
        } catch (final URISyntaxException e) {
            return new Media(MainApp.class.getResource(path).toString());
        }
        return new Media(path);
    }

    /**
     * Informa o Caminho da Music.
     *
     * @return O Caminho da Music.
     */
    public String getPath() {
        return path;
    }

    /**
     * Informa o Titulo da Music.
     *
     * @return O Titulo da Music.
     */
    public String getTitle() {
        return title.get();
    }

    /**
     * Informa qual é o titulo da Media informada. Utiliza a Metadata do arquivo, caso a informação
     * exista, senão utiliza o nome do arquivo.
     *
     * @param media
     *            Media a ser utilizada.
     * @return Titulo da Media.
     */
    private String getTitle(final Media media) {
        if (!media.getMetadata().isEmpty()) {
            final Object o = media.getMetadata().get("title");
            if (o != null) {
                return o.toString();
            }
        }
        final int index = path.lastIndexOf('/');
        return path.substring(index + 1, path.length() - 4);

    }

    /**
     * StringProperty da Music, para utilização no FXML.
     *
     * @return titulo na sua versão StringProperty
     */
    public StringProperty titleProperty() {
        return title;
    }

    @Override
    public String toString() {
        return title.get();
    }
}
