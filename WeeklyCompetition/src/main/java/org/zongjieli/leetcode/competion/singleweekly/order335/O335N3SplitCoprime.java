package org.zongjieli.leetcode.competion.singleweekly.order335;

/**
 * 给定一个长度为 n 的整数数组 nums,下标从 0 开始
 * 如果在下标 i 处分割数组,其中 0 <= i <= n - 2
 * 使前 i + 1 个元素的乘积和剩余元素的乘积互质,则认为该分割有效
 * 例如,如果 nums = [2, 3, 3],那么在下标 i = 0 处的分割有效,因为 2 和 9 互质
 * 而在下标 i = 1 处的分割无效,因为 6 和 3 不互质
 * 在下标 i = 2 处的分割也无效,因为 i == n - 1
 * 返回可以有效分割数组的最小下标 i,如果不存在有效分割,则返回 -1
 * 当且仅当 gcd(val1, val2) == 1 成立时,val1 和 val2 这两个值才是互质的
 * 其中 gcd(val1, val2) 表示 val1 和 val2 的最大公约数
 *
 * n == nums.length
 * 1 <= n <= 10^4
 * 1 <= nums[i] <= 10^6
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/5
 */
public class O335N3SplitCoprime {

    public int findValidSplit(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1 && i <= max && max < nums.length - 1; i++) {
            int num = nums[i];
            for (int j = max + 1 ; j < nums.length ; j++) {
                if (common(num, nums[j]) != 1) {
                    max = j;
                }
            }
        }
        return max == nums.length - 1 ? -1 : max;
    }

    public int common(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return common(b, a % b);
    }

    public static void main(String[] args) {
        O335N3SplitCoprime test = new O335N3SplitCoprime();
        // 2
        System.out.println(test.findValidSplit(new int[]{4, 7, 8, 15, 3, 5}));
        // -1
        System.out.println(test.findValidSplit(new int[]{4, 7, 15, 8, 3, 5}));
    }
}
