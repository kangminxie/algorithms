package com.kangmin.algo.bit;

public class MissingNumber {

    // n distinct numbers taken from 0, 1, 2, ..., n,
    // one number is missing
    // a ^ b ^ b = a
    public int missingNumber(int[] nums) {
        int result = 0;
        // i from i to n - 1, remain is i = N
        // rest of them, nums[each] will be double -> cancelled.
        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }
        result = result ^ nums.length;
        // remain is the i who missing nums[i], or nums[i] itself
        return result;
    }

    public int missingNumberMath(int[] nums) {
        if (nums == null)
            return 0;
        int len = nums.length;
        int sum = (len) * (len + 1) / 2;
        for (int num : nums) {
            sum = sum - num;
        }
        return sum;
    }
}
