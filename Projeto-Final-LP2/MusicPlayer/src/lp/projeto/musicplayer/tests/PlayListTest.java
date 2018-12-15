package lp.projeto.musicplayer.tests;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;

import lp.projeto.musicplayer.model.Music;
import lp.projeto.musicplayer.model.PlayList;

import org.junit.jupiter.api.Test;

/**
 * Classe para os testes da PlayList.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
class PlayListTest {

    @Test
    void testAddGetMusic() {
        final PlayList list = new PlayList();

        final Music added = new Music();
        list.add(added);

        assertAll(() -> {
            final Music m = list.getMusic();
            assertEquals(added, m);
        });
    }

    @Test
    void testGetTitleProperty() {
        final PlayList list = new PlayList();
        assertEquals(new SimpleStringProperty("").get(), list.getTitleProperty().get());
    }

    @Test
    void testNext() {
        final PlayList list = new PlayList();
        final Music added1 = new Music();
        final Music added2 = new Music();
        list.add(added1);
        list.add(added2);
        assertAll(() -> {
            Music m = list.getMusic();
            assertEquals(added1, m);
            list.next();
            m = list.getMusic();
            assertEquals(added2, m);
        });
    }

    @Test
    void testPlayList() {
        final PlayList list = new PlayList();
        assertEquals("", list.getTitle());
        assertEquals("", list.getOwner());
        assertEquals(0, list.size());
    }

    @Test
    void testPlayListStringString() {
        final PlayList list = new PlayList("titulo", "dono");
        assertEquals("titulo", list.getTitle());
        assertEquals("dono", list.getOwner());
        assertEquals(0, list.size());
    }

    @Test
    void testPlayListStringStringListOfMusic() {
        final PlayList list = new PlayList("titulo", "dono", new ArrayList<>());
        assertEquals("titulo", list.getTitle());
        assertEquals("dono", list.getOwner());
        assertEquals(0, list.size());
    }

    @Test
    void testPrevious() {
        final PlayList list = new PlayList();
        final Music added1 = new Music();
        final Music added2 = new Music();
        list.add(added1);
        list.add(added2);
        assertAll(() -> {
            list.next();
            Music m = list.getMusic();
            assertEquals(added2, m);
            list.previous();
            m = list.getMusic();
            assertEquals(added1, m);
        });
    }

    @Test
    void testRemoveMusic() {
        final PlayList list = new PlayList();
        final Music added = new Music();
        list.add(added);
        assertEquals(1, list.size());
        list.remove(added);
        assertEquals(0, list.size());
    }

    @Test
    void testRemoveString() {
        final PlayList list = new PlayList();
        final Music added = new Music();
        list.add(added);
        assertEquals(1, list.size());
        list.remove("");
        assertEquals(0, list.size());
    }

    @Test
    void testSetGetCurrent() {
        final PlayList list = new PlayList();
        assertEquals(0, list.getCurrent());
        list.setCurrent(3);
        assertEquals(3, list.getCurrent());
        list.setCurrent(new Music());
        assertEquals(-1, list.getCurrent());
    }

    @Test
    void testToString() {
        final PlayList list = new PlayList();
        assertEquals("", list.toString());
    }
}
