package shared;

import java.util.HashMap;
import java.util.Hashtable;

public class Test {
	public static void main(String[] args) {
		Hashtable<Integer, Integer> hashtable = new Hashtable<>();
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			hashtable.put(i, i);
		}
		long t2 = System.currentTimeMillis();

		for (int i = 0; i < 200000; i++) {
			hashMap.put(i, i);
		}
		long t3 = System.currentTimeMillis();

		System.out.println(t2 - t1);
		System.out.println(t3 - t2);
		long t4 = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			hashtable.get(i);
		}

		long t5 = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			hashMap.get(i);
		}
		long t6 = System.currentTimeMillis();

		System.out.println(t5 - t4);
		System.out.println(t6 - t5);
	}
}
