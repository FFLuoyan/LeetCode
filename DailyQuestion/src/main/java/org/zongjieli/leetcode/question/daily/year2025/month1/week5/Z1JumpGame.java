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
        boolean[] checked = new boolean[nums.length];
        int step = 0, max = 0;
        while (max < nums.length - 1) {
            step++;
            for (int j = max ; j >= 0 && !checked[j]; j--) {
                checked[j] = true;
                max = Math.max(max, j + nums[j]);
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Z1JumpGame test = new Z1JumpGame();
        // 4
        System.out.println(test.jump(new int[]{2, 3, 1, 1, 4}));
    }

}
