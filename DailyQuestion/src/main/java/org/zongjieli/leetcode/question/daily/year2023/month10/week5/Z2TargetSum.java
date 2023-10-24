package org.zongjieli.leetcode.question.daily.year2023.month10.week5;

/**
 * 有 n 个一样的骰子,每个骰子上都有 k 个面,分别标号为 1 到 k
 * 给定三个整数 n, k 和 target,返回可能的方式(从总共 k^n 种方式中)滚动骰子的数量
 * 使正面朝上的数字之和等于 target
 * 答案可能很大,需要对 10^9 + 7 取模
 *
 * 1 <= n, k <= 30
 * 1 <= target <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/24
 */
public class Z2TargetSum {

    public int numRollsToTarget(int n, int k, int target) {
        int max = n * k;
        if (max < target) {
            return 0;
        }
        int[] values = new int[max + 1];
        values[0] = 1;
        while (n-- > 0) {
            int[] next = new int[max + 1];
            for (int i = 1; i <= k; i++) {
                for (int j = max - k ; j >= 0 ; j--) {
                    next[i + j] = (next[i + j] + values[j]) % 1000000007;
                }
            }
            values = next;
        }
        return values[target];
    }

    public static void main(String[] args) {
        Z2TargetSum test = new Z2TargetSum();
        // 1
        System.out.println(test.numRollsToTarget(1, 6, 3));
        // 0
        System.out.println(test.numRollsToTarget(1, 2, 3));
        // 22616187
        System.out.println(test.numRollsToTarget(30, 30, 500));
    }

}
