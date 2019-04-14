package bit.stack;

import bit.Impl.IMyStack;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-04-14
 * Time:15:13
 */
public class MyStack implements IMyStack {
    private static final int DEFAULT_SIZE = 10;
    private int[] elem;
    private int top;
    private int usedSize;
    public MyStack(){
        this.elem = new int[DEFAULT_SIZE];
        this.top = 0;
        this.usedSize = 0;
    }

    private boolean isFull(){
        return this.top == this.elem.length;
    }
    @Override
    public void push(int item) {
        if(isFull()){
            throw new UnsupportedOperationException("满了");
        }
        elem[this.top++] = item;
        usedSize++;

    }

    @Override
    // 返回栈顶元素，并且出栈
    public int pop() {
        if(empty()){
            throw new UnsupportedOperationException("空的");
        }
        usedSize--;
        return this.elem[--top];
    }
    // 返回栈顶元素，但不出栈
    @Override
    public int peek() {
        if(empty()){
            throw new UnsupportedOperationException("空的");
        }
        return this.elem[this.top - 1];
    }
    // 判断这个栈是否为空栈
    @Override
    public boolean empty() {
        return this.size() == 0;
    }
    // 返回元素个数
    @Override
    public int size() {
        return this.usedSize;
    }
}
