package lp.projeto.musicplayer.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lp.projeto.musicplayer.utility.BinaryNode;

import org.junit.jupiter.api.Test;

/**
 * Classe para os testes do BinaryNode.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
class BinaryNodeTest {

    @Test
    void testBinaryNode() {
        final BinaryNode<Integer> node = new BinaryNode<>();
        assertEquals(null, node.getData());
        assertEquals(null, node.getLeft());
        assertEquals(null, node.getRight());
        assertEquals(null, node.getParent());
        assertEquals(0, node.getBalanceFactor());
    }

    @Test
    void testBinaryNodeT() {
        final BinaryNode<Integer> node = new BinaryNode<>(4);
        assertEquals(4, node.getData().intValue());
        assertEquals(null, node.getLeft());
        assertEquals(null, node.getRight());
        assertEquals(null, node.getParent());
        assertEquals(0, node.getBalanceFactor());
    }

    @Test
    void testSets() {
        final BinaryNode<Integer> node = new BinaryNode<>();
        assertEquals(null, node.getData());
        node.setData(4);
        assertEquals(4, node.getData().intValue());
        assertEquals(null, node.getLeft());
        final BinaryNode<Integer> left = new BinaryNode<>(3);
        node.setLeft(left);
        assertEquals(left, node.getLeft());
        assertEquals(null, node.getRight());
        final BinaryNode<Integer> right = new BinaryNode<>(5);
        node.setRight(right);
        assertEquals(null, node.getParent());
        final BinaryNode<Integer> parent = new BinaryNode<>(0);
        node.setParent(parent);
        assertEquals(0, node.getBalanceFactor());
        node.setBalanceFactor(1);
        assertEquals(1, node.getBalanceFactor());
    }

    @Test
    void testToString() {
        final BinaryNode<Integer> node = new BinaryNode<>();
        assertEquals("null", node.toString());
        node.setData(4);
        assertEquals("4", node.toString());
    }

}
