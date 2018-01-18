package demo.p3.queue;

/**
 * 队列的链表实现
 */
public class QueueDemo2 {

    public static void main(String[] args) {
        Queue2<Integer> queue = new Queue2<>(5);
        for (int i = 0; i < 6; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(queue.dequeue());
        }
    }
}

class Queue2<T> {

    private Node<T> frontNode;
    private Node<T> backNode;
    private int maxSize;
    private int currentSize;

    Queue2() {
        this(10);
    }

    Queue2(int initialSize) {
        maxSize = initialSize;
        currentSize = 0;
    }

    boolean enqueue(T value) {
        if (currentSize == maxSize) {
            System.out.println("入列失败!队列已满");
            return false;
        } else {
            Node<T> temp = new Node<>(value);
            if (frontNode == null) {
                frontNode = temp;
            }
            if (backNode == null) {
                backNode = temp;
            } else {
                backNode.next = temp;
                backNode = temp;
            }
            currentSize++;
            return true;
        }

    }

    T dequeue() {
        if (currentSize == 0) {
            System.out.println("出列失败!队列为空");
            return null;
        } else {
            if (frontNode == backNode) {
                backNode = null;
            }
            Node<T> temp = frontNode;
            frontNode = frontNode.next;
            currentSize--;
            return temp.element;
        }
    }

    class Node<T> {

        T element;
        Node<T> next;

        Node(T element) {
            this.element = element;
        }
    }
}
