package practice.p3_2;

public class DoubleLinkDemo {

    public static void main(String[] args) {
        DoubleLink<Integer> table = new DoubleLink<>();
        table.add(1);
        table.add(2);
        table.add(3);
        table.add(4);
        System.out.println(table.toString());
        table.swap(2, 1);
        System.out.println(table.toString());
    }
}

class DoubleLink<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    DoubleLink() {
    }

    void add(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        last = newNode;
        size++;
    }

    void swap(int x, int y) {
        checkInput(x, y);
        Node<E> prev = node(x < y ? x : y);
        Node<E> next = prev.next;
        prev.next = next.next;
        next.prev = prev.prev;
        prev.prev = next;
        next.next = prev;
        if (next.prev != null)
            next.prev.next = next;
        else
            first = next;
        if (prev.next != null)
            prev.next.prev = prev;
        else
            last = prev;
    }

    private Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> r = first;
            for (int i = 0; i < index; i++)
                r = r.next;
            return r;
        } else {
            Node<E> r = last;
            for (int i = size - 1; i > index; i--)
                r = last.prev;
            return r;
        }
    }

    private void checkInput(int x, int y) {
        if (rangeCheck(x) && rangeCheck(y)) {
            if (Math.abs(x - y) != 1) {
                throw new IllegalArgumentException("The input parameters must be contiguous");
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean rangeCheck(int val) {
        return 0 <= val && val < size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<E> x = first;
        for (int i = 0; i < size; i++) {
            str.append(x.item.toString());
            x = x.next;
        }
        return str.toString();
    }

    class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}
