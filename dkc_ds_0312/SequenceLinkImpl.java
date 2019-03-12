package dkc_ds_0312;
/**
 * 
 * @author dell
   * 链表
 *
 */
public class SequenceLinkImpl implements Sequence{
	private Node head;
	private int size;
	
	public SequenceLinkImpl() {
		this.head = new Node(null,null);
	}
	

	class Node{
		Node next;
		Object data;
		public Node(Node next, Object data) {
			super();
			this.next = next;
			this.data = data;
		}
		public Node(Object data) {
			super();
			this.data = data;
		}
		
	}
	@Override
	public void add(Object data) {
		addLast(data);
	}

	@Override
	public boolean remove(int index) {
		rangeCheck(index);
		Node prev = head;
		for(int i = 0;i<index;i++) {
			prev = prev.next;
		}
		//获取当前index的结点
		Node now = node(index);
		prev.next = now.next;
		now.next = now = null;
		size--;
		return true;
	}

	@Override
	public Object get(int index) {
		rangeCheck(index);
		return node(index).data;
	}

	@Override
	public boolean contains(Object data) {
		Object[] arr = toArray();
		if(data == null) {
			for(int i = 0;i<arr.length;i++) {
				if(arr[i] == null) {
					return true;
				}
			}
		}else {
			for(int i = 0;i<arr.length;i++) {
				if(data.equals(arr[i])) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Object set(int index, Object newData) {
		rangeCheck(index);
		Node node = node(index);
		Object oldData = node.data;
		node.data = newData;
		return oldData;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		for(Node node = head.next;node!=null;) {
			node.data = null;
			Node tmp = node.next;
			node.next = null;
			node = tmp;
			size--;
		}
		
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size];
		int index = 0;
		for(Node node = head.next;node!=null;node = node.next) {
			arr[index++] = node.data;
		}
		return arr;
	}
	//在任意位置添加
	public void add(int index,Object data) {
		rangeCheck(index);
		Node prev = head;
		for(int i = 0;i<index;i++) {
			prev = prev.next;
		}
		Node newNode = new Node(data);
		newNode.next = prev.next;
		prev.next = newNode;
		size++;
	}
	private void addFirst(Object data) {
		add(0,data);
	}
	private void addLast(Object data) {
		add(size,data);
	}
	//判断index是否合法
	private void rangeCheck(int index) {
		if(index<0||index>size) {
			throw new IndexOutOfBoundsException("Illegal Index!");
		}
	}
	//找到index的当前结点
	private Node node(int index) {
		Node prev = head.next;
		for(int i = 0;i<index;i++) {
			prev = prev.next;
		}
		return prev;
	}
}
