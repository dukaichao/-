package dkc.Main;

import dkc.list.CHeadList;

public class Test {
    public static void main(String[] args) {
        CHeadList c = new CHeadList();
        c.addFirst(1);
        c.addindex(1,5);
        c.addFirst(5);
        c.addFirst(1);
        c.addLast(5);
        c.removeAllKey(5);
        System.out.println(c.contains(1));
        c.display();
        c.clear();
        //System.out.println(c.getLength());
    }
}
