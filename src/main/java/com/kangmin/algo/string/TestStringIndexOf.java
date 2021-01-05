package com.kangmin.algo.string;

import java.util.Arrays;

public class TestStringIndexOf {

    public static void main(String[] args) {
        String s1 = "abc(def)ghi";
        int[] arr1 = findMinZone(s1, '(',')');
        System.out.println(Arrays.toString(arr1));

        String s2 = "<def><d<def>f>";
        int[] arr2 = findMinZone(s2, '<','>');
        System.out.println(Arrays.toString(arr2));
    }

    private static int[] findMinZone(String s, char c1, char c2) {
        int start = -1;
        int end = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c1) {
                start = i;
            }
            if (s.charAt(i) == c2) {
                end = i;
                break;
            }
        }
        return new int[] {start, end};
    }
}
