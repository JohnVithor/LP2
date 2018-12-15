package lp.projeto.musicplayer.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import lp.projeto.musicplayer.utility.Node;

import org.junit.jupiter.api.Test;

/**
 * Classe para os testes do Node da Trie.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
class NodeTest {
    @Test
    void testEndOfWord() {
        final Node node = new Node();
        assertFalse(node.isEndOfWord());
        node.setEndOfWord(true);
        assertTrue(node.isEndOfWord());
    }

    @Test
    void testGetChild() {
        final Node node1 = new Node('a');
        final Node node2 = node1.getOrPlaceChild('b');
        final Node node3 = node1.getChild('b');
        assertEquals(node2, node3);

    }

    @Test
    void testGetChildren() {
        final Node node = new Node('a');
        final Map<Character, Node> children = node.getChildren();
        assertNotEquals(children, null);
    }

    @Test
    void testGetLetter() {
        final Node node = new Node();
        assertEquals(null, node.getLetter());
        node.setLetter('a');
        assertEquals('a', node.getLetter().charValue());
    }

    @Test
    void testGetOrPlaceChild() {
        final Node node1 = new Node('a');
        assertFalse(node1.hasChildren());
        final Node node2 = node1.getOrPlaceChild('b');
        assertTrue(node1.hasChildren());
        final Node node3 = node1.getOrPlaceChild('b');
        assertEquals(node2, node3);
    }

    @Test
    void testHasChildren() {
        final Node node = new Node('a');
        assertFalse(node.hasChildren());
        node.getOrPlaceChild('b');
        assertTrue(node.hasChildren());
    }

    @Test
    void testNode() {
        final Node node = new Node();
        assertEquals(null, node.getLetter());
        assertFalse(node.isEndOfWord());
        assertFalse(node.hasChildren());
        assertEquals(null, node.getMusic());
    }

    @Test
    void testNodeChar() {
        final Node node = new Node('a');
        assertEquals('a', node.getLetter().charValue());
        assertFalse(node.isEndOfWord());
        assertFalse(node.hasChildren());
        assertEquals(null, node.getMusic());
    }

    @Test
    void testRemoveChild() {
        final Node node1 = new Node('a');
        node1.getOrPlaceChild('c');
        assertTrue(node1.hasChildren());
        node1.removeChild('c');
        assertFalse(node1.hasChildren());
    }

    @Test
    void testSetChildren() {
        final Node node1 = new Node('a');
        final Node node2 = new Node('b');
        final Node node3 = node1.getOrPlaceChild('c');
        node2.setChildren(node1.getChildren());
        assertEquals(node3, node2.getChild('c'));
    }
}
