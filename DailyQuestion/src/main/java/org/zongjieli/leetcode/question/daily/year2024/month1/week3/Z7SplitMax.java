package org.zongjieli.leetcode.question.daily.year2024.month1.week3;

/**
 * 给定一个非负整数数组 nums 和一个整数 k
 * 需要将这个数组分成 k 个非空的连续子数组
 * 设计一个算法使得这 k 个子数组各自和的最大值最小
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 10^6
 * 1 <= k <= min(50, nums.length)
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/23
 */
public class Z7SplitMax {

    public int splitArray(int[] nums, int k) {
        int max = 1000000000, min = 0;
        while (max > min) {
            int check = (max + min) / 2, count = 1, sum = 0;
            for (int num : nums) {
                if (num > check) {
                    count = k + 1;
                    break;
                }
                if ((sum += num) > check) {
                    count++;
                    sum = num;
                }
            }
            if (count > k) {
                min = check + 1;
            } else {
                max = check;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Z7SplitMax test = new Z7SplitMax();
        // 18
        System.out.println(test.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }
}
