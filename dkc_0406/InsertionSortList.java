package dkc_0406;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode rov = cur.next;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        while(rov!=null){
            if(rov.val >= cur.val){
                rov = rov.next;
                cur = cur.next;
            }else{
                cur.next = rov.next;
                ListNode sign = dummyHead.next;
                ListNode dummy = dummyHead;
                while(sign!=cur.next){
                    if(sign.val<rov.val){
                        sign = sign.next;
                        dummy = dummy.next;
                    }else{
                        rov.next = dummy.next;
                        dummy.next = rov;
                        break;
                    }
                }
                rov = cur.next;
            }
            
        }
        return dummyHead.next;
        
    }
}
