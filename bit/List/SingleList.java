package dkc.bit.List;

import dkc.bit.impl.ISequence;

public class SingleList implements ISequence {
    private ListNode head;
    public SingleList(){
        /*head = new ListNode();
        head = null;*/
    }
    class ListNode{
        private int data;
        private ListNode next;
        public ListNode(){

        }
        public ListNode(int data){
            this.data = data;
        }
        public ListNode(int data,ListNode next){
            this.data = data;
            this.next = next;
        }
    }


    @Override
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(head!=null){
            node.next = this.head;
        }
        this.head = node;
    }

    @Override
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(head == null){
            this.head = node;
            node.next = null;
        }else{
            ListNode cur = this.head;
            while(cur.next!= null){
                cur = cur.next;
            }
            cur.next = node;
            node.next = null;
        }
    }

    @Override
    public boolean addindex(int index, int data) {
        checkIndex(index);
        if(index == 0){
            addFirst(data);
        }else if(index == this.getLength()){
            addLast(data);
        }else{
            ListNode cur = new ListNode(data);
            ListNode node = getListNode(index);
            cur.next = node.next;
            node.next = cur;
        }
        return true;
    }

    @Override
    public boolean contains(int key) {
        ListNode cur = this.head;
        while(cur!=null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int remove(int key) {
        if(head.data == key){
            ListNode sign = head;
            head = head.next;
            return sign.data;
        }
        ListNode node = this.getPreNode(key);
        if(node == null) return -1;
        else{
            ListNode sign = node.next;
            node.next = sign.next;
            return sign.data;
        }
    }

    @Override
    public void removeAllKey(int key) {
        while(true) {
            if (head.data == key) {
                head = head.next;
            }else{
                break;
            }
        }
        ListNode cur = head;
        while(cur != null){
            if(cur.data == key){
                ListNode pre = getPreNode(cur.data);
                pre.next = cur.next;
            }
            cur = cur.next;
        }
    }

    @Override
    public int getLength() {
        ListNode cur = this.head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        ListNode cur = head;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }

    }

    @Override
    public void clear() {
        while(head!=null){
            ListNode sign = head;
            head = null;
            head= sign.next;
        }
    }

    //获取当前索引前一个的结点
    private ListNode getListNode(int index){
        checkIndex(index);
        ListNode cur = this.head;
        for(int i = 0;i<index - 1;i++){
            cur = cur.next;
        }
        return cur;
    }
    //索引检验
    private void checkIndex(int index){
        if(index<0||index>this.getLength()) {
            throw new IndexOutOfBoundsException("下标不合法");
        }
    }
    //返回当前结点的前一个结点
    private ListNode getPreNode(int key){
        ListNode cur = head;
        while(cur.next!=null){
            if(cur.next.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

}
