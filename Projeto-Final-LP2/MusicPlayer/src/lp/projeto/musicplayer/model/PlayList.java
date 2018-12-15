package lp.projeto.musicplayer.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe que representa um conjunto de Musicas.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class PlayList {

    private final StringProperty title;

    private int current;

    private ObservableList<Music> musics;

    private final String owner;

    /**
     * Construtor padrão de uma PlayList.
     */
    public PlayList() {
        title = new SimpleStringProperty("");
        current = 0;
        musics = FXCollections.observableArrayList();
        owner = "";
    }

    /**
     * Construtor parametrizado de uma PlayList para receber um titulo, um dono. Sem nenhuma musica
     * inicial.
     *
     * @param title
     *            Titulo da PlayList.
     * @param onwer
     *            Nome do dono da PlayList
     */
    public PlayList(final String title, final String onwer) {
        this.title = new SimpleStringProperty(title);
        current = 0;
        musics = FXCollections.observableArrayList();
        owner = onwer;
    }

    /**
     * Construtor parametrizado de uma PlayList para receber um titulo, um dono e um conjunto
     * inicial de musicas.
     *
     * @param title
     *            Titulo da PlayList.
     * @param onwer
     *            Nome do dono da PlayList
     * @param musics
     *            Lista de musicas iniciais para a playlist.
     */
    public PlayList(final String title, final String onwer, final List<Music> musics) {
        this.title = new SimpleStringProperty(title);
        current = 0;
        if (musics.isEmpty()) {
            this.musics = FXCollections.observableArrayList();
        } else {
            this.musics = FXCollections.observableArrayList(musics);
        }
        owner = onwer;
    }

    /**
     * Adiciona uma musica a playlist.
     *
     * @param musicToAdd
     *            Musica a ser adicionada.
     * @return True se foi adicionada com sucesso. False caso contrario
     */
    public boolean add(final Music musicToAdd) {
        if (musicToAdd != null) {
            musics.add(musicToAdd);
            return true;
        }
        return false;
    }

    /**
     * Informa o indice da musica atual.
     *
     * @return O indice da musica atual.
     */
    public int getCurrent() {
        return current;
    }

    /**
     * Informa qual a musica atual.
     *
     * @return A musica atual.
     * @throws NoMusicSelectedException
     *             Caso o valor do indice esteja fora dos limites da lista de musicas da playlist.
     */
    public Music getMusic() throws NoMusicSelectedException {
        if ((current < 0) || (current >= musics.size())) {
            throw new NoMusicSelectedException();
        }
        return musics.get(current);
    }

    /**
     * Indica quais são as musicas da PlayList.
     *
     * @return Lista com as musicas da Playlist.
     */
    public ObservableList<Music> getMusics() {
        return musics;
    }

    /**
     * Informa o nome do dono da playlist.
     *
     * @return O nome do dono da playlist
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Informa o titulo da Playlist.
     *
     * @return O titulo da Playlist.
     */
    public String getTitle() {
        return title.get();
    }

    /**
     * Indica a TitleProperty da PlayList.
     *
     * @return A TitleProperty da PlayList.
     */
    public StringProperty getTitleProperty() {
        return title;
    }

    /**
     * Indica qual a proxima musica.
     *
     * @return A proxima musica em relação a musica atual.
     * @throws NoMoreMusicException
     *             Caso o valor do indice esteja fora dos limites da lista de musicas da playlist.
     */
    public Music next() throws NoMoreMusicException {
        if (!musics.isEmpty() && ((current + 1) < musics.size())) {
            return musics.get(++current);
        }
        throw new NoMoreMusicException();
    }

    /**
     * Indica qual a musica anterior.
     *
     * @return A musica anterior em relação a musica atual.
     * @throws NoMoreMusicException
     *             Caso o valor do indice esteja fora dos limites da lista de musicas da playlist.
     */
    public Music previous() throws NoMoreMusicException {
        if (!musics.isEmpty() && ((current - 1) >= 0)) {
            return musics.get(--current);
        }
        throw new NoMoreMusicException();
    }

    /**
     * Remove a musica indicada da lista de musicas.
     *
     * @param musicToDelete
     *            Musica a ser removida.
     */
    public void remove(final Music musicToDelete) {
        musics.remove(musicToDelete);
    }

    /**
     * Remove todas as musicas que tiverem o titulo indicado.
     *
     * @param title
     *            Titulo das musicas a serem removidas.
     */
    public void remove(final String title) {
        final ArrayList<Music> found = new ArrayList<>();
        for (final Music music : musics) {
            if (title.equals(music.getTitle())) {
                found.add(music);
            }
        }
        musics.removeAll(found);
    }

    /**
     * Altera o indice que indica a musica atual.
     *
     * @param index
     *            Novo indice.
     */
    public void setCurrent(final int index) {
        current = index;
    }

    /**
     * Altera o indice que indica a musica atual.
     *
     * @param music
     *            Musica para o novo indice. Posiciona o indice para um valor invalido caso a musica
     *            não esteja na playlist.
     */
    public void setCurrent(final Music music) {
        if (music != null) {
            current = musics.indexOf(music);
        }
    }

    /**
     * Indica o numero de musicas presentes na playlist.
     *
     * @return O numero de musicas presentes na playlist.
     */
    public int size() {
        return musics.size();
    }

    @Override
    public String toString() {
        return title.get();
    }
}
