package practice.p3_6;


public class Demo {

    public static void main(String[] args) {
        /**
         * 使用循环单链表结构体,运行时间O(N),并非最优解,当N很大时耗费时间很长,需要结合数学知识需求最优解法
         */
        int m = 20000;
        int n = 100000;
        Josephus<Integer> josephus = new Josephus<>();
        for (int i = 1; i <= n; i++) {
            josephus.add(i);
        }
        josephus.play(m, n);

    }
}

class Josephus<E> {

    Node<E> first;
    Node<E> last;

    void add(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(e, first);
        if (l == null) {
            first = newNode;
            last = newNode;
        } else {
            l.next = newNode;
            last = newNode;
        }
    }

    E remove(int index) {
        if (index == 0) {
            Node<E> n = node(index);
            first = n.next;
            last.next = first;
            return n.element;
        } else {
            Node<E> n = node(index - 1);
            Node<E> r = n.next;
            n.next = n.next.next;
            if (n.next.next == last) last = n.next;
            return r.element;
        }
    }

    private Node<E> node(int index) {
        Node<E> f = first;
        for (int i = 0; i < index; i++)
            f = f.next;
        return f;
    }

    void play(int m, int n) {
        for (int i = m % n; n > 1; n--) {
            System.out.println(remove(i));
            i = (i + m % (n - 1)) % (n - 1);
        }
        System.out.println("winner is :" + first.element);
    }

    class Node<E> {

        E element;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

    }
}
