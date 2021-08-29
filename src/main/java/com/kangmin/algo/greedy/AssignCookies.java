package main.java.com.kangmin.algo.greedy;

import java.util.Arrays;

public class AssignCookies {

    // greedy in form of two-pointer
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
