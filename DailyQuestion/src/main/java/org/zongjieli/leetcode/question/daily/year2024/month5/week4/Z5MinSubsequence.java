package org.zongjieli.leetcode.question.daily.year2024.month5.week4;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个正整数 k,返回长度为 k 且最具竞争力的 nums 子序列
 * 数组的子序列是从数组中删除一些元素(可能不删除元素)得到的序列
 * 在子序列 a 和子序列 b 第一个不相同的位置上
 *  如果 a 中的数字小于 b 中对应的数字,那么我们称子序列 a 比子序列 b(相同长度下)更具竞争力
 * 例如,[1,3,4] 比 [1,3,5] 更具竞争力,在第一个不相同的位置,也就是最后一个位置上,4 小于 5
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 1 <= k <= nums.length
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/5/25
 */
public class Z5MinSubsequence {

    public int[] mostCompetitive(int[] nums, int k) {
        int minIndex = nums.length - k;
        int[] minIndexes = new int[nums.length];
        for (int i = minIndex ; i >= 0 ; i--) {
            if (nums[i] <= nums[minIndex]) {
                minIndex = i;
            }
            minIndexes[i] = minIndex;
        }

        int lastMinIndex = -1;
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            // i 下标对应的 result 为 (lastMinIndex, nums.length - k + i] 这个区间的 nums 中的最小值
            int compareIndex = nums.length - k + i, compareValue = nums[compareIndex];
            minIndexes[compareIndex] = compareIndex;
            for (int j = compareIndex - 1; j > lastMinIndex && nums[minIndexes[j]] > compareValue; j--) {
                minIndexes[j] = compareIndex;
            }
            lastMinIndex = minIndexes[lastMinIndex + 1];
            result[i] = nums[lastMinIndex];
        }
        return result;
    }

    public static void main(String[] args) {
        Z5MinSubsequence test = new Z5MinSubsequence();
        // [2, 6]
//        System.out.println(Arrays.toString(test.mostCompetitive(new int[]{3, 5, 2, 6}, 2)));
        // [3, 18, 67, 51, 79, 44, 69, 16, 0, 20, 89, 43, 4, 13, 22, 62, 54, 61, 64, 18, 53, 98, 84, 48, 17, 73]
        System.out.println(Arrays.toString(test.mostCompetitive(new int[]{70, 3, 34, 32, 18, 67, 51, 79, 44, 69, 16, 0, 20, 89, 43, 4, 13, 22, 62, 54, 61, 64, 18, 53, 98, 84, 48, 17, 73}, 26)));
    }

}
