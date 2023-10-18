package org.zongjieli.leetcode.question.daily.year2023.month10.week4;

import java.util.Arrays;

/**
 * 给定一个下标从 0 开始的整数数组 nums 和一个整数 k,起始分数为 0
 * 在一步操作中:
 *  选出一个满足 0 <= i < nums.length 的下标 i
 *  将分数增加 nums[i],并且将 nums[i] 替换为 ceil(nums[i] / 3)
 * 返回在恰好执行 k 次操作后,可能获得的最大分数
 * 向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数
 *
 * 1 <= nums.length, k <= 10^5
 * 1 <= nums[i] <= 10^9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/18
 */
public class Z3MaxScore {

    public long maxKelements(int[] nums, int k) {
        int min = 1, max = 1000000002;
        long[] values = new long[2];
        while (min < max) {
            int middle = (min + max) / 2;
            values = getValues(nums, middle);
            if (values[0] == k) {
                return values[2];
            } else if (values[0] > k) {
                min = middle + 1;
            } else {
                max = middle;
            }
        }
        return values[2] + (k - values[0]) * values[1];
    }

    public long[] getValues(int[] nums, int max) {
        // count, max, score
        long[] values = new long[3];
        for (int num : nums) {
            while (num > max) {
                values[2] += num;
                num = (num - 1) / 3 + 1;
                values[0]++;
            }
            values[1] = Math.max(values[1], num);
        }
        return values;
    }

    public static void main(String[] args) {
        int[] values = new int[10000];
        Arrays.fill(values, 1000000000);
        Z3MaxScore test = new Z3MaxScore();
        // 70000000000
        System.out.println(test.maxKelements(values, 70));
    }

}
