package main.java.com.kangmin.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArraysSortAPI {

    public static void main(final String[] args) {
        int[] a = {4, 8, 2, 7, 3, 1};
        System.out.print("before Arrays.sort(a):");
        showArray(a);  // [4, 8, 2, 7, 3, 1]
        Arrays.sort(a);
        System.out.print("after Arrays.sort(a):");
        showArray(a);  // [1, 2, 3, 4, 7, 8]

        int[] b = {4, 8, 2, 7, 3, 1};
        System.out.print("\nbefore Arrays.sort(b):");
        showArray(b);  // [4, 8, 2, 7, 3, 1]
        Arrays.sort(b, 1, 4);
        System.out.print("after Arrays.sort(b) from index 1 to 4-1: ");
        showArray(b); // [4, 2, 7, 8, 3, 1]

        int[] c = {8, 5, 2, 1};
        System.out.print("\nbefore Arrays.sort(c): ");
        showArray(c);  // [8, 5, 2, 1]
        Arrays.sort(c, 1, 3);
        System.out.print("after Arrays.sort(c) from index 1 to 3-1: ");
        showArray(c);  // [8, 2, 5, 1]

        int[] d = {8, 9, 2, 3};
        System.out.print("\nint[] d is: ");
        System.out.println(Arrays.toString(d));  // [8, 9, 2, 3]

        int[] zz = Arrays.copyOf(d, d.length);
        System.out.print("\nint[] zz (copy all from d) is: ");
        System.out.println(Arrays.toString(zz));  // [8, 9, 2, 3]

        int[] yyy = zz.clone();
        System.out.print("\nint[] yyy (clone from zz) is: ");
        zz[0] = 8888;
        System.out.println(Arrays.toString(yyy));  // [8, 9, 2, 3]

        System.out.println("\nnew zz is");
        System.out.println(Arrays.toString(zz));  // [8888, 9, 2, 3]
        System.out.println("\nnew yyy is");
        System.out.println(Arrays.toString(yyy));  // [8, 9, 2, 3]

        int[] e = {1, 2, 3, 4, 5};
        int[] f = new int[5];
        System.arraycopy(e, 1, f, 0, 3);
        System.out.println("\nint[] f (copy from e from i1=i+1, i2=i+3, i=1) is: ");
        System.out.println(Arrays.toString(f));  // [2, 3, 4, 0, 0]

        System.out.println("----------------------");
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
