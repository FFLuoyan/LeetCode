package org.zongjieli.leetcode.question.daily.year2023.month1.week2;

/**
 * 给定一个整数数组 nums(下标从 0 开始计数)以及两个整数:low 和 high,请返回漂亮数对的数目
 * 漂亮数对是一个形如 (i, j) 的数对,其中 0 <= i < j < nums.length
 * 且 low <= (nums[i] XOR nums[j]) <= high
 *
 * 1 <= nums.length <= 2 * 10^4
 * 1 <= nums[i] <= 2 * 10^4
 * 1 <= low <= high <= 2 * 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/5
 */
public class Z4BeautifulPair {
    public int countPairs(int[] nums, int low, int high) {
        int[] count = new int[32768];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                count[nums[i] ^ nums[j]]++;
            }
        }
        int result = 0;
        for (int i = low ; i <= high ; i++) {
            result += count[i];
        }
        return result;
    }
}
