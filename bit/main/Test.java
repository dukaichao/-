package bit.Main;

import bit.Impl.IMyStack;
import bit.stack.MyStack;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:
 * User:Mr.Du
 * Date:2019-04-14
 * Time:15:29
 */
public class Test {
    public static void main(String[] args) {
        IMyStack imyStack = new MyStack();
        imyStack.push(1);
        imyStack.push(2);
        System.out.println(imyStack.peek());
        System.out.println(imyStack.size());
        System.out.println(imyStack.pop());
        System.out.println(imyStack.size());
    }
}
