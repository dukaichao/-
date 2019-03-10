package dkc_ds_0310;

import java.util.Arrays;

/**
 * 基于数组的线性表
 * @author dell
 *
 */
public class SequenceArrayImpl implements Sequence{
	//存放元素的对象数组
	private Object[] elementData;
	//默认容量
	private final static int DEFAULT_CAPACITY = 10;
	//存放元素个数
	private int size;
	//线性表的最大容量
	private final static int MAX_CAPACITY = Integer.MAX_VALUE - 8;
	public SequenceArrayImpl() {
		//初始化存储元素数组，初始化为0
		this.elementData = new Object[DEFAULT_CAPACITY];
	}
	

	public SequenceArrayImpl(int capacity) {
		if(capacity>0&&capacity<MAX_CAPACITY)
			this.elementData = new Object[capacity];
	}


	@Override
	public void add(Object data) {
		// 首先判断添加元素是否会越界
		//若越界先扩容，然后存储元素
		ensureCapacityInternal(size+1);
		elementData[size++] = data;
		
	}

	@Override
	public boolean remove(int index) {
		rangeCheck(index);
		int moveSteps = size - index - 1;
		if(moveSteps>0) {
			System.arraycopy(elementData, index+1, elementData, index, moveSteps);
			
		}
		elementData[--size] = null;
		return true;
	}

	@Override
	public Object get(int index) {
		rangeCheck(index);
		return elementData[index];
	}

	@Override
	public boolean contains(Object data) {
		//判断是否有指定内容
		if(data == null) {
			for(Object i : elementData) {
				if(i == null) {
					return true;
				}
			}
		}else {
			for(Object i : elementData) {
				//特定的元素写前面避免空指针异常
				if(data.equals(i)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Object set(int index, Object newData) {
		rangeCheck(index);
		elementData[index] = newData;
		return elementData[index];
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(int i = 0;i<size;i++) {
			elementData[i] = null;
		}
		this.size = 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return this.elementData;
	}
	
	private void ensureCapacityInternal(int cap) {
		if(cap - elementData.length>0) {
			//扩容
			grow(cap);
		}
	}
	
	private void grow(int cap) {
		int oldCap = elementData.length;
		int newCap = oldCap<<1;
		if(cap - newCap > 0) {
			newCap = cap;
		}
		if(newCap - MAX_CAPACITY > 0) {
			throw new IndexOutOfBoundsException("线性表超出最大值");
		}
		//数组扩容
		elementData = Arrays.copyOf(elementData, newCap);
	}
	
	public void rangeCheck(int index) {
		if(index<0||index>=this.size) {
			throw new ArrayIndexOutOfBoundsException("索引非法");
		}
	}
}
