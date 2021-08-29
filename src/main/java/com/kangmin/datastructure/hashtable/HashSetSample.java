package main.java.com.kangmin.datastructure.hashtable;

import java.util.HashSet;
import java.util.Set;

public class HashSetSample {

	public static void main(String[] args) {
		Set<Integer> hash = new HashSet<>();

		Integer num = null;
		// System.out.println(num.hashCode());
		System.out.println(hash.contains(null));  // false, not in the hash yet

		boolean first = hash.add(1);
		System.out.println(first);  // true
		boolean second = hash.add(1);
		System.out.println(second);  // false

		hash.add(num);
		System.out.println(hash.contains(null)); // true, already in the hash yet
	}
}
