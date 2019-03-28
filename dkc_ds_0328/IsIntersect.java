package dkc_ds_0328;
/*
 	判断两个单链表是否相交
 */
public class IsIntersect {
	/*
	 	单链表：判断两个链表的结尾是否相等，相等即相交
	 */
	public static boolean isIntersect(ListNode l1,ListNode l2) {
		if(l1 == null || l2 == null) return false;
		while(l1.next!=null) {
			l1 = l1.next;
		}
		while(l2.next != null) {
			l2 = l2.next;
		}
		if(l1 == l2)
			return true;
		return false;
	}
}
