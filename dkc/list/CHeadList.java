package dkc.list;

import dkc.Impl.CSequenceImpl;

public class CHeadList implements CSequenceImpl {
    private ListNode head;
    class ListNode{
        private ListNode next;
        int data;
        public ListNode(){
            this.data = -1;
        }
        public ListNode(int data){
            this.data = data;
        }
    }

    public CHeadList(){
        head = new ListNode();
        head.next = head;
    }

    @Override
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(head.next == null){
            head.next = node;
            node.next = head;
        }else {
            node.next = head.next;
            head.next = node;
        }
    }

    @Override
    public void addLast(int data) {
        ListNode cur = head;
        while(cur.next!=head){
            cur = cur.next;
        }
        ListNode node = new ListNode(data);
        node.next = head;
        cur.next = node;
    }

    @Override
    public boolean addindex(int index, int data) {
        islegal(index);
        ListNode cur = head;
        for(int i = 0;i<index;i++){
            cur = cur.next;
        }
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        ListNode cur = head.next;
        while(cur!= head){
            if(cur.data == key){
                return true;
            }
        }
        return false;
    }

    @Override
    public int remove(int key) {
        if(getNode(key) == null) return -1;
        ListNode pre = getNode(key);
        ListNode node = new ListNode(key);
        node.next = pre.next;
        pre.next = node;
        return 1;
    }

    @Override
    public void removeAllKey(int key) {
        ListNode pre = head;
        while(pre.next!=head){
            if(pre.next.data == key){
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }
    }

    @Override
    public int getLength() {
        ListNode cur = head.next;
        int count = 0;
        while(cur != head){
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        ListNode cur = head.next;
        while(cur != head){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
    }

    @Override
    public void clear() {
        while(head.next!=head){
            ListNode sign = head.next.next;
            head.next = null;
            head.next = sign;
        }
        head = null;
    }

    //检验下标是否合理
    private void islegal(int index){
        if(index<0 || index > getLength()){
            throw new IndexOutOfBoundsException("不合法");
        }
    }

    //获取前驱结点
    private ListNode getNode(int key){
        ListNode pre = head;
        while(pre.next != head){
            if(pre.next.data == key){
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }

}
