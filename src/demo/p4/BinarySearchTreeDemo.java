package demo.p4;

/**
 * 二分查找树简单实现
 */
public class BinarySearchTreeDemo {


}

class BinarySearchTree<T extends Comparable<T>> {

    private BinaryNode<T> rootNode;

    BinarySearchTree(T rootValue) {
        rootNode = new BinaryNode<>(rootValue);
    }

    boolean contains(T x) {
        return contains(x, rootNode);
    }

    private boolean contains(T x, BinaryNode<T> node) {
        if (node == null) return false;
        if (node.element.compareTo(x) > 0) {
            return contains(x, node.right);
        } else if (node.element.compareTo(x) < 0) {
            return contains(x, node.left);
        } else {
            return true;
        }
    }

    BinaryNode<T> finMin() {
        return null;
    }

    BinaryNode<T> findMax() {
        return null;
    }

    boolean insert(T x) {
        return true;
    }

    private

    BinaryNode<T> remove() {
        return null;
    }
}

class BinaryNode<T extends Comparable<T>> {

    T element;
    BinaryNode<T> left;
    BinaryNode<T> right;

    BinaryNode(T element) {
        this.element = element;
    }
}
