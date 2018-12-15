package lp.projeto.musicplayer.utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma árvore binaria de busca utilizando a técnica das rotações de uma arvore
 * AVL, adicionada a busca por nome, desde que o classe armazenada implemente a interface Named.
 *
 * @author JohnVithor
 * @author Gleydvan
 * @param <T>
 *            Parâmetro para a Classe dos objetos a serem armazenados, devem implementar as
 *            interfaces Comparable e Named.
 */
public class AvlTree<T extends Comparable<T> & Named> {

    int size = 0;

    private BinaryNode<T> root;

    /**
     * Construtor padrão que inicia a raiz da arvore em nulo.
     */
    public AvlTree() {
        root = null;
    }

    /**
     * Indica qual o nó atualmente na raiz da arvore.
     *
     * @return A raiz da arvore.
     */
    public BinaryNode<T> getRoot() {
        return root;
    }

    /**
     * Indica a altura do nó selecionado.
     *
     * @param current
     *            Nó a ter a altura retornada.
     * @return Altura do nó indicado.
     */
    private int height(final BinaryNode<T> current) {
        if (current == null) {
            return -1;
        }
        if ((current.getLeft() == null) && (current.getRight() == null)) {
            return 0;
        } else if (current.getLeft() == null) {
            return 1 + height(current.getRight());
        } else if (current.getRight() == null) {
            return 1 + height(current.getLeft());
        } else {
            return 1 + Math.max(height(current.getLeft()), height(current.getRight()));
        }
    }

