package com.kangmin.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArraysSortAPI {

    public static void main(final String[] args) {
        int[] a = {4, 8, 2, 7, 3, 1};
        System.out.print("before Arrays.sort(a):");
        showArray(a);
        Arrays.sort(a);
        System.out.print("after Arrays.sort(a):");
        showArray(a);

        int[] b = {4, 8, 2, 7, 3, 1};
        System.out.print("\nbefore Arrays.sort(b):");
        showArray(b);
        Arrays.sort(b, 1, 5);
        System.out.print("after Arrays.sort(b) from index 1 to 5:");
        showArray(b);

        int[] c = {8};
        System.out.print("\nbefore Arrays.sort(c):");
        showArray(c);

        int[] d = {8, 9, 2, 3};
        System.out.println(Arrays.toString(d));

        int[] zz = Arrays.copyOf(d, d.length);
        System.out.println(Arrays.toString(zz));

        int[] yyy = zz.clone();
        zz[0] = 8888;
        System.out.println(Arrays.toString(yyy));

        System.out.println("new zz");
        System.out.println(Arrays.toString(zz));

        int[] e = {1, 2, 3, 4, 5};
        int[] f = new int[5];
        System.arraycopy(e, 0, f, 0, 3);
        System.out.println(Arrays.toString(f));


        System.out.println("//////////////////////");
        List<Integer> numbs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbs.add(i);
        }
        System.out.println(numbs);
    }


    private static void showArray(int[] a) {
        if (a == null) {
            System.out.println("null");
            return;
        }

        if (a.length == 0) {
            System.out.println("[]");
            return;
        }

        System.out.print("[");
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[a.length - 1] + "]");
    }
}
