package lp.projeto.musicplayer.utility;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lp.projeto.musicplayer.model.Music;

/**
 * Classe que modela uma arvore Trie de Prefixos.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class Trie {

    private final Node root;

    /**
     * Construtor padrão da Trie.
     */
    public Trie() {
        root = new Node();
    }

    /**
     * Verifica se a arvore possui a palavra indicada.
     *
     * @param word
     *            Palavra a ser verificada.
     * @return True caso a palavra esteja presente.
     */
    public boolean containsWord(final String word) {
        Node current = root;
        for (int i = 0; i < word.length(); ++i) {
            final char ch = word.charAt(i);
            final Node node = current.getChild(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    /**
     * Insere uma musica a partir de seu titulo.
     *
     * @param music
     *            Musica a ser inserida.
     * @return Nó onde a musica foi inserida.
     */
    public Node insert(final Music music) {
        final Node current = insert(music.getTitle());
        current.setMusic(music);
        return current;
    }

    /**
     * Insere uma palavra na arvore.
     *
     * @param word
     *            Palavra a ser inserida
     * @return Nó final da palavra inserida.
     */
    public Node insert(final String word) {
        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            current = current.getOrPlaceChild(word.charAt(i));
        }
        current.setEndOfWord(true);
        return current;
    }

    /**
     * Verifica se a arvore esta vazia.
     *
     * @return True se não houver nenhuma palavra cadastrada.
     */
    public boolean isEmpty() {
        return !root.hasChildren();
    }

    /**
     * Recupera todas as musicas armazenadas.
     *
     * @return Lista de musicas armazenadas.
     */
    public ObservableList<Music> recoverAllMusics() {
        final ObservableList<Music> result = FXCollections.observableArrayList();
        if (isEmpty()) {
            return result;
        }
        recoverMusics(root, result);
        return result;
    }

    /**
     * Recupera todas as palavras armazenadas.
     *
     * @return Lista com todas as palavras armazenadas.
     */
    public List<String> recoverAllWords() {
        final List<String> result = new ArrayList<>();
        if (isEmpty()) {
            return result;
        }
        recoverWords(root, result, "");
        return result;
    }

    /**
     * Recupera as musicas presentes no nó atual ou nos seus filhos. Recursivamante.
     *
     * @param node
     *            Nó atual da busca.
     * @param list
     *            Lista de musicas encontradas.
     */
    private void recoverMusics(final Node node, final ObservableList<Music> list) {
        for (final Node child : node.getChildren().values()) {
            if (child.isEndOfWord()) {
                list.add(child.getMusic());
            }
            if (child.hasChildren()) {
                recoverMusics(child, list);
            }
        }
    }

    /**
     * Recupera todas as musicas armazenadas a partir da palavra indicada..
     *
     * @param word
     *            Palavra usada para a pesquisa.
     * @return Lista de musicas encontradas com a palavra utilizada..
     */
    public ObservableList<Music> recoverMusics(final String word) {
        final ObservableList<Music> result = FXCollections.observableArrayList();
        if (isEmpty()) {
            return result;
        }
        Node current = root;

        for (int i = 0; i < word.length(); ++i) {
            final char ch = word.charAt(i);
            final Node node = current.getChild(ch);
            if (node == null) {
                return result;
            }
            current = node;
        }
        if (current.isEndOfWord()) {
            result.add(current.getMusic());
        }
        recoverMusics(current, result);
        return result;
    }

    /**
     * Recupera as palavras a partir do nó indicado. Recursivamente.
     *
     * @param node
     *            Nó alvo da busca.
     * @param list
     *            Lista de palavras encontradas
     * @param word
     *            Possivel prefixo de uma palavra ser adicionada a lista de palavras.
     */
    private void recoverWords(final Node node, final List<String> list, final String word) {
        for (final Node child : node.getChildren().values()) {
            if (child.isEndOfWord()) {
                list.add(word + child.getLetter());
            }
            if (child.hasChildren()) {
                recoverWords(child, list, word + child.getLetter());
            }
        }
    }

    /**
     * Recupera todas as palavras a partir da palavra indicada.
     *
     * @param word
     *            Palavra indicada.
     * @return Lista com todas as palavras encontradas a partir da palavra indicada.
     */
    public List<String> recoverWords(final String word) {
        final List<String> result = new ArrayList<>();
        if (isEmpty()) {
            return result;
        }
        Node current = root;

        for (int i = 0; i < word.length(); ++i) {
            final char ch = word.charAt(i);
            final Node node = current.getChild(ch);
            if (node == null) {
                return result;
            }
            current = node;
        }
        if (current.isEndOfWord()) {
            result.add(word);
        }
        recoverWords(current, result, word);
        return result;
    }

    /**
     * Remove a palavra indicada a partir do nó indicado.
     *
     * @param current
     *            Nó atual da busca pra a remoção.
     * @param word
     *            Palvra ser removida.
     * @param index
     *            indice da letra atualmente sendo verificada.
     * @return True se foi removida e false caso a palavra não foi encontrada.
     */
    private boolean remove(final Node current, final String word, final int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            current.setMusic(null);
            return !current.hasChildren();
        }
        final char ch = word.charAt(index);
        final Node node = current.getChild(ch);
        if (node == null) {
            return false;
        }
        final boolean shouldDeleteCurrentNode = remove(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.removeChild(ch);
            return !current.hasChildren();
        }
        return false;
    }

    /**
     * Remove uma palavra da arvore.
     *
     * @param word
     *            Palavra a ser removida.
     * @return True se a palavra foi removida, false caso contrario.
     */
    public boolean remove(final String word) {
        return remove(root, word, 0);
    }
}
