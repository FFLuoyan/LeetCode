package org.zongjieli.leetcode.question.daily.year2023.month1.week3;


/**
 * 给定一个由正整数组成的数组 nums
 * 数字序列的最大公约数定义为序列中所有整数的共有约数中的最大整数
 * 例如,序列 [4,6,16] 的最大公约数是 2
 * 数组的一个子序列本质是一个序列,可以通过删除数组中的某些元素(或者不删除)得到
 * 例如,[2, 5, 10] 是 [1, 2, 1, 2, 4, 1, 5, 10] 的一个子序列
 * 计算并返回 nums 的所有非空子序列中不同最大公约数的数目
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 2 * 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/14
 */
public class Z6DiffMaxCommonCount {

    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = 0, result = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        boolean[] exists = new boolean[max + 1];
        for (int num : nums) {
            if (!exists[num]) {
                exists[num] = true;
                result++;
            }
        }
        for (int i = 1 ; i <= max ; i++) {
            if (exists[i]) {
                continue;
            }
            int current = i, common;
            while ((current += i) <= max && !exists[current]) {}
            if (current > max) {
                continue;
            }
            common = current;
            while (common != i && (current += i) <= max) {
                if (exists[current]) {
                    common = common(common, current);
                }
            }
            if (!exists[common]) {
                exists[common] = true;
                result++;
            }
        }
        return result;
    }

    public int common(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return common(b, a % b);
    }

    public static void main(String[] args) {
        Z6DiffMaxCommonCount test = new Z6DiffMaxCommonCount();
        // 5
        System.out.println(test.countDifferentSubsequenceGCDs(new int[]{6, 10, 3}));
        // 2
        System.out.println(test.countDifferentSubsequenceGCDs(new int[]{5, 15}));
        // 7
        System.out.println(test.countDifferentSubsequenceGCDs(new int[]{5, 15, 40, 5, 6}));
    }

}
