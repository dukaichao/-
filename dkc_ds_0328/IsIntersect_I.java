package dkc_ds_0328;
/*
 	判断环路链表是否相交
 	思路：如果有环且两个链表相交，则两个链表都有共同一个环，即环上任意一个结点都存在于两个链表上，
 	因此，就可以判断一个链表上两指针相遇的那个结点是否也在另一个链表上
 */
public class IsIntersect_I {
	public static boolean isIntersect_I(ListNode l1,ListNode l2) {
		ListNode sign1 = null,sign2 = null;
		//首先判断两个链表是否是环路链表
		if(!isCircle(l1,sign1)) return false;
		if(!isCircle(l2,sign2)) return false;
		ListNode tmp = sign1.next;
		//判断l1环内结点是否在l2环上
		while(tmp != sign1) {
			if(tmp == sign2)
				return true;
			tmp = tmp.next;
		}
		return false;
	}
	//判断是否循环链表,并且标记环内结点
	public static boolean isCircle(ListNode l,ListNode sign) {
		if(l == null) return false;
		ListNode f = l;
		ListNode s = l;
		while(l.next!=null) {
			if(l == s) {
				sign = l;
				return true;
			}
			l = l.next.next;
			s = s.next;
		}
		return false;
	}
}
