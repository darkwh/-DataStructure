package demo.p3.stack;

/**
 * 栈的数组实现方式
 */
class StackDemo1 {

    public static void main(String[] args) {
        Stack1 stack = new Stack1(5);
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

class Stack1 {

    private Object[] mData = null;
    private int size;
    private int top;

    Stack1() {
        this(10);
    }

    Stack1(int initialSize) {
        mData = new Object[initialSize];
        size = initialSize;
        top = -1;
    }

    /**
     * 进栈
     *
     * @param value 要插入的元素
     * @return 是否成功插入
     */
    public boolean push(Object value) {
        if (top == size - 1) {
            System.out.println("插入失败!!栈已满!!");
            return false;
        } else {
            mData[++top] = value;
            return true;
        }
    }

    /**
     * 弹栈
     *
     * @return 栈顶元素
     */
    public Object pop() {
        if (top == -1) {
            System.out.println("弹出失败!!栈为空!!");
            return null;
        } else {
            return mData[top--];
        }
    }

    /**
     * 查看栈顶元素
     *
     * @return 栈顶元素
     */
    public Object top() {
        if (top == -1) {
            System.out.println("当前栈为空!!");
            return null;
        } else {
            return mData[top];
        }
    }
}
