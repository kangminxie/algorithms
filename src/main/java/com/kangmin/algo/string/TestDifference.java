package com.kangmin.algo.string;

public class TestDifference {

	private static final char BAD_CHAR = '0';

    public static char findTheDifference(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return BAD_CHAR;
        }

        int i = 0;
        int size = Math.min(s1.length(), s2.length());
        while (i < size && s1.charAt(i) == s2.charAt(i)) {
        	i++;
        }

        // reach the end of one string
        if (i == size) {
        	if (size == s1.length()) {
        		return s2.charAt(i);
        	}
        	if (size == s2.length()) {
        		return s1.charAt(i);
        	}
        }

        if (s1.charAt(i) == s2.charAt(i + 1)) {
        	return s2.charAt(i);
        }
        if (s2.charAt(i) == s1.charAt(i + 1)) {
        	return s1.charAt(i);
        }

        return BAD_CHAR;
    }

	public static void main(String[] args) {
		String s1 = "Hello World";
		String s2 = "Hello hWorld";
		System.out.println(findTheDifference(s1, s2));

		System.out.println("***************************");
		String t1 = "aa";
		String t2 = "aaa";
		System.out.println(findTheDifference(t1, t2));

		System.out.println("***************************");
		String w1 = "aaabaaa";
		String w2 = "aaaaaa";
		System.out.println(findTheDifference(w1, w2));
	}

}
