package lp.projeto.musicplayer.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import lp.projeto.musicplayer.model.User;
import lp.projeto.musicplayer.model.UserPasswordInvalidException;
import lp.projeto.musicplayer.utility.AvlTree;
import lp.projeto.musicplayer.utility.BinaryNode;

import org.junit.jupiter.api.Test;

/**
 * Classe para os testes da AvlTree.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
class AvlTreeTest {

    private void populate(final AvlTree<User> tree) throws UserPasswordInvalidException {
        tree.insert(new User("joao", User.cryptography("senha1"), 1));
        tree.insert(new User("maria", User.cryptography("senha2"), 2));
        tree.insert(new User("jose", User.cryptography("senha3"), 3));
        tree.insert(new User("ana", User.cryptography("senha4"), 4));
    }

    @Test
    void testAvlTree() {
        final AvlTree<User> tree = new AvlTree<>();
        assertEquals(null, tree.getRoot());
        assertEquals(0, tree.size());
    }

    @Test
    void testInorder() throws UserPasswordInvalidException {
        final AvlTree<User> tree = new AvlTree<>();
        List<User> result = tree.inorder();
        assertEquals(tree.size(), result.size());
        populate(tree);
        result = tree.inorder();
        assertEquals(tree.size(), result.size());
    }

    @Test
    void testInsertAndSize() throws UserPasswordInvalidException {
        final AvlTree<User> tree = new AvlTree<>();
        final User joao = new User("joao", User.cryptography("senha1"), 1);
        tree.insert(joao);
        assertEquals(1, tree.size());
        assertEquals(joao, tree.getRoot().getData());
        final User maria = new User("maria", User.cryptography("senha2"), 2);
        tree.insert(maria);
        assertEquals(2, tree.size());
        final User jose = new User("jose", User.cryptography("senha2"), 3);
        tree.insert(jose);
        assertEquals(3, tree.size());
        assertEquals(maria, tree.getRoot().getData());
    }

    @Test
    void testMaximum() throws UserPasswordInvalidException {
        final AvlTree<User> tree = new AvlTree<>();
        populate(tree);
        final User horacio = new User("Horacio", User.cryptography("senha5"), 5);
        tree.insert(horacio);
        final BinaryNode<User> result = tree.maximum();
        assertEquals(horacio, result.getData());

    }

    @Test
    void testMaximumBinaryNodeOfT() throws UserPasswordInvalidException {
        final AvlTree<User> tree = new AvlTree<>();
        populate(tree);
        final User horacio = new User("Horacio", User.cryptography("senha5"), 5);
        tree.insert(horacio);
        final BinaryNode<User> result = tree.maximum(tree.getRoot().getRight());
        assertEquals(horacio, result.getData());
    }

    @Test
    void testMinimum() throws UserPasswordInvalidException {
        final AvlTree<User> tree = new AvlTree<>();
        populate(tree);
        final User mozart = new User("Mozart", User.cryptography("senha6"), -1);
        tree.insert(mozart);
        final BinaryNode<User> result = tree.minimum();
        assertEquals(mozart, result.getData());
    }

    @Test
    void testMinimumBinaryNodeOfT() throws UserPasswordInvalidException {
        final AvlTree<User> tree = new AvlTree<>();
        populate(tree);
        final User mozart = new User("Mozart", User.cryptography("senha6"), -1);
        tree.insert(mozart);
        final BinaryNode<User> result = tree.minimum(tree.getRoot().getLeft());
        assertEquals(mozart, result.getData());
    }

    @Test
    void testRemove() throws UserPasswordInvalidException {
        final AvlTree<User> tree = new AvlTree<>();
        populate(tree);
        final User horacio = new User("Horacio", User.cryptography("senha5"), 5);
        tree.insert(horacio);
        assertEquals(5, tree.size());
        tree.remove(horacio);
        assertEquals(4, tree.size());
        BinaryNode<User> result = tree.searchNode(horacio);
        assertEquals(null, result);
        final User root = tree.getRoot().getData();
        result = tree.searchNode(root);
        assertEquals(root, result.getData());
        tree.remove(root);
        result = tree.searchNode(root);
        assertEquals(null, result);
    }

    @Test
    void testSearchByName() throws UserPasswordInvalidException {
        final AvlTree<User> tree = new AvlTree<>();
        populate(tree);
        User result = tree.searchByName("joao");
        assertEquals("joao", result.getName());
        result = tree.searchByName("Horacio");
        assertEquals(null, result);
    }

    @Test
    void testSearchNode() throws UserPasswordInvalidException {
        final AvlTree<User> tree = new AvlTree<>();
        populate(tree);
        final User horacio = new User("Horacio", User.cryptography("senha5"), 5);
        tree.insert(horacio);
        BinaryNode<User> result = tree.searchNode(horacio);
        assertEquals(horacio, result.getData());
        final User mozart = new User("Mozart", User.cryptography("senha6"), 6);
        result = tree.searchNode(mozart);
        assertEquals(null, result);
    }

}
