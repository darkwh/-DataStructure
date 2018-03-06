package demo.p4;

/**
 * 二叉查找树
 */
public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        System.out.println(tree.contains(2));
        tree.insert(6);
        tree.insert(8);
        tree.insert(8);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(3);
        tree.insert(5);
        System.out.println("树中的最小元素为:  " + tree.findMin());
        System.out.println("树中的最大元素为:  " + tree.findMax());
        System.out.println("二叉树的节点个数为:  " + tree.size());
        tree.remove(2);
        System.out.println(tree.contains(2));
        System.out.println("树中的最小元素为:  " + tree.findMin());
        System.out.println("树中的最大元素为:  " + tree.findMax());
        System.out.println("二叉树的节点个数为:  " + tree.size());
    }
}

class Tree<T extends Comparable<T>> {

    private Node<T> rootNode = null;
    private int size = 0;

    /**
     * 是否包含元素
     */
    public boolean contains(T x) {
        return containsInternal(x, rootNode);
    }

    private boolean containsInternal(T x, Node<T> node) {
        if (node == null) return false;
        if (x.compareTo(node.element) < 0) {
            return containsInternal(x, node.left);
        } else if (x.compareTo(node.element) > 0) {
            return containsInternal(x, node.right);
        } else {
            return true;
        }
    }


    /**
     * 查询最小的元素
     */
    public T findMin() {
        checkEmpty();
        return findMinInternal(rootNode).element;
    }

    private Node<T> findMinInternal(Node<T> node) {
        if (node.left == null)
            return node;
        else
            return findMinInternal(node.left);

    }

    /**
     * 查询最大的元素
     */
    public T findMax() {
        checkEmpty();
        return findMaxInternal(rootNode).element;
    }

    private Node<T> findMaxInternal(Node<T> node) {
        if (node.right == null)
            return node;
        else
            return findMaxInternal(node.right);
    }

    /**
     * 插入元素
     */
    public void insert(T x) {
        rootNode = insertInternal(x, rootNode);
    }

    private Node<T> insertInternal(T x, Node<T> node) {
        if (node == null) {
            size++;
            node = new Node<>(x);
        }
        if (x.compareTo(node.element) < 0) {
            node.left = insertInternal(x, node.left);
        } else if (x.compareTo(node.element) > 0) {
            node.right = insertInternal(x, node.right);
        }
        return node;
    }

    /**
     * 删除元素
     */
    public void remove(T x) {
        checkEmpty();
        removeInternal(x, rootNode);
    }

    private Node<T> removeInternal(T x, Node<T> node) {
        if (node == null) return null;
        if (x.compareTo(node.element) < 0) {
            node.left = removeInternal(x, node.left);
        } else if (x.compareTo(node.element) > 0) {
            node.right = removeInternal(x, node.right);
        } else if (node.left != null && node.right != null) {
            Node<T> minNode = removeMin(node.right);
            node.element = minNode.element;
        } else {
            node = (node.left != null) ? node.left : node.right;
            size--;
        }
        return node;
    }

    /**
     * 查询并删除右子树最小的元素
     */
    private Node<T> removeMin(Node<T> node) {
        if (node.left != null) {
            if (node.left.left != null) {
                return node.left = removeMin(node.left);
            } else {
                Node<T> temp = node.left;
                node.left = null;
                size--;
                return temp;
            }
        } else {
            size--;
            return node;
        }
    }

    /**
     * 检查二叉树是否为空
     */
    private void checkEmpty() {
        if (rootNode == null) throw new RuntimeException("当前二叉树为空");
    }

    /**
     * 获取二叉树的节点数
     */
    public int size() {
        return size;
    }
}

class Node<T extends Comparable<T>> {

    public T element;
    public Node<T> left;
    public Node<T> right;

    Node(T element) {
        this.element = element;
    }
}
