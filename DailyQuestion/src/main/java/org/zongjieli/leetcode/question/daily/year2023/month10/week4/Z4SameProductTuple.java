package org.zongjieli.leetcode.question.daily.year2023.month10.week4;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个由不同正整数组成的数组 nums
 * 请返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量
 * 其中 a、b、c 和 d 都是 nums 中的元素,且 a != b != c != d
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 10^4
 * nums 中的所有元素互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/19
 */
public class Z4SameProductTuple {

    public int tupleSameProduct(int[] nums) {
        int result = 0, first, pair, length = nums.length;
        Map<Integer, Integer> pairValues = new HashMap<>();
        for (int i = 0; i < length; i++) {
            first = nums[i];
            for (int j = i + 1; j < length; j++) {
                pair = first * nums[j];
                result += (pairValues.merge(pair, 1, Integer::sum) - 1);
            }
        }
        return 8 * result;
    }

    public static void main(String[] args) {
        Z4SameProductTuple test = new Z4SameProductTuple();
        // 8
        System.out.println(test.tupleSameProduct(new int[]{2, 3, 4, 6}));
    }

}
