package doubleList.Test;

import doubleList.list.DLinkListImpl;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        DLinkListImpl dl = new DLinkListImpl();
        dl.addFirst(1);
        dl.addFirst(2);
        dl.addFirst(1);
        dl.addFirst(2);
        dl.addindex(2,5);
        dl.display();
        dl.removeAllKey(5);
        dl.display();

        dl.clear();
        dl.display();
        Thread.sleep(1000);
        System.out.println("睡醒了");


    }
}
