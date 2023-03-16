package org.zongjieli.leetcode.question.daily.year2023.month3.week3;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个长度为 n 的数组 nums,该数组由从 1 到 n 的不同整数组成,另给定一个正整数 k
 * 统计并返回 nums 中的中位数等于 k 的非空子数组的数目
 * 注意:
 * 数组的中位数是按递增顺序排列后位于中间的那个元素
 * 如果数组长度为偶数,则中位数是位于中间靠左的那个元素
 * 例如,[2, 3, 1, 4] 的中位数是 2,[8, 4, 3, 5, 1] 的中位数是 4
 * 子数组是数组中的一个连续部分
 *
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i], k <= n
 * nums 中的整数互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/16
 */
public class Z4MedianCount {

    public int countSubarrays(int[] nums, int k) {
        // 奇数下标在 1,偶数下标在 0
        Map<Integer, Integer>[] count = new Map[2];
        count[0] = new HashMap<>();
        count[1] = new HashMap<>();
        int current = 0, result = 0, ki = 0;
        count[1].put(0, 1);
        while (ki < nums.length) {
            int num = nums[ki];
            if (num == k) {
                /*
                    ki 为奇数
                    则奇数下标形成的子数组长度为偶数
                    偶数下标形成的子数组长度为奇数
                    ki 为偶数
                    则偶数下标形成的子数组长度为偶数
                    奇数下标形成的子数组长度为奇数
                 */
                result += count[(ki & 1) ^ 1].get(current);
                result += count[ki & 1].getOrDefault(current - 1, 0);
                break;
            } else if (num < k) {
                current--;
            } else {
                current++;
            }
            count[ki & 1].merge(current, 1, Integer::sum);
            ki++;
        }
        int compare = current, ci = ki;
        current = 0;
        while (++ki < nums.length) {
            if (nums[ki] > k) {
                current++;
            } else {
                current--;
            }
            int length = ki - ci + 1;
            // length 为子数组长度奇偶性
            if ((length & 1) == 0) {
                /*
                    length 长度为偶数时
                    如果 ci 为偶数,则奇数下标形成的子数组长度为偶数
                    如果 ci 为奇数,则奇数下标形成的子数组长度为奇数
                 */
                result += count[ci & 1].getOrDefault(compare + current, 0);
                result += count[(ci & 1) ^ 1].getOrDefault(compare + current - 1, 0);
            } else {
                /*
                    length 长度为奇数时
                    如果 ci 为奇数,则偶数下标形成的子数组长度为奇数
                    如果 ci 为偶数,则偶数下标形成的子数组长度为偶数
                 */
                result += count[(ci & 1) ^ 1].getOrDefault(compare + current, 0);
                result += count[ci & 1].getOrDefault(compare + current - 1, 0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z4MedianCount test = new Z4MedianCount();
        // 3
        System.out.println(test.countSubarrays(new int[]{3, 2, 1, 4, 5}, 4));
        // 1
        System.out.println(test.countSubarrays(new int[]{2, 3, 1}, 3));
        // 3
        System.out.println(test.countSubarrays(new int[]{2, 5, 1, 4, 3, 6}, 1));
        // 1
        System.out.println(test.countSubarrays(new int[]{10, 3, 8, 5, 6, 7, 2, 9, 4, 1}, 9));
    }

}
