package org.zongjieli.leetcode.competion.doubleweekly.order115;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个下标从 0 开始的非负整数数组 nums 和两个整数 l 和 r
 * 请返回 nums 中子多重集合的和在闭区间 [l, r] 之间的子多重集合的数目
 * 由于答案可能很大,请将答案对 10^9 + 7 取余后返回
 * 子多重集合指的是从数组中选出一些元素构成的无序集合
 * 每个元素 x 出现的次数可以是 0, 1, ..., occ[x] 次
 * 其中 occ[x] 是元素 x 在数组中的出现次数
 * 注意,如果两个子多重集合中的元素排序后一模一样,那么它们两个是相同的子多重集合
 * 空集合的和是 0
 *
 * 1 <= nums.length <= 2 * 10^4
 * 0 <= nums[i] <= 2 * 10^4
 * nums 的和不超过 2 * 10^4
 * 0 <= l <= r <= 2 * 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/18
 */
public class O115N4CombinationCount {

    public int countSubMultisets(List<Integer> nums, int l, int r) {
        int[] values = new int[r + 1];
        for (Integer num : nums) {
            if (num <= r) {
                values[num]++;
            }
        }
        int[] result = new int[r + 1];
        result[0] = values[0] + 1;
        for (int i = 1; i <= r; i++) {
            if (values[i] == 0) {
                continue;
            }
            if (values[i] == 1) {
                for (int j = r - i ; j >= 0 ; j--) {
                    result[j + i] = (result[j + i] + result[j]) % 1000000007;
                }
                continue;
            }
            int[] resultNext = new int[r + 1];
            for (int j = 0; j <= values[i]; j++) {
                int sub = j * i;
                for (int k = r - sub ; k >= 0 ; k--) {
                    resultNext[k + sub] = (resultNext[k + sub] + result[k]) % 1000000007;
                }
            }
            result = resultNext;
        }
        int res = 0;
        for (int i = l; i <= r ; i++) {
            res = (result[i] + res) % 1000000007;
        }
        return res;
    }

    public static void main(String[] args) {
        O115N4CombinationCount test = new O115N4CombinationCount();
        // 1
        System.out.println(test.countSubMultisets(Arrays.asList(1, 2, 2, 3), 6, 6));
        // 7
        System.out.println(test.countSubMultisets(Arrays.asList(2, 1, 4, 2, 7), 1, 5));
    }
}
