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
        int hn = n / 2, next, current = 1, count = 1;
        while ((next = current < hn ? 2 * current : 2 * (current - hn) + 1) != 1) {
            count++;
            current = next;
        }
        return count;
    }

    public static void main(String[] args) {
        Z1ReductionPermutation test = new Z1ReductionPermutation();
        // 1
        System.out.println(test.reinitializePermutation(1000));
    }
}
