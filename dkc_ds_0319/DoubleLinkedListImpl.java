package dkc_ds_0319;

public class DoubleLinkedListImpl implements Sequence{

	//表示头结点
	private ListNode head;
	//表示尾结点
	private ListNode tail;
	private int size;
	private class ListNode {
		private ListNode prev;
		private ListNode next;
		Object data;
		public ListNode(ListNode prev , Object data, ListNode next) {
			this.prev = prev;
			this.next = next;
			this.data = data;
		}
		public ListNode(Object data) {
			this.data = data;
		}
		
	}
	/**
	 * 尾插法
	 */
	public void add(Object date) {
		// TODO Auto-generated method stub
		ListNode node = new ListNode(tail,date,null);
		if(head == null) {
			head = node;
		}else {
			tail.next = node;
		}
		tail = node;
		size++;
		
	}

	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		checkIndex(index);
		//要删除结点
		ListNode now = node(index);
		ListNode prevNode = now.prev;
		ListNode nextNode = now.next;
		//要删除的是头结点
		if(prevNode == null) {
			head = nextNode;
		}else {
			prevNode.next = now.next;
			now.prev = null;
		}
		//要删除的是尾结点
		if(nextNode == null) {
			tail = now.prev;
		}else {
			nextNode.prev = now.prev;
			now.prev = null;
		}
		size--;
		return true;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		checkIndex(index);
		return node(index).data;
	}

	@Override
	public boolean contains(Object data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object set(int index, Object newData) {
		// TODO Auto-generated method stub
		checkIndex(index);
		ListNode node = node(index);
		node.data = newData;
		return newData;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(ListNode tmp = head;tmp!=null;) {
			ListNode next = tmp.next;
			tmp.prev = tmp.next = null;
			tmp.data = null;
			tmp = next;
			size--;
		}
		
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object[] object = new Object[size];
		int i = 0;
		for(ListNode tmp = head;tmp!=null;tmp = tmp.next) {
			object[i++] = tmp.data;
		}
		return object;
	}
	
	//指定位置插入
	public void add(int index,Object data) {
		//checkIndex(index);
		ListNode node = new ListNode(head,data,tail);
		if(node.next == null) {
			add(data);
		}else {
			ListNode prevNode = node(index-1);
			node.next = prevNode.next;
			prevNode.next.prev = node;
			prevNode.next = node;
			node.prev = prevNode;
			size++;
		}
		
	}
	//检查索引index是否合法
	private void checkIndex(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Illeagle Index");
		}
	}
	
	//获取当前索引结点
	private ListNode node(int index) {
		/*if(index < (this.size>>1)) {
			ListNode tmp = head;
			for(int i = 0;i<index;i++) {
				tmp = tmp.next;
			}
			return tmp;
		}else {
			ListNode tmp = tail;
			for(int i = size - 1;i>index;i--) {
				tmp = tmp.prev;
			}
			return tmp;
		}*/
		ListNode tmp = head;
		for(int i = 0;i<index;i++) {
			tmp = tmp.next;
		}
		return tmp;
	}

}
