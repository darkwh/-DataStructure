package demo.p3.stack;


/**
 * 栈的链表实现
 */
public class StackDemo2 {

    public static void main(String[] args) {
        Stack2<Integer> stack = new Stack2<>(5);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        for (int i = 0; i < 6; i++) {
            stack.push(i);
        }
        System.out.println(stack.top());
        for (int i = 0; i < 6; i++) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.top());
    }

}

class Stack2<T> {

    private Node<T> topNode = null;
    private int size;
    private int top;

    public Stack2() {
        this(10);
    }

    public Stack2(int size) {
        this.size = size;
        top = 0;
    }

    boolean push(T value) {
        if (top == size) {
            System.out.println("进栈失败!栈已满");
            return false;
        } else {
            Node<T> tempNode = new Node<>(value);
            tempNode.prev = topNode;
            topNode = tempNode;
            top++;
            return true;
        }
    }

    T pop() {
        if (topNode == null) {
            System.out.println("弹栈失败!栈为空");
            return null;
        } else {
            Node<T> tempNode = topNode;
            topNode = topNode.prev;
            top--;
            return tempNode.element;
        }
    }

    T top() {
        if (topNode == null) {
            System.out.println("当前栈为空!");
            return null;
        } else {
            return topNode.element;
        }
    }

    class Node<T> {

        T element;
        Node<T> prev;

        Node(T element) {
            this.element = element;
        }
    }
}

