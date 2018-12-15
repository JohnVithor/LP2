package lp.projeto.musicplayer.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe que modela um Usuário Vip.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class UserVip extends User {

    private ObservableList<PlayList> playlists;

    /**
     * Construtor parametrizado de um usuário vip. utilizando um login, uma senha e um id.
     * Inicializa a lista de playlists.
     *
     * @param login
     *            Login do usuário.
     * @param senha
     *            Senha do usuário
     * @param id
     *            Id do usuário.
     */
    public UserVip(final String login, final String senha, final int id) {
        super(login, senha, id);
        playlists = FXCollections.observableArrayList();
    }

    /**
     * Adiciona uma nova playlist a lista de playlists.
     *
     * @param playList
     *            nova playList.
     */
    public void addPlayList(final PlayList playList) {
        playlists.add(playList);
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof UserVip)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return super.equals(obj);
    }

    /**
     * Informa qual é a lista de playlists do usuario.
     *
     * @return A lista de playlists do usuario.
     */
    public ObservableList<PlayList> getPlaylists() {
        return playlists;
    }

    /**
     * Remove uma playList da lista de playlists.
     *
     * @param playList
     *            playlist a ser removida.
     */
    public void removePlayList(final PlayList playList) {
        playlists.remove(playList);
    }

    /**
     * Altera a lita de playlists para outra.
     *
     * @param playlists
     *            A nova lista de playlists.
     */
    public void setPlaylists(final ObservableList<PlayList> playlists) {
        this.playlists = playlists;
    }
}
