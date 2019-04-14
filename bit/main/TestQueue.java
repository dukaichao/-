package bit.Main;

import bit.Impl.IMyQueue;
import bit.stack.MyQueue;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-04-14
 * Time:16:04
 */
public class TestQueue {
    public static void main(String[] args) {
        System.out.println(Math.floor(4.9));
        IMyQueue imyQueue = new MyQueue();
        for(int i = 0;i<10;i++){
            imyQueue.add(i);
        }
        for(int i = 0;i<9;i++) {
            System.out.print(imyQueue.poll()+" ");
        }
        System.out.println();
        System.out.println(imyQueue.size());
        System.out.println(imyQueue.peek());
        System.out.println(imyQueue.size());

    }
}
