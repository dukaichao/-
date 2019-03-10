package dkc_ds_0310;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Sequence sequence = 
				new SequenceArrayImpl(2);
		sequence.add(1);
		sequence.add(2);
		sequence.add(3);
		sequence.add(4);
		sequence.add(5);
		sequence.add(6);
		sequence.remove(4);
		System.out.println(sequence.size());
		System.out.println(sequence.contains(5));
		System.out.println(Arrays.toString(sequence.toArray()));
		/*System.out.println(sequence.get(2));
		System.out.println(sequence.set(1, 4));
		System.out.println(sequence.get(1));
		System.out.println(sequence.contains(2));
		System.out.println(sequence.contains(4));
		System.out.println(sequence.get(2));
		System.out.println(sequence.size());*/
	}
}
