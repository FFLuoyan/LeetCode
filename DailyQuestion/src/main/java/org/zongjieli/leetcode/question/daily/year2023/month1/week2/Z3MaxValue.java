package org.zongjieli.leetcode.question.daily.year2023.month1.week2;

/**
 * 给定三个正整数 n、index 和 maxSum
 * 需要构造一个同时满足下述所有条件的数组 nums(下标从 0 开始计数):
 *  nums.length == n
 *  nums[i] 是正整数,其中 0 <= i < n
 *  abs(nums[i] - nums[i+1]) <= 1,其中 0 <= i < n-1
 *  nums 中所有元素之和不超过 maxSum
 *  nums[index] 的值被最大化
 * 返回所构造的数组中的 nums[index]
 * 注意: abs(x) 等于 x 的前提是 x >= 0,否则 abs(x) 等于 -x
 * 1 <= n <= maxSum <= 10^9
 * 0 <= index < n
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/4
 */
public class Z3MaxValue {

    public int maxValue(int n, int index, int maxSum) {
        if ((maxSum -= n) <= 1) {
            return maxSum + 1;
        }
        // 双边递增
        int doubleAdd = Math.min(index, n - 1 - index);
        long doubleAddMax = (1L + doubleAdd) * (doubleAdd + 1);
        if (doubleAddMax == maxSum) {
            return doubleAdd + 2;
        }
        if (doubleAddMax > maxSum) {
            // 双边递增中出现最大值, x^2 + x
            return  (int) Math.sqrt(maxSum) + 1;
        }
        // 单边递增,当前总和 doubleMax
        int singleAddBase = 2 * doubleAdd + 2;
        int singleAddCount = Math.max(index, n - 1 - index) - doubleAdd;
        // 1/2 x^2 + (2 * singleAddBase - 1) / 2 * x
        // 1/2 ((x + singleBase - 1/2)^2 - (singleBase - 1/2)^2)
        long singleAddMax = (((long) singleAddBase) + singleAddBase - 1 + singleAddCount) * singleAddCount / 2;
        if (singleAddMax + doubleAddMax == maxSum) {
            return doubleAdd + 2 + singleAddCount;
        }
        if (singleAddMax + doubleAddMax > maxSum) {
            // 单边递增时出现最大值
            return (int) (Math.sqrt(2 * (maxSum - doubleAddMax) + (singleAddBase - 0.5) * (singleAddBase - 0.5)) - singleAddBase + 0.5) + doubleAdd + 2;
        }
        // 无递增
        return (int) (doubleAdd + 2 + singleAddCount + (maxSum - singleAddMax - doubleAddMax) / n);
    }

    public static void main(String[] args) {
        Z3MaxValue test = new Z3MaxValue();
        // 1
        System.out.println(test.maxValue(4, 0, 4));
        // 3
        System.out.println(test.maxValue(6, 1, 10));
        // 2
        System.out.println(test.maxValue(3, 1, 5));
        // 4
        System.out.println(test.maxValue(3, 2, 9));
        // 3
        System.out.println(test.maxValue(3, 2, 8));
        // 7
        System.out.println(test.maxValue(3, 2, 18));
        // 4
        System.out.println(test.maxValue(8, 7, 14));
        // 7
        System.out.println(test.maxValue(6, 0, 27));
    }
}
