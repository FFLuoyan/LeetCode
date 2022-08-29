package org.zongjieli.leetcode.question.daily.year2022.month8.week5;
/**
 * 给定一个数组 nums,数组中有 2n 个元素
 * 按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列
 * 请将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列,返回重排后的数组
 *
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 *
 * @author   Li.zongjie
 * @date     2022/8/29
 * @version  1.0
 */
public class Z1ReformatArray {

    public int[] shuffle(int[] nums, int n) {
        int l = 2 * n;
        int[] result = new int[l];
        for (int i = 0 ; i < n ; i++) {
            result[i << 1] = nums[i];
        }
        for (int i = n ; i < l ; i++) {
            result[2 * (i - n) + 1] = nums[i];
        }
        return result;
    }
}
