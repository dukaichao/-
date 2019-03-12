package dkc_ds_0312;
/**
 * 
 * @author dell
 *LinkedListImpl:相当于火车，具体来连接每个点，客户端使用此类
 *Node类，相当于火车结点，负责存放数据
 */
public class LinkedList{
	//头结点
	private Node head;
	//长度
	private int size;
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	private class Node{
		Object data;
		Node next;
		public Node(Object data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
		public Node(Object data) {
			this.data = data;
		}
		
	}
	
	//将结点头插入火车
	public void addFirst(Object data) {
		//创建新的结点
		Node node = new Node(data);
		//将当前结点指向原来火车头结点
		node.next = head;
		head = node;
		size++;
	}
	//在任意位置插入结点
	public void add(int index,Object data) {
		//判断index是否合法
		if(index<0||index>size) {
			throw new IndexOutOfBoundsException("Index Illegal");
		}
		if(index == 0) {
			addFirst(data);
		}
		//先前驱点
		Node prev = head;
		for(int i = 0;i<index-1;i++) {
			prev = prev.next;
		}
		Node newNode = new Node(data);
		newNode.next = prev.next;
		prev.next = newNode;
		size++;
	}

}
