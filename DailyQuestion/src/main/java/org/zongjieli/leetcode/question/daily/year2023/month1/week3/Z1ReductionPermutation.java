package org.zongjieli.leetcode.question.daily.year2023.month1.week3;

/**
 * 给定一个偶数 n,已知存在一个长度为 n 的排列 perm
 * 其中 perm[i] == i(下标从 0 开始计数)
 * 一步操作中,将创建一个新数组 arr,对于每个 i:
 *  如果 i % 2 == 0,那么 arr[i] = perm[i / 2]
 *  如果 i % 2 == 1,那么 arr[i] = perm[n / 2 + (i - 1) / 2]
 * 然后将 arr 赋值给 perm
 * 返回想使 perm 回到排列初始值需要执行的最小的非零操作步数
 *
 * 2 <= n <= 1000
 * n 是一个偶数
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/9
 */
public class Z1ReductionPermutation {

    public int reinitializePermutation(int n) {
        int hn = n / 2;
        int[] values = new int[n];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
        boolean isInitialization = false;
        int count = 0;
        while (!isInitialization) {
            isInitialization = true;
            int[] next = new int[n];
            for (int i = 0; i < next.length; i += 2) {
                if ((next[i] = values[i / 2]) != i) {
                    isInitialization = false;
                }
            }
            for (int i = 1; i < next.length; i += 2) {
                if ((next[i] = values[hn + (i - 1) / 2]) != i) {
                    isInitialization = false;
                }
            }
            count++;
            values = next;
        }
        return count;
    }

}
