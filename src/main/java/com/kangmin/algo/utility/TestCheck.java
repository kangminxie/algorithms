package main.java.com.kangmin.algo.utility;

import java.util.ArrayList;
import java.util.List;

public class TestCheck {

    public static void main(String[] args) {
        int N = 5;
        ArrayList<Integer>[] al = new ArrayList[N];

        // initializing
        for (int i = 0; i < N; i++) {
            al[i] = new ArrayList<>();
        }

        al[0].add(1);
        al[0].add(2);
        al[1].add(5);
        al[2].add(10);
        al[2].add(20);
        al[2].add(30);
        al[3].add(56);
        al[4].add(34);
        al[4].add(67);
        al[4].add(89);
        al[4].add(12);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < al[i].size(); j++) {
                System.out.print(al[i].get(j) + " ");
            }
            System.out.println();
        }

        int n = 3;

        // Here aList is an ArrayList of ArrayLists
        List<List<Integer>> aList = new ArrayList<>(n);

        // Create n lists one by one and append to the
        // master list (ArrayList of ArrayList)
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(2);
        aList.add(a1);

        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(5);
        aList.add(a2);

        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(10);
        a3.add(20);
        a3.add(30);
        aList.add(a3);

        for (List<Integer> integers : aList) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
