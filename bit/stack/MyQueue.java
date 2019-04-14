package bit.stack;

import bit.Impl.IMyQueue;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-04-14
 * Time:15:50
 */
public class MyQueue implements IMyQueue {
    private ListNode front;
    private ListNode rear;
    private int useSized;
    class ListNode{
        private ListNode next;
        private int val;
        public ListNode(int val){
            this.val = val;
        }
    }
    public MyQueue(){
        front = null;
        rear = null;
        this.useSized = 0;
    }
    // 判断这个队列是否为空
    @Override
    public boolean empty() {
        return this.useSized == 0;
    }

    // 返回队首元素，但不出队列
    @Override
    public int peek() {
        if(empty()){
            throw new UnsupportedOperationException("空的");
        }
        return front.val;
    }

    // 返回队首元素，并且出队列
    @Override
    public int poll() {
        if(empty()){
            throw new UnsupportedOperationException("空的");
        }
        int t = front.val;
        front = front.next;
        this.useSized--;
        return t;
    }

    // 将 item 放入队列中
    @Override
    public void add(int item) {
        ListNode node = new ListNode(item);
        if(this.empty()){
            front = node;
            rear = node;
            //rear.next = null;
        }else{
            rear.next = node;
            rear = node;
            //rear.next = null;
        }
        this.useSized++;
    }

    // 返回元素个数
    @Override
    public int size() {
        return this.useSized;
    }
}
