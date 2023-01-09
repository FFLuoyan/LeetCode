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
        /*
            对于每个下标 i,操作后的下标 j 为
                i 在数组的前半段,即 i < n / 2 时,j = 2i
                i 在数组的后半段,及 i >= 2 / 2 时,j = 2 * (i - n / 2) + 1
            当 i == 0 或 i == n - 1 时,位置恒定不变
            对于其余位置,则有,j = 2i mod (n - 1)
            设经过 k 次移动后返回原位置
            有 f^k(i) = (i * 2^k) mod (n - 1) = i
            当 i == 1 时,有 (2^k) mod (n - 1) = 1
            则对于 i ∈ (0, n - 1) 时, i * (2^k) mod (n - 1) === i * 1
         */
        if (n == 2) {
            return 1;
        }
        int current = 1, count = 1;
        while ((current = (2 * current) % (n - 1)) != 1) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Z1ReductionPermutation test = new Z1ReductionPermutation();
        // 1
        System.out.println(test.reinitializePermutation(1000));
    }
}
