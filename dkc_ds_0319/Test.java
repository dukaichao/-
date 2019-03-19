package dkc_ds_0319;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Sequence sequence = new DoubleLinkedListImpl();
		sequence.add(1);
		sequence.add(2);
		sequence.add(3);
		sequence.add(4);
		sequence.add(5);
		((DoubleLinkedListImpl) sequence).add(5, 777);
		Object[] object =  sequence.toArray();
		System.out.println(Arrays.toString(object));
		
		System.out.println("===========");
		sequence.set(2, 666);
		object =  sequence.toArray();
		System.out.println(Arrays.toString(object));
		
		System.out.println("===========");
		sequence.remove(3);
		object =  sequence.toArray();
		System.out.println(Arrays.toString(object));
		
		System.out.println("size = "+sequence.size());
//		System.out.println(sequence.get(1));
		System.out.println(sequence.get(3));
	}
}
