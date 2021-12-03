package org.zongjieli.leetcode.question.daily.year2021.month12.week1;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个整数 k,按以下方法修改该数组:
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i]
 * 重复这个过程恰好 k 次,可以多次选择同一个下标 i
 * 以这种方式修改数组后,返回数组可能的最大和
 *
 * 1 <= nums.length <= 10^4
 * -100 <= nums[i] <= 100
 * 1 <= k <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2021/12/3
 */
public class Z5ReverseMax {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int index = 0;
        for (; index < nums.length && k > 0; index++){
            if (nums[index] >= 0){
                break;
            }
            k--;
            nums[index] = -nums[index];
        }
        if ((k & 1) != 0){
            index = index == 0 || (index != nums.length && nums[index] < nums[index - 1]) ? index : index - 1;
            nums[index] = -nums[index];
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        Z5ReverseMax test = new Z5ReverseMax();
        // 6
        System.out.println(test.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        // 11
        System.out.println(test.largestSumAfterKNegations(new int[]{-2, 5, 0, 2, -2}, 3));
        // 5
        System.out.println(test.largestSumAfterKNegations(new int[]{-4, -2, -3}, 4));
    }
}
