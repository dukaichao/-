package dkc_ds_0312;



public class Test {
	public static void main(String[] args) {
		System.out.println(-2>>>3);
		Sequence sequence = new SequenceLinkImpl();
		sequence.add(1);
		sequence.add(2);
		sequence.add(3);
		((SequenceLinkImpl) sequence).add(0, 777);
		((SequenceLinkImpl) sequence).set(2, 666);
		sequence.remove(2);
		Object[] object = sequence.toArray();
		for(Object o:object) {
			System.out.print(o+" ");
		}
		System.out.println(sequence.contains(600));
		sequence.clear();
		System.out.println(sequence.size());
	}
}
