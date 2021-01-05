package com.kangmin.algo.bit;

public class HammingDistance {
    //The Hamming distance between two integers is the number of positions
    // at which the corresponding bits are different.
    // eg.  x = 1 = 0 0 0 1
    //      y = 4 = 0 1 0 0
    // result = 2

    public int hammingDistance(int x, int y) {
        int z = x ^ y;  // z = 0 1 0 1
        int result = 0;
        while (z != 0) {
            result += z & 1;
            z = z >>> 1;
        }
        return result;
    }
}
