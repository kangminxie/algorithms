package main.java.com.kangmin.algo.twopointer;

import java.util.Arrays;

public class AssignCookies {

    // can also be regarded as greedy from least
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ig = 0;
        int is = 0;
        while (ig < g.length && is < s.length) {
            if (g[ig] <= s[is]) {
                ig++;
                is++;
            } else {
                is++;
            }
        }
        return ig;
    }

}
