package main.java.com.kangmin.algo.special;

import java.util.Arrays;

public class StrStrKMP2 {

    private static int[] getNext(String needle) {
        char[] s = needle.toCharArray();
        int[] next = new int[s.length];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < s.length; i++) {
            while (j > 0 && s[i] != s[j]) {
                j = next[j - 1];
            }
            if (s[i] == s[j]) {
                j++;
            }
            next[i] = j;
        }
        System.out.println(Arrays.toString(next));
        return next;
    }

    // assume not null
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = getNext(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (j == needle.length()) {
                    return (i - needle.length() + 1);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String haystack = "aabaabaafa";
        String needle = "aabaaf";
        System.out.println(strStr(haystack, needle));
    }
}
