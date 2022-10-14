package org.zongjieli.leetcode.question.daily.year2022.month10.week3;

/**
 * 给定一个长度为 n 的整数数组 arr,它表示在 [0, n - 1] 范围内的整数的排列
 * 将 arr 分割成若干块(即分区),并对每个块单独排序
 * 将它们连接起来后,使得连接的结果和按升序排序后的原数组相同
 * 返回数组能分成的最多块数量
 *
 * n == arr.length
 * 1 <= n <= 10
 * 0 <= arr[i] < n
 * arr 中每个元素都不同
 *
 * @author   Li.zongjie
 * @date     2022/10/13
 * @version  1.0
 */
public class Z4MostSortBlock {

    public int maxChunksToSorted(int[] arr) {
        int result = 0, max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (i == (max = Math.max(max, arr[i]))) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z4MostSortBlock test = new Z4MostSortBlock();
        // 2
        System.out.println(test.maxChunksToSorted(new int[]{1, 2, 0, 3}));
    }
}
