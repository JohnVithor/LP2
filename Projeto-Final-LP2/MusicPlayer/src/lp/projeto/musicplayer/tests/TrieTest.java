package lp.projeto.musicplayer.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import lp.projeto.musicplayer.utility.Trie;

import org.junit.jupiter.api.Test;

/**
 * Classe para os testes da Trie.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
class TrieTest {
    @Test
    final void testContainsWord() {
        final Trie t = new Trie();
        t.insert("teste");
        assertEquals(true, t.containsWord("teste"));
    }

    @Test
    final void testDelete() {
        final Trie t = new Trie();
        t.insert("teste");
        assertEquals(false, t.isEmpty());
        t.remove("teste");
        assertEquals(true, t.isEmpty());
    }

    @Test
    final void testInsert() {
        final Trie t = new Trie();
        t.insert("teste");
        assertEquals(false, t.isEmpty());
    }

    @Test
    final void testIsEmpty() {
        final Trie t = new Trie();
        assertEquals(true, t.isEmpty());
    }

    @Test
    final void testRecoverAllWords() {
        final Trie t = new Trie();
        t.insert("teste");
        t.insert("testa");
        final List<String> s = t.recoverAllWords();
        final String testa = s.get(0);
        assertEquals("testa", testa);
        final String teste = s.get(1);
        assertEquals("teste", teste);
    }

    @Test
    final void testRecoverWords() {
        final Trie t = new Trie();
        t.insert("teste");
        final List<String> s = t.recoverWords("tes");
        final String teste = s.get(0);
        assertEquals("teste", teste);
    }
}
