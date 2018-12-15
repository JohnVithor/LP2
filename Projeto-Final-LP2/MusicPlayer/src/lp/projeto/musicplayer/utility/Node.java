package lp.projeto.musicplayer.utility;

import java.util.HashMap;
import java.util.Map;

import lp.projeto.musicplayer.model.Music;

/**
 * Classe que representa um nó de um Trie por prefixo.
 *
 * @author JohnVithor
 * @author Gleydvan
 */
public class Node {

    private Map<Character, Node> children;

    private Character letter;

    private boolean endOfWord;

    private Music music;

    /**
     * Construtor padrão de um nó.
     */
    public Node() {
        children = new HashMap<>();
        letter = null;
        endOfWord = false;
        music = null;
    }

    /**
     * Construtor parametrizado para um nó a partir de um caractere.
     *
     * @param letter
     *            Caractere armazendo pelo nó.
     */
    public Node(final char letter) {
        children = new HashMap<>();
        this.letter = letter;
        endOfWord = false;
        music = null;
    }

    /**
     * Retorna o filho indicado pela letra ou nulo caso o filho indicado não exista.
     *
     * @param letter
     *            Letra do filho.
     * @return Filho indicado pela letra buscada.
     */
    public Node getChild(final char letter) {
        return children.get(letter);
    }

    /**
     * Retorna um mapa com todos os filhos do nó.
     *
     * @return Mapa com todos os filhos do nó.
     */
    public Map<Character, Node> getChildren() {
        return children;
    }

    /**
     * Recupera a letra armazenada.
     *
     * @return Letra armazenada.
     */
    public Character getLetter() {
        return letter;
    }

    /**
     * Recupera a musica armazenada.
     *
     * @return Musica armazenada.
     */
    public Music getMusic() {
        return music;
    }

    /**
     * Posiciona ou recupera o filho indicado pela letra.
     *
     * @param letter
     *            Letra do filho a ser posicionado/recuperado.
     * @return
     */
    public Node getOrPlaceChild(final Character letter) {
        return children.computeIfAbsent(letter, c -> new Node(letter));
    }

    /**
     * Indica se o nó possui algum filho.
     *
     * @return True caso tenha algum filho e false se não tiver nenhum.
     */
    public boolean hasChildren() {
        return !children.isEmpty();
    }

    /**
     * Verifica se a flag de fim de palavra esta ativa.
     *
     * @return True se o nó marca o fim de uma palavra. False caso contrario.
     */
    public boolean isEndOfWord() {
        return endOfWord;
    }

    /**
     * remove um filho do mapa de filhos.
     *
     * @param letter
     *            letra do filho a ser removido.
     * @return Nó do filho removido.
     */
    public Node removeChild(final char letter) {
        return children.remove(letter);
    }

    /**
     * Altera o mapa de filhos por um novo.
     *
     * @param children
     *            Novo mapa de filhos.
     */
    public void setChildren(final Map<Character, Node> children) {
        this.children = children;
    }

    /**
     * Altera a flag de fim de palavra.
     *
     * @param endOfWord
     *            Novo valor da flag.
     */
    public void setEndOfWord(final boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    /**
     * Altera a letra armazenada pelo nó.
     *
     * @param letter
     *            Nova letra do nó.
     */
    public void setLetter(final char letter) {
        this.letter = letter;
    }

    /**
     * Altera a musica armazenada.
     *
     * @param music
     *            Nova musica a ser armazenada.
     */
    public void setMusic(final Music music) {
        this.music = music;
    }
}
