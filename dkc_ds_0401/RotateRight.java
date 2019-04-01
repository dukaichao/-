package dkc_ds_0401;
/*
 	给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

	示例 1:
		输入: 1->2->3->4->5->NULL, k = 2
		输出: 4->5->1->2->3->NULL
		解释:
		向右旋转 1 步: 5->1->2->3->4->NULL
		向右旋转 2 步: 4->5->1->2->3->NULL
	示例 2:
		输入: 0->1->2->NULL, k = 4
		输出: 2->0->1->NULL
		解释:
		向右旋转 1 步: 2->0->1->NULL
		向右旋转 2 步: 1->2->0->NULL
		向右旋转 3 步: 0->1->2->NULL
		向右旋转 4 步: 2->0->1->NULL
 */
public class RotateRight {
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        //统计链表长度
        ListNode c = head;
        int count = 0;
        while(c!=null){
            c = c.next;
            count++;
        }
        //翻转次数
        int t = k%count;
        if(t == 0) return head;
        //逆转链表
        ListNode cur = reverse(head);
        ListNode sign = cur;
        while(t>1){
            sign = sign.next;
            t--;
        }
        ListNode p = sign.next;
        sign.next = null;
        //逆转前k个结点
        ListNode m = reverse(cur);
        //n相当于标记结点
        ListNode n = reverse(cur);
        while(n.next!=null){
            n= n.next;
        }
        //逆转后面结点，并且让n的next指向它
        n.next = reverse(p);
        return m;
    }
    
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
