package demo.p4;

/**
 * 二分查找树简单实现
 */
public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(10);
        System.out.println("min: " + tree.findMin());
        System.out.println("max: " + tree.findMax());
        tree.insert(4);
        tree.insert(2);
        tree.insert(12);
        tree.insert(16);
        tree.insert(12);
        tree.insert(1);
        System.out.println("min: " + tree.findMin());
        System.out.println("max: " + tree.findMax());
        System.out.println("contains: 1----- " + tree.contains(1));
        System.out.println("contains: 5----- " + tree.contains(5));
        tree.remove(1);
        System.out.println("min: " + tree.findMin());
        tree.insert(2);
        tree.insert(1);
        System.out.println("min: " + tree.findMin());
    }
}

class BinarySearchTree<T extends Comparable<T>> {

    private BinaryNode<T> rootNode;

    BinarySearchTree() {
    }

    BinarySearchTree(T rootValue) {
        rootNode = new BinaryNode<>(rootValue);
    }

    boolean contains(T x) {
        return containsInternal(x, rootNode);
    }

    private boolean containsInternal(T x, BinaryNode<T> node) {
        if (node == null) return false;
        if (node.element.compareTo(x) < 0) {
            return containsInternal(x, node.right);
        } else if (node.element.compareTo(x) > 0) {
            return containsInternal(x, node.left);
        } else {
            return true;
        }
    }

    T findMin() {
        if (rootNode == null) {
            System.out.println("Can't find min because tree is empty");
            return null;
        }
        return findMinInternal(rootNode).element;
    }

    private BinaryNode<T> findMinInternal(BinaryNode<T> node) {
        if (node.left != null) {
            return findMinInternal(node.left);
        } else {
            return node;
        }
    }

    T findMax() {
        if (rootNode == null) {
            System.out.println("Can't find max because tree is empty");
            return null;
        }
        return findMaxInternal(rootNode).element;
    }

    private BinaryNode<T> findMaxInternal(BinaryNode<T> node) {
        if (node.right != null) {
            return findMaxInternal(node.right);
        } else {
            return node;
        }
    }

    boolean insert(T x) {
        if (contains(x)) return false;
        insertInternal(x, rootNode);
        return true;
    }

    private BinaryNode<T> insertInternal(T x, BinaryNode<T> node) {
        if (node == null) {
            return new BinaryNode<>(x);
        }
        if (x.compareTo(node.element) > 0) {
            node.right = insertInternal(x, node.right);
        } else if (x.compareTo(node.element) < 0) {
            node.left = insertInternal(x, node.left);
        }
        return node;
    }

    boolean remove(T x) {
        if (!contains(x)) return false;
        removeInternal(x, rootNode);
        return true;
    }

    private BinaryNode<T> removeInternal(T x, BinaryNode<T> node) {
        if (node == null) {
            return null;
        }
        if (x.compareTo(node.element) > 0) {
            node.right = removeInternal(x, node.right);
        } else if (x.compareTo(node.element) < 0) {
            node.left = removeInternal(x, node.left);
        } else if (node.left != null && node.right != null) {
            BinaryNode<T> minNode = removeMin(x, node.right);
            node.element = minNode.element;
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    /**
     * 找到并删除最小的元素节点
     */
    private BinaryNode<T> removeMin(T x, BinaryNode<T> node) {
        if (node == null) {
            return null;
        }
        if (x.compareTo(node.element) > 0) {
            node.right = removeMin(x, node.right);
        } else if (x.compareTo(node.element) < 0) {
            node.left = removeMin(x, node.left);
        } else if (node.left != null && node.right != null) {
            BinaryNode<T> minNode = removeMin(x, node.right);
            node.element = minNode.element;
        } else {
            node = (node.left == null) ? node : node.left;
        }
        return node;
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
