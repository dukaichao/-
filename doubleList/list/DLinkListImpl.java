package doubleList.list;

import doubleList.Impl.DSequence;

public class DLinkListImpl implements DSequence {

    private ListNode head;
    private ListNode last;
    class ListNode{
        private int data;
        private ListNode prev;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
        }
    }

    public DLinkListImpl(){
        head = null;
        last = null;
    }
    @Override
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(head == null){
            head = node;
            last = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    @Override
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(head == null){
            head = node;
            last = node;
        }else{
            last.next = node;
            node.prev = last;
            last = node;
        }
    }

    @Override
    public boolean addindex(int index, int data) {
        islegal(index);
        if(index == 0){
            addFirst(data);
            return true;
        }else if(index == getLength()){
            addLast(data);
            return true;
        }
        ListNode cur = head;
        int count = 0;
        while(count<index){
            cur = cur.next;
            count++;
        }
        ListNode node = new ListNode(data);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;



        return true;
    }

    @Override
    public boolean contains(int key) {
        ListNode cur = head;
        while(cur!=null) {
            if (cur.data == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int remove(int key) {
        ListNode cur = head;
        while(cur!=null) {
            if(cur.data == key && cur == head){
                int old = head.data;
                head = head.next;
                head.prev = null;
                return old;
            }else if( cur.data == key && cur == last){
                last = last.prev;
                last.next = null;
            }else if (cur.data == key) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                return key;
            }
            cur = cur.next;
        }
        return -1;
    }

    @Override
    public void removeAllKey(int key) {
        while(true){
            if(head.data == key){
                head = head.next;
            }else{
                break;
            }
        }
        ListNode cur = head.next;
        while(cur!=null){
            if(cur.data == key){
                ListNode sign = cur.next;
                cur.prev.next = sign;
                sign.prev = cur.prev;
                cur = sign;
            }else{
                cur = cur.next;
            }

        }
    }

    @Override
    public int getLength() {
        int count = 0;
        ListNode cur = head;
        while(cur!=null){
            cur = cur.next;
            count++;
        }
        return count;
    }

    @Override
    public void display() {
        ListNode cur = head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while(head!=null){
            ListNode cur = head.next;
            head.next = null;
            head.prev = null;
            head = cur;
        }
        last = null;
    }
    //检验下标是否合理
    private void islegal(int index){
        if(index<0 || index > getLength()){
            throw new IndexOutOfBoundsException("不合法");
        }
    }
}
