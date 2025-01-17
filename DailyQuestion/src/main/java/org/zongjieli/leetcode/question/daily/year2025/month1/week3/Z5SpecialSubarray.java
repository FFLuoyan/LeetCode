package org.zongjieli.leetcode.question.daily.year2025.month1.week3;

/**
 * 给定一个非负整数数组 nums 和一个整数 k
 * 如果一个数组中所有元素的按位或运算 OR 的值至少为 k,那么称这个数组是特别的
 * 请返回 nums 中最短特别非空子数组的长度,如果特别子数组不存在那么返回 -1
 *
 * 1 <= nums.length <= 2 * 10^5
 * 0 <= nums[i] <= 10^9
 * 0 <= k <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/1/17
 */
public class Z5SpecialSubarray {

    public int minimumSubarrayLength(int[] nums, int k) {
        int[] need = new int[32];
        int[] compare = new int[32];
        bitAdd(need, k, 1);
        int startIndex = 0, min = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            bitAdd(compare, nums[i], 1);
            if (valid(need, compare)) {
                min = Math.min(min, i - startIndex + 1);
                while (startIndex <= i) {
                    bitAdd(compare, nums[startIndex], -1);
                    startIndex++;
                    if (!valid(need, compare)) {
                        break;
                    }
                    min = Math.min(min, i - startIndex + 1);
                }
            }
        }
        if (min == nums.length + 1) {
            return -1;
        }
        return Math.max(min, 1);
    }

    public void bitAdd(int[] bitValues, int value, int add) {
        int index = 0;
        while (value > 0) {
            if ((value & 1) == 1) {
                bitValues[index] += add;
            }
            index++;
            value >>= 1;
        }
    }

    public boolean valid(int[] need, int[] compare) {
        for (int i = compare.length - 1; i >= 0; i--) {
            if (need[i] == 0) {
                if (compare[i] > 0) {
                    return true;
                }
            } else if (compare[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Z5SpecialSubarray test = new Z5SpecialSubarray();
        // 1
        System.out.println(test.minimumSubarrayLength(new int[]{1, 2}, 0));
        // -1
        System.out.println(test.minimumSubarrayLength(new int[]{1, 64, 32, 97, 15, 2}, 122));
    }
}
