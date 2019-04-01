package code;
/*
    反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
    说明:
        1 ≤ m ≤ n ≤ 链表长度。
    示例:
        输入: 1->2->3->4->5->NULL, m = 2, n = 4
        输出: 1->4->3->2->5->NULL
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int length = getLength(head);
        int t = n - m;
        if(length<n || m>=n || head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while(m>1){
            cur = cur.next;
            m--;
        }
        ListNode f = cur.next;
        ListNode s = f.next;
        while(s!=null && t>0){
            f.next = s.next;
            s.next = cur.next;
            cur.next = s;
            s = f.next;
            t--;
        }
        return dummyHead.next;
    }
    public static int getLength(ListNode head){
        int count = 0;
        while(head!=null){
            head = head.next;
            count++;
        }
        return count;
    }
}
