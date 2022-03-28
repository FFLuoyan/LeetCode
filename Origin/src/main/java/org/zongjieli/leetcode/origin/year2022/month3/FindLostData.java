package org.zongjieli.leetcode.origin.year2022.month3;

import java.util.Arrays;

/**
 * 现有一份 n + m 次投掷单个六面骰子的观测数据,骰子的每个面从 1 到 6 编号
 * 观测数据中缺失了 n 份,现在只拿到剩余 m 次投掷的数据
 * 幸好之前计算过的这 n + m 次投掷数据的平均值
 *
 * 给定一个长度为 m 的整数数组 rolls,其中 rolls[i] 是第 i 次观测的值
 * 同时给定两个整数 mean 和 n
 *
 * 返回一个长度为 n 的数组,包含所有缺失的观测数据
 * 且满足这 n + m 次投掷的平均值是 mean
 * 如果存在多组符合要求的答案,只需要返回其中任意一组即可
 * 如果不存在答案,返回一个空数组
 *
 * k 个数字的平均值为这些数字求和后再除以 k
 *
 * 注意 mean 是一个整数,所以 n + m 次投掷的总和需要被 n + m 整除
 *
 * m == rolls.length
 * 1 <= n, m <= 10^5
 * 1 <= rolls[i], mean <= 6
 *
 * @author   Li.zongjie
 * @date     2022/3/28
 * @version  1.0
 */
public class FindLostData {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int remain = (rolls.length + n) * mean;
        for (int roll : rolls) {
            remain -= roll;
        }
        if (remain < n || remain > 6 * n) {
            return new int[0];
        }
        int[] result = new int[n];
        while (remain >= n + 5) {
            result[--n] = 6;
            remain -= 6;
        }
        while (--n >= 0) {
            result[n] = 1;
            remain--;
        }
        result[0] += remain;
        return result;
    }

    public static void main(String[] args) {
        FindLostData test = new FindLostData();
        // [6, 6]
        System.out.println(Arrays.toString(test.missingRolls(new int[]{3, 2, 4, 3}, 4, 2)));
    }
}
