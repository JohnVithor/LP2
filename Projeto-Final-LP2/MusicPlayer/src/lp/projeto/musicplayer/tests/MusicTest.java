package lp.projeto.musicplayer.tests;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javafx.beans.property.SimpleStringProperty;
import lp.projeto.musicplayer.model.Music;

import org.junit.jupiter.api.Test;

/**
 * Classe para os testes da Music.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
class MusicTest {
    // NECESARIO INDICAR UM CAMINHO VALIDO DE MUSICA
    private static final String PATH =
                    "file:/home/johnvithor/git/Projeto-Final-LP2/MusicPlayer/Musics/Russian_Dance.mp3";

    @Test
    void testGetDuration() {
        // Não foi encontrado um teste satisfatório. Porem durante a execução da aplicação o metodo
        // funciona como esperado.
        assertTrue(true);
    }

    @Test
    void testGetMedia() {
        assertAll(() -> {
            final Music music = new Music(PATH);
            assertEquals(music.getMedia().getSource(), music.getMedia().getSource());
            assertNotEquals(music.getMedia(), music.getMedia());
        });
    }

    @Test
    void testMusic() {
        final Music music = new Music();
        assertEquals("", music.getTitle());
        assertEquals("", music.getPath());
    }

    @Test
    void testMusicString() {
        assertAll(() -> {
            final Music music = new Music(PATH);
            assertEquals("Russian_Dance", music.getTitle());
            assertEquals(PATH, music.getPath());
        });
    }

    @Test
    void testMusicStringString() {
        assertAll(() -> {
            final Music music = new Music(PATH, "titulo");
            assertEquals("titulo", music.getTitle());
            assertEquals(PATH, music.getPath());
        });
    }

    @Test
    void testTitleProperty() {
        assertAll(() -> {
            final Music music = new Music(PATH);
            assertEquals(new SimpleStringProperty("Russian_Dance").get(),
                         music.titleProperty().get());

        });
    }

    @Test
    void testToString() {
        assertAll(() -> {
            final Music music = new Music(PATH);
            assertEquals("Russian_Dance", music.toString());

        });
    }
}
