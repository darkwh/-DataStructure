package demo.p3.queue;

/**
 * 队列的实现
 */
public class QueueDemo1 {

    public static void main(String[] args) {
        Queue1 queue = new Queue1(5);
        System.out.println(queue.dequeue());
        for (int i = 0; i < 6; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(queue.dequeue());
        }
        for (int i = 0; i < 6; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(queue.dequeue());
        }
    }
}

class Queue1 {

    private Object[] mData = null;
    private int maxSize;
    private int currentSize;
    private int front;
    private int back;

    Queue1() {
        this(10);
    }

    Queue1(int initialSize) {
        mData = new Object[initialSize];
        maxSize = initialSize;
        currentSize = 0;
        front = -1;
        back = -1;
    }

    boolean enqueue(Object value) {
        if (currentSize == maxSize) {
            System.out.println("入列失败!队列已满");
            return false;
        } else {
            if (back == maxSize - 1) {
                back = -1;
            }
            mData[++back] = value;
            currentSize++;
            return true;
        }
    }

    Object dequeue() {
        if (currentSize == 0) {
            System.out.println("出列失败!队列为空");
            return false;
        } else {
            if (front == maxSize - 1) {
                front = -1;
            }
            currentSize--;
            return mData[++front];
        }
    }

    int getCurrentSize() {
        return currentSize;
    }
}
