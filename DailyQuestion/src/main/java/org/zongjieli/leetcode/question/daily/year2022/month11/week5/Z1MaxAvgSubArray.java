package org.zongjieli.leetcode.question.daily.year2022.month11.week5;

/**
 * 给定数组 nums 和一个整数 k,将给定的数组 nums 分成最多 k 个相邻的非空子数组
 * 分数由每个子数组内的平均值的总和构成
 * 必须使用 nums 数组中的每一个数进行分组,并且分数不一定需要是整数
 * 返回所能得到的最大分数是多少,答案误差在 10^-6 内被视为是正确的
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/12
 */
public class Z1MaxAvgSubArray {

    public double largestSumOfAverages(int[] nums, int k) {
        double[][] save = new double[nums.length][k + 1];
        return largestSumOfAverages(nums, k, 0, save);
    }

    public double largestSumOfAverages(int[] nums, int k, int index, double[][] save) {
        int sum = 0;
        if (k == 1) {
            for (int i = index ; i < nums.length ; i++) {
                sum += nums[i];
            }
            return save[index][k] = 1d * sum / (nums.length - index);
        }
        double result = 0d;
        if (nums.length - index == k) {
            for (int i = index ; i < nums.length ; i++) {
                sum += nums[i];
            }
            return save[index][k] = sum;
        }
        for (int i = index ; i <= nums.length - k; i++) {
            double next = save[i + 1][k - 1] > 0 ? save[i + 1][k - 1] : largestSumOfAverages(nums, k - 1, i + 1, save);
            result = Math.max(result, (sum += nums[i]) / (i - index + 1d) + next);
        }
        return save[index][k] = result;
    }

    public static void main(String[] args) {
        Z1MaxAvgSubArray test = new Z1MaxAvgSubArray();
        // 20
        System.out.println(test.largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3));
    }
}
