package org.zongjieli.leetcode.algorithm.primary.array;

import java.util.Arrays;

/**
 * @ClassName: MoveZeros
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2019/12/26
 * @Version: 1.0
 **/
public class MoveZeros {
    public static void moveZeros(int[] nums) {
        if (nums != null && nums.length < 2) {
            return;
        }
        int moveIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[moveIndex++] = nums[i];
            }
        }
        for (int i = moveIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 5, 8, 4, 0, 3, 6, 45, 45, 0, 0};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }
}
