package practice.p3.p3_11;

public class Demo {

    public static void main(String[] args) {
        SingleLinked<String> linked = new SingleLinked<>();
        linked.add("a");
        linked.add("b");
        linked.add("b");
        linked.add("c");
        linked.add("d");
        System.out.println("链表初始化完成:  " + linked.toString());
        System.out.println("链表长度为:  " + linked.size());
        System.out.println("链表是否包含a:  " + linked.contains("a"));
        System.out.println("链表是否包含f:  " + linked.contains("f"));
        System.out.println("从链表中删除n:  ");
        linked.remove("n");
        System.out.println("删除后的链表:  " + linked.toString());
        System.out.println("从链表中删除a:  ");
        linked.remove("a");
        System.out.println("删除后的链表:  " + linked.toString());
    }
}

class SingleLinked<E> {

    /**
     * 只使用头结点
     */
    Node<E> first;
    private int size;

    /**
     * 返回该链表的长度
     *
     * @return 链表的长度
     */
    int size() {
        return size;
    }

    /**
     * 判断所传入的元素是否包含于链表
     *
     * @param e 所传入的元素
     * @return 是否包含
     */
    boolean contains(E e) {
        return node(e) != null;
    }

    /**
     * 如果传入的元素尚未含于链表,添加元素到链表
     *
     * @param e
     */
    void add(E e) {
        Node<E> n = node(e);
        if (n != null) return;
        n = new Node<>(e, null);
        if (first == null) {
            first = n;
        } else {
            Node<E> last = getLastNode();
            last.next = n;
        }
        size++;
    }

    /**
     * 如果传入元素含于链表,则将传入元素从链表中删除
     *
     * @param e 传入元素
     * @return 返回被删除的元素
     */
    E remove(E e) {
        Node<E> n = node(e);
        if (n == null) return null;
        Node<E> prev = getPrevNode(e);
        if (n == first) first = n.next;
        prev.next = n.next;
        return n.element;
    }

    /**
     * 返回传入元素对应的节点
     *
     * @param e 传入的元素
     * @return 对应的节点
     */
    private Node<E> node(E e) {
        Node<E> n = first;
        for (int i = 0; i < size; i++) {
            if (n.element == e)
                break;
            else
                n = n.next;
        }
        return n;
    }

    /**
     * 获取传入元素的前一个节点
     *
     * @param e 传入元素
     * @return 前一个节点, 头结点返回头结点自己
     */
    private Node<E> getPrevNode(E e) {
        Node<E> n = first;
        for (int i = 0; i < size; i++) {
            if (first.element == e)
                break;
            else if (n.next.element == e)
                break;
            else
                n = n.next;
        }
        return n;
    }

    /**
     * 获取最后一个节点
     *
     * @return 最后一个节点
     */
    private Node<E> getLastNode() {
        Node<E> n = first;
        for (int i = 0; i < size; i++) {
            if (n.next == null)
                break;
            else
                n = n.next;
        }
        return n;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (node != null) {
                builder.append(node.element);
                node = node.next;
            }
        }
        return builder.toString();
    }

    class Node<E> {
        E element;
        Node<E> next;

        Node(E e, Node<E> next) {
            element = e;
            this.next = next;
        }
    }
}

