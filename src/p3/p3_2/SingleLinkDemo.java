package p3.p3_2;

public class SingleLinkDemo {

    public static void main(String[] args) {
        SingleLinked<Integer> table = new SingleLinked<>();
        table.add(1);
        table.add(2);
        table.add(3);
        table.add(4);
        System.out.println(table.toString());
        table.swap(0, 1);
        System.out.println(table.toString());
    }
}

@SuppressWarnings("ALL")
class SingleLinked<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    SingleLinked() {
    }

    void add(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(e, null);
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        last = newNode;
        size++;
    }

    @SuppressWarnings("SameParameterValue")
    void swap(int x, int y) {
        checkInput(x, y);
        Node<E> prevPrev;
        Node<E> prev;
        Node<E> next;
        if (x != 0 && y != 0) {
            prevPrev = node(x < y ? x - 1 : y - 1);
            prev = prevPrev.next;
            next = prev.next;
        } else {
            prevPrev = prev = first;
            next = prev.next;
        }
        prev.next = next.next;
        if (next.next == null) {
            last = prev;
        }
        next.next = prev;
        if (prevPrev == prev) {
            first = next;
        } else {
            prevPrev.next = next;
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

    private Node<E> node(int index) {
        Node<E> r = first;
        for (int i = 0; i < index; i++)
            r = r.next;
        return r;
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
        Node<E> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}