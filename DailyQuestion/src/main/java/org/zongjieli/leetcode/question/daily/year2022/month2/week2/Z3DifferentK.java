package org.zongjieli.leetcode.question.daily.year2022.month2.week2;

/**
 * 给定一个整数数组 nums 和一个整数 k
 * 请你返回数对 (i, j) 的数目
 * 满足 i < j 且 |nums[i] - nums[j]| == k
 *
 * |x| 的值定义为:
 *  如果 x >= 0,那么值为 x
 *  如果 x < 0,那么值为 -x
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 1 <= k <= 99
 *
 * @author   Li.zongjie
 * @date     2022/2/9
 * @version  1.0
 */
public class Z3DifferentK {
    public int countKDifference(int[] nums, int k) {
        int[] count = new int[101 + 2 * k];
        int result = 0;
        for (int num : nums) {
            count[num]++;
            result += count[num = (num + k)];
            count[num + k]++;
        }
        return result;
    }

    public static void main(String[] args) {
        Z3DifferentK test = new Z3DifferentK();
        // 3
        System.out.println(test.countKDifference(new int[]{3, 2, 1, 5, 4}, 2));
    }
}
