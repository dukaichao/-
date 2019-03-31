package dkc.bit.main;

import dkc.bit.List.SingleList;

public class Main {
    public static void main(String[] args) {

        SingleList singleList = new SingleList();
        singleList.addLast(1);
        singleList.addLast(2);
        singleList.addLast(6);
        singleList.addLast(3);
        singleList.addLast(4);
        singleList.addLast(6);
        singleList.addLast(5);
        singleList.addLast(6);
        singleList.display();
        System.out.println();
        System.out.println(singleList.getLength());
        singleList.remove(6);
        singleList.display();
        System.out.println();
        System.out.println(singleList.getLength());
        singleList.clear();
        System.out.println(singleList.getLength());
    }
}
