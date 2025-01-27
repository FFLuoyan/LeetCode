package org.zongjieli.leetcode.question.daily.year2025.month1.week5;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums,初始位置为 nums[0]
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度
 * 换句话说,如果在 nums[i] 处,可以跳转到任意 nums[i + j] 处:
 *  0 <= j <= nums[i]
 *  i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数,生成的测试用例可以到达 nums[n - 1]
 *
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n - 1]
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/1/27
 */
public class Z1JumpGame {

    public int jump(int[] nums) {
        int next, length = nums.length;
        int[] count = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = nums[i] ; j > 0 ; j--) {
                if ((next = i + j) < length && (count[next] == 0 || count[next] > count[i] + 1)) {
                    count[next] = count[i] + 1;
                }
            }
        }
        return count[length - 1];
    }

}
