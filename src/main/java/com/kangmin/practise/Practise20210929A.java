package main.java.com.kangmin.practise;

import java.util.Comparator;

public class Practise20210929A {

    public static void main(String[] args) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -1;
            }
        };

        Comparator<Integer> comparator1 = (s1, s2) -> {
            return s1.compareTo(s2);
        };
    }
}
