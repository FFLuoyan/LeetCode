package org.zongjieli.leetcode.question.daily.year2023.month2.week2;

/**
 * 有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数
 * 不过我们在使用它时有个约束,就是使得投掷骰子时,连续掷出数字 i 的次数不能超过 rollMax[i](i 从 1 开始编号)
 * 现在给定一个整数数组 rollMax 和一个整数 n,请计算掷 n 次骰子可得到的不同点数序列的数量
 * 假如两个序列中至少存在一个元素不同,就认为这两个序列是不同的
 * 由于答案可能很大,所以请返回模 10^9 + 7 之后的结果
 *
 * 1 <= n <= 5000
 * rollMax.length == 6
 * 1 <= rollMax[i] <= 15
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/10
 */
public class Z5Dice {

    public int dieSimulator(int n, int[] rollMax) {
        int[][] currentConsecutive = new int[6][16];
        for (int i = 0 ; i < 6 ; i++) {
            currentConsecutive[i][0] = 1;
        }
        while (--n > 0) {
            int[][] next = new int[6][16];
            for (int i = 0 ; i < 6 ; i++) {
                int[] consecutive = currentConsecutive[i];
                for (int j = 0 ; j < 6 ; j++) {
                    if (j != i) {
                        next[j][0] = (next[j][0] + consecutive[rollMax[i] - 1]) % 1000000007;
                    }
                }
                for (int j = 0 ; j < rollMax[i] - 1 ; j++) {
                    next[i][j + 1] = (consecutive[j] + next[i][j + 1]) % 1000000007;
                    for (int k = 0 ; k < 6 ; k++) {
                        if (k != i) {
                            next[k][0] = (next[k][0] + consecutive[j]) % 1000000007;
                        }
                    }
                }
            }
            currentConsecutive = next;
        }
        int result = 0;
        for (int[] consecutive : currentConsecutive) {
            for (int value : consecutive) {
                result = (result + value) % 1000000007;
            }
        }
        return result;
    }

}
