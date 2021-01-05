package com.kangmin.algo.bit;

public class SingleNumber {

    // Input: [4,1,2,1,2]
    // Output: 4

    public int singleNumber(int[] nums) {
        // assume nums is not null and have at least one member
        int rtValue = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            rtValue = rtValue ^ nums[i];
            // A ^ A = 0 and A ^ x ^ A = x
        }
        return rtValue;
    }
}
