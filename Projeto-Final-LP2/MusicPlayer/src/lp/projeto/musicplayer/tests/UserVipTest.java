package lp.projeto.musicplayer.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import lp.projeto.musicplayer.model.PlayList;
import lp.projeto.musicplayer.model.UserPasswordInvalidException;
import lp.projeto.musicplayer.model.UserVip;
import org.junit.jupiter.api.Test;

/**
 * Classe para os testes do UserVip.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
class UserVipTest {

    @Test
    void testAddPlayList() throws UserPasswordInvalidException {
        final UserVip user = new UserVip(null, null, 0);
        user.addPlayList(new PlayList());
        assertFalse(user.getPlaylists().isEmpty());
    }

    @Test
    void testGetPlaylists() throws UserPasswordInvalidException {
        final UserVip user = new UserVip(null, null, 0);
        final PlayList playlist = new PlayList();
        user.addPlayList(playlist);
        assertEquals(playlist, user.getPlaylists().get(0));
    }

    @Test
    void testRemovePlayList() throws UserPasswordInvalidException {
        final UserVip user = new UserVip(null, null, 0);
        final PlayList playlist = new PlayList();
        user.addPlayList(playlist);
        assertFalse(user.getPlaylists().isEmpty());
        user.removePlayList(playlist);
        assertTrue(user.getPlaylists().isEmpty());
    }

    @Test
    void testSetPlaylists() throws UserPasswordInvalidException {
        final UserVip user = new UserVip(null, null, 0);
        assertTrue(user.getPlaylists().isEmpty());
        final ObservableList<PlayList> lista = FXCollections.observableArrayList();
        lista.add(new PlayList());
        user.setPlaylists(lista);
        assertFalse(user.getPlaylists().isEmpty());
    }

    @Test
    void testUserVip() throws UserPasswordInvalidException {
        final UserVip user = new UserVip(null, null, 0);
        assertTrue(user.getPlaylists().isEmpty());
    }

}
