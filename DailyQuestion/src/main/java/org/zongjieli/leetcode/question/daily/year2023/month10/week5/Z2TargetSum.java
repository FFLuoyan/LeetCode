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

    int k;

    boolean[][] exist;

    int[][] values;

    public int numRollsToTarget(int n, int k, int target) {
        this.k = k;
        int max = n * k;
        if (max < target) {
            return 0;
        }
        exist = new boolean[n + 1][++max];
        values = new int[n + 1][max];
        for (int i = 2 ; i < k ; i++) {
            exist[1][i] = true;
            values[1][i] = 1;
        }
        for (int i = 1 ; i <= n ; i++) {
            exist[i][i] = true;
            exist[i][i * k] = true;
            values[i][i] = 1;
            values[i][i * k] = 1;
            for (int j = i * k + 1 ; j < max ; j++) {
                exist[i][j] = true;
            }
        }
        return count(n, target);
    }

    public int count(int n, int target) {
        if (exist[n][target]) {
            return values[n][target];
        }
        exist[n][target] = true;
        long result = 0;
        for (int current = Math.min(target - n + 1, k) ; current >= 1 ; current--) {
            result += count(n - 1, target - current);
        }
        return values[n][target] = (int) (result % 1000000007);
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
