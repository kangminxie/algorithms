package com.kangmin.algo.dp;

public class CountingBits {

    public int[] countBits(int num) {
        // non negative integer number num
        if (num == 0) {
            return new int[] {0};
        }
        if (num == 1) {
            return new int[] {0, 1};
        }

        int[] rtArray = new int[num + 1];
        rtArray[0] = 0;
        rtArray[1] = 1;
        for (int i = 2; i <= num; i++) {
            if ((i & 1) == 1) {
                rtArray[i] = rtArray[i >> 1] + 1;
            } else {
                rtArray[i] = rtArray[i >> 1];
            }
        }
        return rtArray;
    }
}
