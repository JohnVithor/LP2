package lp.projeto.musicplayer.utility;

/**
 * Classe que representa um nó binário.
 *
 * @author JohnVithor
 * @author Gleydvan
 * @param <T>
 *            Classe do tipo de objeto armazenados no nó.
 */
public class BinaryNode<T> {

    private T data;

    private BinaryNode<T> parent;

    private BinaryNode<T> left;

    private BinaryNode<T> right;

    private int balanceFactor;

    /**
     * Construtor padrão de um nó.
     */
    public BinaryNode() {
        data = null;
        parent = null;
        left = null;
        right = null;
        balanceFactor = 0;
    }

    /**
     * Construtor parametrizado de um nó.
     *
     * @param data
     *            Conteudo inicial armazenado pelo nó.
     */
    public BinaryNode(final T data) {
        this.data = data;
        parent = null;
        left = null;
        right = null;
        balanceFactor = 0;
    }

    /**
     * Recupera o balanço do nó.
     *
     * @return O balanço do nó.
     */
    public int getBalanceFactor() {
        return balanceFactor;
    }

    /**
     * Recupera o conteudo armazenado pelo nó.
     *
     * @return O conteudo armazenado pelo nó.
     */
    public T getData() {
        return data;
    }

    /**
     * Recupera o filho esquerdo do nó.
     *
     * @return O filho esquerdo do nó.
     */
    public BinaryNode<T> getLeft() {
        return left;
    }

    /**
     * Recupera o pai do nó.
     *
     * @return O pai do nó.
     */
    public BinaryNode<T> getParent() {
        return parent;
    }

    /**
     * Recupera o filho direito do nó.
     *
     * @return O filho direito do nó.
     */
    public BinaryNode<T> getRight() {
        return right;
    }

    /**
     * Altera o balanço do nó.
     *
     * @param balanceFactor
     *            Novo balanço do nó.
     */
    public void setBalanceFactor(final int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    /**
     * Altera o conteudo armazenado pelo nó.
     *
     * @param data
     *            Novo conteudo armazenado pelo nó.
     */
    public void setData(final T data) {
        this.data = data;
    }

    /**
     * Altera o filho esquerdo do nó.
     *
     * @param left
     *            Novo filho esquerdo do nó.
     */
    public void setLeft(final BinaryNode<T> left) {
        this.left = left;
    }

    /**
     * Altera o pai do nó.
     *
     * @param parent
     *            Novo pai do nó.
     */
    public void setParent(final BinaryNode<T> parent) {
        this.parent = parent;
    }

    /**
     * Altera o filho direito do nó.
     *
     * @param right
     *            Novo filho direito do nó.
     */
    public void setRight(final BinaryNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "" + data;
    }

}
