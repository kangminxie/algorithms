package com.kangmin.algo.twopointer;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int j = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[j++] = num;
            }
        }

        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}
