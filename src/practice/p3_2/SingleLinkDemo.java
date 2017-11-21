package practice.p3_2;

public class SingleLinkDemo {

    public static void main(String[] args) {
        SingleLink<Integer> table = new SingleLink<>();
        table.add(1);
        table.add(2);
        table.add(3);
        table.add(4);
        System.out.println(table.toString());
        table.swap(2, 1);
        System.out.println(table.toString());
    }
}

class SingleLink<E> {

    private Node<E> first;
    private Node<E> last;
    private Node<E> next;
    private int size;

    public SingleLink() {
    }

    public void add(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(e, null);
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        last = newNode;
        size++;
    }

    public void swap(int x, int y) {
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
        String str = "";
        Node<E> x = first;
        for (int i = 0; i < size; i++) {
            str += x.item.toString();
            x = x.next;
        }
        return str;
    }

    class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}