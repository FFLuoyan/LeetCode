package org.zongjieli.leetcode.question.daily.year2021.month10.week4;
/**
 * 给定一个长度为 n 的整数数组,每次操作将会使 n - 1 个元素增加 1
 * 返回让数组所有元素相等的最小操作次数
 *
 * n == nums.length
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 答案保证符合 32-bit 整数
 *
 * @author   Li.zongjie
 * @date     2021/10/20
 * @version  1.0
 */
public class Z3MinMove {
    public int minMoves(int[] nums) {
        int min = nums[0];
        int result = 0;
        for (int i = 1 ; i < nums.length ; i++){
            int distance = nums[i] - min;
            if (distance < 0){
                min = nums[i];
                result += - distance * i;
            } else {
                result += distance;
            }
        }
        return result;
    }
}