    /**
     * Retorna um lista com os elementos armazenados.
     *
     * @return Lista com elementos armazenados.
     */
    public List<T> inorder() {
        final List<T> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    /**
     * Preenche a lista passada com os elementos da subarvore indicado pelo nó. Recursivamente.
     *
     * @param node
     *            Nó a preencher a lista.
     * @param result
     *            Lista a ser preenchida.
     */
    private void inorder(final BinaryNode<T> node, final List<T> result) {
        if (node == null) {
            return;
        }
        inorder(node.getLeft(), result);
        result.add(node.getData());
        inorder(node.getRight(), result);
    }

    /**
     * Método recursivo para auxiliar a inserção de um objeto na arvore.
     *
     * @param current
     *            Nó atual da possivel inserção.
     * @param target
     *            Objeto a ser inserido.
     * @return True se foi possível inserir o objeto, false já exista um objeto equivalente ao
     *         indicado.
     */
    private boolean insert(final BinaryNode<T> current, final BinaryNode<T> target) {
        final int compareResult = target.getData().compareTo(current.getData());
        if (compareResult == 0) {
            return false;
        }
        if (compareResult < 0) {
            if (current.getLeft() == null) {
                current.setLeft(target);
                target.setParent(current);
                verifyBalance(current);
                ++size;
                return true;
            } else {
                return insert(current.getLeft(), target);
            }
        } else {
            if (current.getRight() == null) {
                current.setRight(target);
                target.setParent(current);
                verifyBalance(current);
                ++size;
                return true;
            } else {
                return insert(current.getRight(), target);
            }
        }
    }

    /**
     * Insere um novo objeto na arvore.
     *
     * @param target
     *            Objeto a ser inserido.
     * @return True se foi possível inserir o objeto, false já exista um objeto equivalente ao
     *         indicado.
     */
    public boolean insert(final T target) {
        final BinaryNode<T> node = new BinaryNode<>(target);
        if (root == null) {
            root = node;
            size = 1;
            return true;
        }
        return insert(this.root, node);
    }

    /**
     * Realiza uma rotação dupla na seguinte sequencia: primeiro a esquerda e depois a direita.
     *
     * @param target
     *            Alvo da rotação.
     * @return resultado da ultima rotação realizada.
     */
    private BinaryNode<T> leftRightRotate(final BinaryNode<T> target) {
        target.setLeft(leftRotate(target.getLeft()));
        return rightRotate(target);
    }

    /**
     * Realiza um rotação a esquerda no nó indicado.
     *
     * @param target
     *            Nó a ser rotacionado.
     * @return Nó a direita do nó rotacionado.
     */
    private BinaryNode<T> leftRotate(final BinaryNode<T> target) {
        final BinaryNode<T> right = target.getRight();
        right.setParent(target.getParent());
        target.setRight(right.getLeft());

        if (target.getRight() != null) {
            target.getRight().setParent(target);
        }

        right.setLeft(target);
        target.setParent(right);

        if (right.getParent() != null) {
            if (right.getParent().getRight() == target) {
                right.getParent().setRight(right);
            } else if (right.getParent().getLeft() == target) {
                right.getParent().setLeft(right);
            }
        }

        setBalance(target);
        setBalance(right);

        return right;
    }

    /**
     * Indica qual o elemento maximo da arvore.
     *
     * @return Nó com o elemento maximo encontrado.
     */
    public BinaryNode<T> maximum() {
        return maximum(root);
    }

    /**
     * Indica qual o elemento maximo da subarvore cuja raiz é o nó indicado.
     *
     * @param node
     *            Raiz da subarvore a ser analisada.
     * @return Nó com o elemento maximo encontrado.
     */
    public BinaryNode<T> maximum(final BinaryNode<T> node) {
        BinaryNode<T> step = node;
        if (node == null) {
            throw new NullPointerException(
                            "Não é possivel encontrar o maximo a partir de um Node null");
        }
        BinaryNode<T> biggest = step;
        while (step != null) {
            biggest = step;
            step = step.getRight();
        }
        return biggest;
    }

    /**
     * Indica qual o elemento minimo.
     *
     * @return Nó com o elemento minimo encontrado.
     */
    public BinaryNode<T> minimum() {
        return minimum(root);
    }

    /**
     * Indica qual o elemento minimo da subarvore cuja raiz é o nó indicado.
     *
     * @param node
     *            Raiz da subarvore a ser analisada.
     * @return Nó com o elemento minimo encontrado.
     */
    public BinaryNode<T> minimum(final BinaryNode<T> node) {
        BinaryNode<T> step = node;
        if (node == null) {
            throw new NullPointerException(
                            "Não é possivel encontrar o minimo a partir de um Node null");
        }
        BinaryNode<T> smallest = step;
        while (step != null) {
            smallest = step;
            step = step.getLeft();
        }
        return smallest;
    }

    /**
     * Metodo auxiliar para remoção de um nó da arvore.
     *
     * @param current
     *            Nó atual da remoção.
     * @param target
     *            Alvo da remoção.
     * @return True se a remoção foi um sucesso. False caso o objeto não seja encontrado.
     */
    private boolean remove(final BinaryNode<T> current, final T target) {
        if (current == null) {
            return false;
        } else {
            final int compareResult = current.getData().compareTo(target);
            if (compareResult > 0) {
                return remove(current.getLeft(), target);

            } else if (compareResult < 0) {
                return remove(current.getRight(), target);

            } else {
                removeNode(current);
                --size;
                return true;
            }
        }
    }

    /**
     * Remove o objeto da arvore.
     *
     * @param target
     *            Objeto a ser removido.
     * @return True se a remoção foi um sucesso. False caso o objeto não seja encontrado.
     */
    public boolean remove(final T target) {
        if (root == null) {
            throw new NullPointerException("Não é possivel remover algo de uma árvore vazia.");
        }
        return remove(root, target);
    }

    /**
     * Remove o nó indicado da arvore.
     *
     * @param node
     *            Nó a ser removido da arvore.
     * @return True se a remoção foi bem sucedida. False caso o nó seja nulo.
     */
    private boolean removeNode(final BinaryNode<T> node) {
        if (node == null) {
            return false;
        }
        if ((node.getLeft() == null) && (node.getRight() == null)) {
            updateParent(node, null);
            return true;
        }
        if (node.getLeft() == null) {
            updateParent(node, node.getRight());
            node.getRight().setParent(node.getParent());
            return true;
        }
        if (node.getRight() == null) {
            updateParent(node, node.getLeft());
            node.getLeft().setParent(node.getParent());
            return true;
        }
        final BinaryNode<T> smallest = minimum(node.getRight());
        if (smallest.getRight() != null) {
            updateParent(smallest, smallest.getRight());
            smallest.getRight().setParent(smallest.getParent());
        }
        substitute(node, smallest);
        updateParent(smallest, null);
        return true;
    }

    /**
     * Realiza uma rotação dupla na seguinte sequencia: primeiro a direita e depois a esquerda.
     *
     * @param target
     *            Alvo da rotação.
     * @return resultado da ultima rotação realizada.
     */
    private BinaryNode<T> rightLeftRotate(final BinaryNode<T> target) {
        target.setRight(rightRotate(target.getRight()));
        return leftRotate(target);
    }

    /**
     * Realiza um rotação a direita no nó indicado.
     *
     * @param target
     *            Nó a ser rotacionado.
     * @return Nó a esquerda do nó rotacionado.
     */
    private BinaryNode<T> rightRotate(final BinaryNode<T> target) {
        final BinaryNode<T> left = target.getLeft();
        left.setParent(target.getParent());
        target.setLeft(left.getRight());

        if (target.getLeft() != null) {
            target.getLeft().setParent(target);
        }

        left.setRight(target);
        target.setParent(left);

        if (left.getParent() != null) {
            if (left.getParent().getRight() == target) {
                left.getParent().setRight(left);
            } else if (left.getParent().getLeft() == target) {
                left.getParent().setLeft(left);
            }
        }
        setBalance(target);
        setBalance(left);

        return left;
    }

    /**
     * Busca um objeto armazenado na arvore pelo seu nome.
     *
     * @param name
     *            Nome do objeto buscado.
     * @return Primeiro objeto com o nome buscado ou nulo caso não seja encontrado nenhum.
     */
    public T searchByName(final String name) {
        final List<T> list = inorder();
        for (final T element : list) {
            if (element.getName().equals(name)) {
                return element;
            }
        }
        return null;
    }

    /**
     * Busca o node em que um objeto esta armazenado a partir do objeto.
     *
     * @param target
     *            Alvo da busca.
     * @return Node em que um objeto esta armazenado ou nulo caso não senja encontrado.
     */
    public BinaryNode<T> searchNode(final T target) {
        BinaryNode<T> node = root;
        int compareResult;
        while (node != null) {
            compareResult = node.getData().compareTo(target);
            if (compareResult == 0) {
                return node;
            }
            if (compareResult < 0) {
                node = node.getRight();
            } else {
                node = node.getLeft();
            }
        }
        return node;
    }

    /**
     * Calcula o balanço do indicado.
     *
     * @param node
     *            Nó a ter o balanço alterado.
     */
    private void setBalance(final BinaryNode<T> node) {
        node.setBalanceFactor(height(node.getRight()) - height(node.getLeft()));
    }

    /**
     * Indica o numero de elementos armazenados.
     *
     * @return O numero de elementos armazenados.
     */
    public int size() {
        return size;
    }

    /**
     * Método auxiliar para substituir o conteudo de dois nós.
     *
     * @param first
     *            Primeiro nó
     * @param second
     *            Segundo nó
     */
    private void substitute(final BinaryNode<T> first, final BinaryNode<T> second) {
        final T data = first.getData();
        first.setData(second.getData());
        second.setData(data);
    }

    /**
     * Remove o node1 como filho de seu pai, substituindo sua posição pelo node2.
     *
     * @param node1
     *            node a perder o pai
     * @param node2
     *            novo filho do pai do node1
     */
    private void updateParent(final BinaryNode<T> node1, final BinaryNode<T> node2) {
        if (node1 == root) {
            root = node2;
            return;
        }
        if (node1.getParent().getLeft() == node1) {
            node1.getParent().setLeft(node2);
        } else {
            node1.getParent().setRight(node2);
        }
    }

    /**
     * Metodo interno para verificar e corrigir o balanço de um nó.
     *
     * @param current
     *            Nó a ser verificado, e talvez corrigido.
     */
    private void verifyBalance(BinaryNode<T> current) {
        setBalance(current);
        final int balanceFactor = current.getBalanceFactor();
        if (balanceFactor == -2) {
            if (height(current.getLeft().getLeft()) >= height(current.getLeft().getRight())) {
                current = rightRotate(current);
            } else {
                current = leftRightRotate(current);
            }
        } else if (balanceFactor == 2) {
            if (height(current.getRight().getRight()) >= height(current.getRight().getLeft())) {
                current = leftRotate(current);
            } else {
                current = rightLeftRotate(current);
            }
        }
        if (current.getParent() != null) {
            verifyBalance(current.getParent());
        } else {
            this.root = current;
        }
    }
}
