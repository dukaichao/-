package dkc_ds_0331;
/*
 	给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，
则在该链表中没有环。
说明：不允许修改给定的链表。
 */
public class DetectCycle {
	/*
	 	有环情况下，假设快慢指针相等的位置a到头结点距离为n，快指针走的路程是慢指针走的路程二倍，
	 	快指针从第一次走到a到相遇时走到a的距离即为m，则快指针走的路程可以表示为 n + m ，可知n+m = 2*n，则m = n；
	 	所以让快指针指向头，比较快慢指针是否相等，当他们相等的时候就是环的入口
	 */
	public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode f = head;
        ListNode s = head;
        //判断是否有环
        while(f != null && f.next!=null){
            f = f.next.next;
            s = s.next;
            if(f == s){
                break;
            }
            
        }
        //没有环，直接返回
        if(f!=s) return null;
        //让快指针指向头结点，
        f = head;
        //下次快慢结点相等时就是环入口
        while(f!=s){
            f = f.next;
            s = s.next;
        }
        return f;
    }
}
